$(function() {

	$("#sign-up-form").validate({
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
				required:{
					depends : function(element) {
						return $(element).val() == $("#password").val();
					}
				}
			}
		},

		errorClass : "form-error",
		validClass: "form-success",
		errorPlacement : function(error, element) {
			return false;
		},
		success: function(span) {
		   return false;
		},
		onfocusout : true,
		debug:true,
		errorElement : "span",
		submitHandler:function(form){
			form.submit();
		}
	});
});