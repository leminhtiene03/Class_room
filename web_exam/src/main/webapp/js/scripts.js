document.addEventListener("DOMContentLoaded", function() {
    const quizTypeSelect = document.getElementById("quiz-type");
    const specificDateContainer = document.getElementById("specific-date-container");

    quizTypeSelect.addEventListener("change", function() {
        if (this.value === "specific-date") {
            specificDateContainer.style.display = "block";
        } else {
            specificDateContainer.style.display = "none";
        }
    });

    const addQuestionBtn = document.getElementById("add-question");
    const questionsContainer = document.getElementById("questions-container");

    addQuestionBtn.addEventListener("click", function() {
        const questionDiv = document.createElement("div");
        questionDiv.classList.add("question");

        questionDiv.innerHTML = `
            <label for="question">Question</label>
            <input type="text" name="question">

            <div class="answers">
                <label for="answer-a">A</label>
                <input type="text" name="answer-a">
                <br>
                <label for="answer-b">B</label>
                <input type="text" name="answer-b">
                <br>
                <label for="answer-c">C</label>
                <input type="text" name="answer-c">
                <br>
                <label for="answer-d">D</label>
                <input type="text" name="answer-d">
            </div>

            <label id = "label_1"for="correct-answer">Correct Answer:</label>
            <select name="correct-answer">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
            </select>
            <br>
            <button type="button" class="delete-question">Delete</button>
        `;

        questionsContainer.appendChild(questionDiv);

        const deleteQuestionBtns = document.querySelectorAll(".delete-question");
        deleteQuestionBtns.forEach(btn => {
            btn.addEventListener("click", function() {
                this.parentElement.remove();
            });
        });
    });

   

    const specificDateInput = document.getElementById("specific-date");
    const startTimeInput = document.getElementById("start-time");
    const endTimeInput = document.getElementById("end-time");

    specificDateInput.addEventListener("change", function() {
        const date = this.value;
        const startTime = startTimeInput.value || "00:00";
        const endTime = endTimeInput.value || "23:59";

        startTimeInput.value = startTime;
        endTimeInput.value = endTime;
    });
});
