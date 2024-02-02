document.getElementById('imageUpload').addEventListener('change', function(event) {
    const file = event.target.files[0];
    if (file) {
        // Display image preview
        const reader = new FileReader();
        reader.onload = function(e) {
            const preview = document.getElementById('imagePreview');
            preview.src = e.target.result;
            preview.classList.remove('hidden');
        };
        reader.readAsDataURL(file);

        // Prepare the file to be sent to the backend
        const formData = new FormData();
        formData.append('file', file);

        fetch('/apps/wenhao-javaw/upload', {
            method: 'POST',
            body: formData,
        })
            .then(response => response.json())
            .then(data => displayResults(data))
            .catch(error => console.error('Error:', error));
    }
});

function displayResults(data) {
    const resultsContainer = document.getElementById('ocrResults');
    resultsContainer.innerHTML = ''; // Clear previous results

    // 初始化一个空字符串来收集所有识别的文本
    let allTexts = '';

    data.result[0].forEach(item => {
        const [[, , ,], [text, confidence]] = item;
        // 将每个识别的文本和其置信度拼接到allTexts字符串
        allTexts += `${text} (Confidence: ${confidence.toFixed(3)})\n`;
    });

    // 创建一个新的div元素来显示所有文本
    const resultElement = document.createElement('div');
    resultElement.className = 'p-4 bg-white rounded shadow';
    // 使用<pre>标签来保留文本的换行
    resultElement.innerHTML = `<pre>${allTexts}</pre>`;
    resultsContainer.appendChild(resultElement);
}
