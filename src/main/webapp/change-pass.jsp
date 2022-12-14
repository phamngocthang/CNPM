<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đổi mật khẩu</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link rel="stylesheet" href="Content/public/css/profile.css">
</head>
<body>

	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="150px"
						src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
						class="font-weight-bold">${account.fullName}</span><span
						class="text-black-50">${account.email}</span><span> </span>
					<button type="button" class="btn btn-success"
						onclick="location.href='index.jsp';">Trang chủ</button>
				</div>
			</div>
			<div class="col-md-5 border-right">
				<form class="card-body" method="post" action="ChangePassword">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<h4 class="text-right">Đổi mật khẩu</h4>
						</div>
						<div class="row mt-2">
							<div class="col-md-12">
								<label class="labels">Tên đăng nhập</label> <input type="text"
									readonly class="form-control" name="username"
									placeholder="Tên đăng nhập" value="${account.userName}">
							</div>
							<div class="col-md-12">
								<label class="labels">Mật khẩu cũ</label> <input type="password"
									class="form-control" name="oldPassword"
									placeholder="Nhập mật khẩu cũ">
							</div>
							<div class="col-md-12">
								<label class="labels">Mật khẩu mới</label><input type="password"
									class="form-control" name="newPassword"
									placeholder="Nhập mật khẩu mới">
							</div>
							<div class="col-md-12">
								<label class="labels">Xác nhận lại mật khẩu</label><input
									type="password" class="form-control" name="confirmPassword"
									placeholder="Nhập lại mật khẩu mới">
							</div>
						</div>
						<div class="mt-5 text-center">
							<button class="btn btn-primary profile-button" type="submit">Đổi
								mật khẩu</button>
							<button class="btn btn-primary profile-button" type="button"
								onclick="location.href='ShowAndUpdateProfile';">Hủy</button>
						</div>
					</div>
				</form>
				<c:if test="${message != null}">
					<div class="col-sm-12 d-flex justify-content-end my-3">
						<p class="text-${message.type}">${message.body}</p>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>