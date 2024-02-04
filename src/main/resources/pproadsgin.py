from flask import Flask, request, send_file, after_this_request
import subprocess
import os
import uuid

app = Flask(__name__)

# 图片保存目录
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
        filename = str(uuid.uuid4()) + '.png'
        filepath = os.path.join(UPLOAD_FOLDER, filename)
        file.save(filepath)

        # 执行命令
        subprocess.run([
            'python', 'tools/infer.py',
            '-c', 'configs/yolov3/yolov3_mobilenet_v1_roadsign.yml',
            '-o', 'use_gpu=false',
            '--save_result=True',
            '--draw_threshold=0.5',
            '--infer_img=' + filepath
        ], cwd='/home/PaddleDetection')

        # 删除原始文件
        os.remove(filepath)

        # 准备发送处理后的图片
        output_filepath = os.path.join(OUTPUT_FOLDER, filename)

        @after_this_request
        def remove_file(response):
            try:
                os.remove(output_filepath)
            except Exception as error:
                app.logger.error("Error removing or closing downloaded file handle", error)
            return response

        return send_file(output_filepath, as_attachment=True)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8868)
