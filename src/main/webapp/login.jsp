<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Đăng nhập</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="Content/public/css/style1.css">


</head>
<body>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-7 col-lg-5">
					<div class="login-wrap p-4 p-md-5">
						<div class="icon d-flex align-items-center justify-content-center">
							<span class="fa fa-user-o"></span>
						</div>
						<h3 class="text-center mb-4">Đăng nhập</h3>
						<form action="Login" class="login-form" method="post">
							<div class="form-group">
								<input type="text" class="form-control rounded-left"
									placeholder="Username" name="username" value="${username}"/>
							</div>
							<div class="form-group d-flex">
								<input type="password" class="form-control rounded-left"
									placeholder="Password" name="password" value="${password}"/>
							</div>
							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary rounded submit px-3">Đăng
									nhập</button>
							</div>
							<div class="form-group d-md-flex">
								<div class="w-50">
									<label class="checkbox-wrap checkbox-primary">Remember
										Me <input type="checkbox" tabindex="3" class=""
										name="remember" id="remember"> <span class="checkmark"></span>
									</label>
								</div>
								<p class="message-text">${message}</p>
								<div class="w-50 text-md-right">
									<a href="#">Forgot Password</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="Content/public/js/jquery.min.js"></script>
	<script src="Content/public/js/popper.js"></script>
	<script src="Content/public/js/bootstrap.min.js"></script>
	<script src="Content/public/js/main.js"></script>

</body>
</html>

