<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<div class="jumbotron">
	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-2">First name:</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="name"
					placeholder="Enter name">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Last name:</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="surname"
					placeholder="Enter surname">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Email:</label>

			<div class="col-sm-10">
				<input type="email" class="form-control" id="email"
					placeholder="Enter email">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Shipping address:</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="address"
					placeholder="Enter shipping address">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">City:</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="city"
					placeholder="Enter your city">
			</div>
		</div>
		<div class="form-group">
			<div class="row col-sm-offset-1">
				<div class="col-sm-6">
					<label class="control-label col-sm-2">Zip:</label>

					<div class="col-sm-10">
						<input type="text" class="form-control" id="zip"
							placeholder="Zip number">
					</div>
				</div>
				<div>
					<div class="col-sm-6">
						<label class="control-label col-sm-2">Country:</label>

						<div class="col-sm-10">
							<input type="text" class="form-control" id="country"
								placeholder="Your country">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Credit card:</label>

			<div class="col-sm-10">
				<input type="text" class="form-control" id="credit-card"
					placeholder="Enter your credit card number">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" for="expiry-month">Expiration
				Date:</label>

			<div class="col-sm-9">
				<div class="row">
					<div class="col-xs-3">
						<select class="form-control col-sm-2" name="expiry-month"
							id="expiry-month">
							<option>Month</option>
							<option value="01">Jan</option>
							<option value="02">Feb</option>
							<option value="03">Mar</option>
							<option value="04">Apr</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">Aug</option>
							<option value="09">Sep</option>
							<option value="10">Oct</option>
							<option value="11">Nov</option>
							<option value="12">Dec</option>
						</select>
					</div>
					<div class="col-xs-3">
						<select class="form-control" name="expiry-year">
							<option value="15">2015</option>
							<option value="16">2016</option>
							<option value="17">2017</option>
							<option value="18">2018</option>
							<option value="19">2019</option>
							<option value="20">2020</option>
						</select>
					</div>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">Proceed to
					payment</button>
			</div>
		</div>
	</form>
</div>