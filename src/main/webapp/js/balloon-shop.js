$(function() {

	$("#sing-up-form").validate({
		rules : {
			name : "required",
			surname : "required",
			email : {
				required : true,
				email : true
			},
			password : {
				required : true,
				minlength : 6
			},
			r_password : {
				depends : function(element) {
					return $(element).val() == $("[name='password']").val();
				}
			}
		},

		messages : {
			name : "Name is required!",
			surname : "Surname is required!",
			email : "Enter a valid email!",
			password : "6 letters minimum is required!",
			r_password : "passwords not matched!"
		},
		
		submitHandler : function(form) {
			form.submit();
		}
	});
});