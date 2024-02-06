from flask import Flask, request, jsonify
import requests
import time
import json

app = Flask(__name__)

# 全局变量来存储授权信息和过期时间
auth_token = {"token": "", "expires_at": 0}
processed_messages = {}  # 用于跟踪已处理消息的字典


def get_tenant_access_token():
    global auth_token
    current_time = time.time()
    if auth_token["expires_at"] < current_time:
        url = 'https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal'
        headers = {'Content-Type': 'application/json'}
        data = json.dumps({
            "app_id": "cli_a54a5f79fe7ad00c",
            "app_secret": "nYZj3dZGWqIdSuAamm0FRhrWFZVWJUvt"
        })
        response = requests.post(url, headers=headers, data=data)
        response_data = response.json()
        if response_data.get("code") == 0:
            auth_token = {
                "token": "Bearer " + response_data["tenant_access_token"],
                "expires_at": current_time + 5000
            }
    return auth_token["token"]

def should_process_message(message_content):
    """检查消息是否应该被处理"""
    current_time = time.time()
    # 检查是否已处理过相同的消息内容且处理时间在5分钟内
    if message_content in processed_messages and current_time - processed_messages[message_content] < 300:
        return False
    # 更新消息处理时间
    processed_messages[message_content] = current_time
    # 定期清理缓存
    for msg in list(processed_messages):
        if current_time - processed_messages[msg] > 300:
            del processed_messages[msg]
    return True

@app.route('/', methods=['POST'])
def process_request():
    print("Received request:")
    print(request.json)

    if request.json and 'challenge code' in request.json:
        challenge_code = request.json['challenge code']
        return jsonify({'challenge code': challenge_code}), 200
    else:
        try:
            message_content = json.loads(request.json.get('event', {}).get('message', {}).get('content', '{}'))
            prompt_text = message_content.get('text', '')
            if not should_process_message(prompt_text):  # 使用should_process_message函数检查
                print("Duplicate message within 5 minutes, skipping.")
                return jsonify({"status": "skipped", "message": "Duplicate message within 5 minutes"}), 200
            message_id = request.json.get('event', {}).get('message', {}).get('message_id')

            forward_payload = {"model": "llama2", "prompt": prompt_text, "stream": False}
            response = requests.post('http://office.unibutton.com:11434/api/generate', json=forward_payload)
            response_data = response.json()

            if response.status_code == 200:
                token = get_tenant_access_token()
                reply_url = f'https://open.feishu.cn/open-apis/im/v1/messages/{message_id}/reply'
                headers = {'Authorization': token, 'Content-Type': 'application/json'}
                reply_payload = {
                    "content": json.dumps({"text": response_data.get('response', '')}),
                    "msg_type": "text",
                    "reply_in_thread": True
                }
                reply_response = requests.post(reply_url, headers=headers, data=json.dumps(reply_payload))

                # 打印返回的消息日志
                print("Reply sent with status code:", reply_response.status_code)
                return jsonify({"status": "success", "message": "Reply sent"}), 200
            else:
                return jsonify({"error": "Failed to process the forward request"}), response.status_code
        except Exception as e:
            print(f"Error: {e}")
            return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8868)

