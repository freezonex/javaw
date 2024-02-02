document.addEventListener('DOMContentLoaded', function() {
    const video = document.getElementById('videoStream');
    const canvas = document.getElementById('canvas');
    const context = canvas.getContext('2d');

    navigator.mediaDevices.getUserMedia({ video: true })
        .then(stream => {
            video.srcObject = stream;
            setTimeout(captureImage, 5000); // Wait for the video to start playing
        })
        .catch(error => console.error('Error accessing the camera:', error));

    function captureImage() {
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;
        context.drawImage(video, 0, 0, video.videoWidth, video.videoHeight);

        canvas.toBlob(blob => {
            const formData = new FormData();
            formData.append('file', blob, 'capture.jpg');

            fetch('/apps/wenhao-javaw/upload', {
                method: 'POST',
                body: formData,
            })
                .then(response => response.json())
                .then(data => displayResults(data))
                .catch(error => console.error('Error:', error));
        }, 'image/jpeg');

        setTimeout(captureImage, 5000); // Capture image every 5 seconds
    }

    function displayResults(data) {
        const resultsContainer = document.getElementById('ocrResults');
        resultsContainer.innerHTML = ''; // Clear previous results

        let allTexts = '';

        data.result[0].forEach(item => {
            const [[, , ,], [text, confidence]] = item;
            allTexts += `${text} (Confidence: ${confidence.toFixed(3)})\n`;
        });

        const resultElement = document.createElement('div');
        resultElement.className = 'p-4 bg-white rounded shadow';
        resultElement.innerHTML = `<pre>${allTexts}</pre>`;
        resultsContainer.appendChild(resultElement);
    }
});