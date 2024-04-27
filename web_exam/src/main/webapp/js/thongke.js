







const examInfoData = {
    exam1: { name: 'Exam 1', description: 'Description for Exam 1', type: 'Type A' },
    exam2: { name: 'Exam 2', description: 'Description for Exam 2', type: 'Type B' },
    exam3: { name: 'Exam 3', description: 'Description for Exam 3', type: 'Type C' }
};

const examData = {
    exam1: [
        { name: 'Student 1', attendances: 5, completionRate: '100%', averageScore: 80, startDate: '2024-03-07', startTime: '08:00', endTime: '10:00' },
        { name: 'Student 2', attendances: 4, completionRate: '80%', averageScore: 75, startDate: '2024-03-07', startTime: '08:00', endTime: '10:00' }
    ],
    exam2: [
        { name: 'Student 3', attendances: 3, completionRate: '75%', averageScore: 70, startDate: '2024-03-08', startTime: '09:00', endTime: '11:00' },
        { name: 'Student 4', attendances: 6, completionRate: '100%', averageScore: 85, startDate: '2024-03-08', startTime: '09:00', eendTime: '11:00' }
    ],
    exam3: [
        { name: 'Student 5', attendances: 4, completionRate: '80%', averageScore: 75, startDate: '2024-03-09', startTime: '10:00', endTime: '12:00' },
        { name: 'Student 6', attendances: 5, completionRate: '100%', averageScore: 90, startDate: '2024-03-09', startTime: '10:00', endTime: '12:00' }
    ]
};

function filterCustomTable() {
    const selectedExam = document.getElementById('customExam').value;
    const examInfoDiv = document.getElementById('examInfo');
    const selectedExamInfo = examInfoData[selectedExam];

    examInfoDiv.innerHTML = `
            <h2>${selectedExamInfo.name}</h2>
            <p><strong>Description:</strong> ${selectedExamInfo.description}</p>
            <p><strong>Type:</strong> ${selectedExamInfo.type}</p>
        `;
    const examStatistics = examData[selectedExam];
    const customTableContent = document.getElementById('customTableContent');
    const filterName = document.getElementById('filterName').value.toLowerCase();
    const filterAttendances = document.getElementById('filterAttendancesSelect').value;
    const filterStartDate = document.getElementById('startDate').value;
    const filterCompletionRate = document.getElementById('completionRate').value;

    let customTableHtml = `<table>
                            <tr>
                                <th>Name</th>
                                <th>Attendances</th>
                                <th>Completion Rate</th>
                                <th>Average Score</th>
                                <th>Start Date</th>
                                <th>Start Time</th>
                                <th>End Time</th>
                            </tr>`;

    examStatistics.forEach(student => {
        const studentName = student.name.toLowerCase();
        const studentAttendances = student.attendances;
        const studentStartDate = student.startDate;
        const studentCompletionRate = student.completionRate;

        if (studentName.includes(filterName) &&
            (filterAttendances === '' || studentAttendances == filterAttendances) &&
            (filterStartDate === '' || studentStartDate === filterStartDate) &&
            (filterCompletionRate === '' || studentCompletionRate === filterCompletionRate)) {
            customTableHtml += `<tr>
                                <td>${student.name}</td>
                                <td>${student.attendances}</td>
                                <td>${student.completionRate}</td>
                                <td>${student.averageScore}</td>    
                                <td>${student.startDate}</td>
                                <td>${student.startTime}</td>
                                <td>${student.endTime}</td>
                            </tr>`;
        }
    });

    customTableHtml += '</table>';
    customTableContent.innerHTML = customTableHtml;
}

// Initial display
filterCustomTable();