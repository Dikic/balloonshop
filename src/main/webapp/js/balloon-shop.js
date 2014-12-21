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
				depends : function(element) {
					return ($(element).text()) == ($("[name='password']").text());
				}
			}
		},

		errorClass : "e",
		errorPlacement : function(error, element) {
			$(element).parent().addClass("has-error has-feedback")
			$(error).text("");
			$(error).addClass("glyphicon glyphicon-remove form-control-feedback");
			$(error).insertAfter($(element));
		},
		success: function(label) {
		    label.parent().removeClass("has-error");
		    label.parent().addClass("has-success");
		    $(label).remove();
		},
		onfocusout : true,
		debug:true,
		errorElement : "span"
	});
});