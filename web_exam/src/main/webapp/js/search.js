// Sample student data
let students = [
    { id: 101, name: "John Doe", results: [
        { exam: "Math", score: 85, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 75, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 102, name: "Jane Smith", results: [
        { exam: "Math", score: 90, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 80, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 103, name: "Alice Johnson", results: [
        { exam: "Math", score: 70, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 85, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 104, name: "Michael Brown", results: [
        { exam: "Math", score: 95, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 90, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 105, name: "Emily Wilson", results: [
        { exam: "Math", score: 80, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 70, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 106, name: "David Lee", results: [
        { exam: "Math", score: 85, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 75, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 107, name: "Sophia Garcia", results: [
        { exam: "Math", score: 90, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 80, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 108, name: "Olivia Martinez", results: [
        { exam: "Math", score: 70, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 85, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 109, name: "Lucas Taylor", results: [
        { exam: "Math", score: 95, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 90, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]},
    { id: 110, name: "Benjamin Rodriguez", results: [
        { exam: "Math", score: 80, status: "Completed", date: "2024-03-14", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] },
        { exam: "English", score: 70, status: "Completed", date: "2024-03-15", answers: ["A", "B", "C"], correctAnswers: ["A", "B", "C"], explanations: ["Explanation 1", "Explanation 2", "Explanation 3"] }
    ]}
    // Add more student data as needed
];

function searchStudent() {
    const searchTerm = document.getElementById('but_top').value.toLowerCase();
    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = '';

    students.forEach(student => {
        if (student.name.toLowerCase().includes(searchTerm) || student.id.toString().includes(searchTerm)) {
            const studentDiv = document.createElement('div');
            studentDiv.innerHTML = `
                <h2>${student.name} (ID: ${student.id})</h2>
                <ul>
                    ${student.results.map((result, index) => `
                        <li>
                            <strong>${result.exam}</strong>: Score: ${result.score}, Status: ${result.status}, Date: ${result.date} 
                            <button onclick="showDetails(${student.id}, ${index})">View Details</button>
                            <button class="delete-btn" onclick="deleteResult(${student.id}, ${index})">Delete</button>
                        </li>
                    `).join('')}
                </ul>
            `;
            resultsDiv.appendChild(studentDiv);
        }
    });

    if (resultsDiv.innerHTML !== '') {
        resultsDiv.style.display = 'block';
    } else {
        resultsDiv.style.display = 'none';
    }

    document.getElementById("query").style.display="block";
}
function close_search (){
    document.getElementById("query").style.display="none";
}
function showDetails(studentId, resultIndex) {
    const student = students.find(s => s.id === studentId);
    const result = student.results[resultIndex];

    const detailResultDiv = document.getElementById('detailResult');
    detailResultDiv.innerHTML = `
        <h2>${student.name} (ID: ${student.id}) - ${result.exam}</h2>
        <p>Score: ${result.score}, Status: ${result.status}, Date: ${result.date}</p>
        <h3>Answers:</h3>
        <ul>
            ${result.answers.map((answer, index) => `
                <li>
                    <strong>Question ${index + 1}:</strong>
                    <div>
                        <span>Student's Answer: ${answer}</span><br>
                        <span>Correct Answer: ${result.correctAnswers[index]}</span>
                        <p>${result.explanations[index]}</p>
                    </div>
                </li>
            `).join('')}
        </ul>
    `;

    // Display the modal
    const modal = document.getElementById('detailsModal');
    modal.style.display = 'block';

    // Close the modal when clicking outside of it
    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };

    // Close the modal when clicking on the close button
    const closeBtn = document.getElementsByClassName("close")[0];
    closeBtn.onclick = function() {
        modal.style.display = "none";
    };
}

function deleteResult(studentId, resultIndex) {
    const confirmDelete = confirm("Are you sure you want to delete this result?");
    if (confirmDelete) {
        const studentIndex = students.findIndex(s => s.id === studentId);
        students[studentIndex].results.splice(resultIndex, 1);
        if (students[studentIndex].results.length === 0) {
            students.splice(studentIndex, 1);
        }
        searchStudent();
    }
}
