var a = document.getElementById("countdown");
var n = a.value;


 var timeLeft = n * 60; // 30 minutes in seconds

        function countdown() {
			var hour = Math.floor(timeLeft/3600);
            var minutes = Math.floor(timeLeft / 60);
            var seconds = timeLeft % 60;

            document.getElementById("countdown").textContent =padZero(hour) + ":" + padZero(minutes) + ":" + padZero(seconds);

            if (timeLeft > 0) {
                timeLeft--;
                setTimeout(countdown, 1000);
            } else {
                document.getElementById("countdown").textContent = "00:00";
                showTimeUpMessage();
            }
        }

        function padZero(number) {
            return (number < 10 ? "0" : "") + number;
        }

        // Submit button click event
        var submitBtn = document.querySelector(".submit-btn");
        submitBtn.addEventListener("click", function () {
            showSubmitMessage();
        });

        // Functions to show messages
        function showSubmitMessage() {
            var messageDiv = document.querySelector(".message");
            messageDiv.textContent = "Bài làm đã được gửi!";
        }

        function showTimeUpMessage() {
            var messageDiv = document.querySelector(".message");
            messageDiv.textContent = "Hết giờ!";
        }

        // Start the countdown
        countdown();