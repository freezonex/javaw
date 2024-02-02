from flask import Flask, request, jsonify
import paddleocr
import os
import logging

# 设置日志
logging.basicConfig(level=logging.INFO)

app = Flask(__name__)
ocr = paddleocr.PaddleOCR()

@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return jsonify({"error": "No file part"}), 400
    file = request.files['file']
    if file.filename == '':
        return jsonify({"error": "No selected file"}), 400
    if file:
        filename = os.path.join('/home/PaddleOCR', file.filename)
        try:
            file.save(filename)
            result = ocr.ocr(filename)
            os.remove(filename)  # Optionally, remove the file after processing
            return jsonify({"result": result}), 200
        except Exception as e:
            logging.error(f"Error processing file: {e}")
            return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=8868)