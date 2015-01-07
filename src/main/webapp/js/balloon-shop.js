$(function() {

	$("#btn-updateCart").click(function() {
		$(this).button('loading');
		var elements = $(".quantity-changed");
		var count = elements.size();
		if (count == 0) {
			return;
		}
		var arr = [];
		var i = 0;
		$(elements).each(function() {
			$.post("/balloonshop/update-cart", {
				id : $(this).attr("cp-id"),
				quantity : $(this).val()
			}).done(function(response) {
				if (response != 0) {
					var input = $(".quantity-changed[cp-id=" + response + "]");
					input.removeClass("form-error")
					input.removeClass("quantity-changed");
					input.addClass("form-success");
					input.attr("init-value",input.val());
					if($(".quantity-changed").size() == 0){
						$("#btn-updateCart").button("reset");
						location.reload();
					}
				} else {
					alert("Error cannot update cart, please make sure youre loged in or try again later.")
				}
			});
		});
	});

	window.onbeforeunload = function(e) {
		var count = $(".quantity-changed").size();
		if (count == 0) {
			window.onbeforeunload = null;
			return;
		}

		var message = "Your have " + count + " unsaved product"
				+ (count == 1 ? "." : "s.");

		e = e || window.event;

		// For IE and Firefox
		if (e) {
			e.returnValue = message;
		}

		// For Safari
		return message;
	};
	$(".quantity-check").blur(function() {
		if ($(this).attr("init-value") != $(this).val()) {
			$(this).addClass("form-error");
			$(this).addClass("quantity-changed");
			$(this).removeClass("form-success");
		} else {
			$(this).removeClass("quantity-changed");
			$(this).removeClass("form-error");
		}
	});

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
				required : {
					depends : function(element) {
						return $(element).val() == $("#password").val();
					}
				}
			}
		},

		errorClass : "form-error",
		validClass : "form-success",
		errorPlacement : function(error, element) {
			return false;
		},
		success : function(span) {
			return false;
		},
		onfocusout : true,
		debug : true,
		errorElement : "span",
		submitHandler : function(form) {
			form.submit();
		}
	});
});