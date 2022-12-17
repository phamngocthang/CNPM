<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Profile</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
<link rel="stylesheet" href="Content/public/css/profile.css">
</head>
<body>
	<form class="card-body" method="post" action="ShowAndUpdateProfile">
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
							onclick="location.href='change-password.jsp';">Đổi mật
							khẩu</button>
					</div>
				</div>
				<div class="col-md-5 border-right">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<h4 class="text-right">Profile</h4>
						</div>
						<div class="row mt-2">
							<div class="col-md-12">
								<label class="labels">Tên đăng nhập</label> <input type="text"
									readonly class="form-control" name="username"
									placeholder="Tên đăng nhập" value="${account.userName}">
							</div>
							<div class="col-md-12">
								<label class="labels">Tên</label> <input type="text"
									class="form-control" name="fullname" placeholder="Nhập tên"
									value="${account.fullName}">
							</div>

							<div class="col-md-12">
								<label class="labels">Địa chỉ</label><input type="text"
									class="form-control" name="address" placeholder="Nhập địa chỉ"
									value="${account.address}">
							</div>
							<div class="col-md-12">
								<label class="labels">Số điện thoại</label><input type="text"
									class="form-control" name="phone"
									placeholder="Nhập số điện thoại" value="${account.phonenumber}">
							</div>
							<div class="col-md-12">
								<label class="labels">Chuyên ngành</label><input type="text"
									readonly class="form-control" name="specialized"
									placeholder="Chuyên ngành"
									value="${account.chuyennganh.idChuyenNganh}">
							</div>
						</div>
						<div class="mt-5 text-center">
							<button class="btn btn-primary profile-button" type="submit">Cập
								nhật thông tin</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>