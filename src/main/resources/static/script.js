function validateForm() {
	var title = document.getElementById("title").value;
	var description = document.getElementById("description").value;
	var duedate = document.getElementById("dueDate").value;

	if (title.length < 6 || title.length > 35) {
		alert("Title should be between 5 and 30 characters.");
		return false;
	}

	if (description.length < 20 || description.length > 250) {
		alert("Description should be between 20 and 250 characters.");
		return false;
	}

	if (duedate == "") {
		alert("Due Date is required!");
		return false;
	}
}

function showAlert(message) {
	var alertDiv = document.createElement("div");
	alertDiv.className = "alert";
	alertDiv.textContent = message;
	document.body.appendChild(alertDiv);
	setTimeout(function() {
		alertDiv.style.display = "none";
	}, 3000); // Hide the alert after 3 seconds
}