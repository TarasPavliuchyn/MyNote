$(document).ready(function() {

	/* Registration validation */
	var registr_form = $("#signupform");
	registr_form.submit(function() {
		removeErrors();
		var res = true;
		if (!isValidLogin($("#login")))
			res = false;
		if (!isValidPassword($("#password")))
			res = false;
		if (!isConfirmPasswordEqualPassword())
			res = false;
		return res;
	});

	var add_note = $("#addNote");
	add_note.submit(function() {
		removeErrors();
		var res = true;
		if (!isValidFirstName($("#firstName")))
			res = false;
		if (!isValidLastName($("#lastName")))
			res = false;
		if (!isValidMiddleName($("#patronymic")))
			res = false;
		if (!isValidComment($("#comment"), $("#type")))
			res = false;
		return res;
	});
});

function isValidFirstName(name) {
	var reg = new RegExp("^[a-zA-Z]+$");
	if (name.val() === "") {
		name.after("<span class='error'>First name is required</span>");
		res = false;
	} else if (name.val().length < 2) {
		name
				.after("<br><span class='error'>Please enter at least 2 symbols</span>");
		return false;
	} else if (name.val().length > 25) {
		name
				.after("<span class='error'>Please enter less then 25 symbols</span>");
		return false;
	} else if (!reg.test(name.val())) {
		name
				.after("<span class='error'>First name can consist only latin alphabet. </span>");
		return false;
	} else {
		return true;
	}
}

function isValidComment(comment) {
	if (comment.val() === "") {
		comment.after("<span class='error'>Description  is required</span>");
		res = false;
	} else if (comment.val().length < 2) {
		comment
				.after("<span class='error'>Please enter at least 2 symbols</span>");
		return false;
	} else if (comment.val().length > 25) {
		comment
				.after("<span class='error'>Please enter less then 25 symbols</span>");
		return false;
	} else {
		return true;
	}
}

function isValidLastName(name) {
	var reg = new RegExp("^[a-zA-Z]+$");
	if (name.val() === "") {
		name.after("<span class='error'>Last mame is required</span>");
		res = false;
	} else if (name.val().length < 2) {
		name
				.after("<span class='error'>Please enter at least 2 symbols</span>");
		return false;
	} else if (name.val().length > 25) {
		name
				.after("<span class='error'>Please enter less then 25 symbols</span>");
		return false;
	} else if (!reg.test(name.val())) {
		name
				.after("<span class='error'>Last name can consist only latin alphabet. </span>");
		return false;
	} else {
		return true;
	}
}

function isValidMiddleName(midname) {
	var reg = new RegExp("^[a-zA-Z]+$");
	if (midname.val() === "") {
		midname.after("<span class='error'>Middle Name is required</span>");
		res = false;
	} else if (midname.val().length < 2) {
		midname
				.after("<span class='error'>Please enter at least 2 symbols</span>");
		return false;
	} else if (midname.val().length > 25) {
		midname
				.after("<span class='error'>Please enter less then 25 symbols</span>");
		return false;
	} else if (!reg.test(midname.val())) {
		midname
				.after("<span class='error'>Middle Name can consist only latin alphabet. </span>");
		return false;
	} else {
		return true;
	}
}

function isValidPassword(password) {
	var reg = new RegExp("^[a-zA-Z0-9]+$");
	if (password.val() === "") {
		password.after("<span class='error'>Password is required</span>");
		res = false;
	} else if (password.val().length < 6) {
		password
				.after("<span class='error'>Please enter at least 6 symbols</span>");
		return false;
	} else if (password.val().length > 25) {
		password
				.after("<span class='error'>Please enter less then 25 symbols</span>");
		return false;
	} else if (!reg.test(password.val())) {
		password
				.after("<span class='error'>Password can consist only latin alphabet and numerals. </span>");
		return false;
	} else {
		return true;
	}
}

function isValidLogin(login) {
	var reg = new RegExp("^[a-zA-Z0-9_]+$");

	if (login.val() === "") {
		login.after("<span class='error'>Login is required</span>");
		return false;
	} else if (login.val().length < 3) {
		login
				.after("<span class='error'>Login is too short, enter at least 3 letters</span>");
		return false;
	} else if (login.val().length > 25) {
		login
				.after("<span class='error'>Login is too long, max 25 letters</span>");
		return false;
	} else if (!reg.test(login.val())) {
		login
				.after("<span class='error'>Login can consist only latin alphabet, arabic numerals, sign '_'. </span>");
		return false;
	} else {
		return true;
	}
}

function isConfirmPasswordEqualPassword() {
	var password = $("#password");
	var confirmPassword = $("#confirm");

	if (password.val() != confirmPassword.val()) {
		confirmPassword
				.after("<span class='error'>Password and confirmation are different</span>");
		return false;
	}
	return true;
}

function removeErrors() {
	$(".error").remove();
}