from flask import Flask, request, send_file, after_this_request
import subprocess
import os
import uuid

app = Flask(__name__)

# 设置上传和输出目录
UPLOAD_FOLDER = '/home/PaddleDetection/demo'
OUTPUT_FOLDER = '/home/PaddleDetection/output'

@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return 'No file part', 400
    file = request.files['file']
    if file.filename == '':
        return 'No selected file', 400
    if file:
        # 生成唯一的文件名
        filename = str(uuid.uuid4()) + '.png'
        filepath = os.path.join(UPLOAD_FOLDER, filename)
        file.save(filepath)
        
        # 构建命令行指令
        command = [
            'python', '/home/PaddleDetection/deploy/python/infer.py',
            '--model_dir=/home/inference_model/yolov3_darknet53_270e_coco',
            '--image_file=' + filepath
        ]
        
        # 执行命令
        subprocess.run(command)
        
        # 假设处理后的文件保存在 OUTPUT_FOLDER 中，且文件名不变
        output_filepath = os.path.join(OUTPUT_FOLDER, filename)

        # 删除原始上传文件
        os.remove(filepath)

        # 请求完成后删除处理后的文件
        @after_this_request
        def remove_file(response):
            try:
                os.remove(output_filepath)
            except Exception as error:
                app.logger.error("Error removing or closing downloaded file handle", error)
            return response

        # 发送处理后的文件
        return send_file(output_filepath, as_attachment=True)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8868)
