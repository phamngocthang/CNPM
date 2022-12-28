<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/output.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  <style>
  	.updateForm {
  		width: 700px;
  		border: 1px solid orange;
  		margin: 0 auto;
  	}
  </style>
</head>
<body>
	<!-- Update Form -->
  <input class='hidden' type="checkbox" name="" id="openUpdate">
  <div id='UpdateForm'
    class='updateForm bg-white min-w-[350px] p-8 rounded-md shadow-lg'>
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Sửa sản phẩm</h1>
    <form class='' action="${pageContext.request.contextPath}/CapNhatDeTaiTBM?idDeTai=${result.idDeTai}" method="post">
    	<div class="flex flex-col gap-2">
        <label class='' for="product-id">Mã Đề Tài</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="iddetai"
          id="iddetai" disabled value = "${result.idDeTai}" >
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-name">Tên Đề Tài</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="tendetai"
          id="tendetai" placeholder='Vui lòng nhập tên đề tài....' value = "${result.tenDeTai}" >
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-category">Loại Đề Tài</label>
		  	<select name="loaidetai" id="loaidetai">
		  	  <c:forEach items="${listLoai}" var="rs">
        	  	<option value=${rs.idLoaiDeTai }>${rs.tenLoaiDeTai }</option>
        	  </c:forEach>
	        </select>
      </div>
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Niên Khóa</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="nienkhoa"
          id="nienkhoa" placeholder='Vui lòng nhập niên khóa' value = "${result.nienKhoa}" >
      </div>
      
      <div class="flex flex-col gap-2">
        <label class='' for="product-category">ChuyenNganh</label>
		  	<select name="chuyennganh" id="chuyennganh">
		  	  <c:forEach items="${listCN}" var="rs">
        	  	<option value=${rs.idChuyenNganh}>${rs.tenChuyenNganh}</option>
        	  </c:forEach>
	        </select>
      </div>
      
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Mục Tiêu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="muctieu"
          id="muctieu" placeholder='Vui lòng nhập muc tiêu đề tài...' value = "${result.mucTieu}" >
      </div>
      <!-- Color -->
      <div class="flex flex-col gap-2">
        <label class='' for="product-color">Yêu Cầu</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="yeucau"
          id="yeucau" placeholder='Vui lòng nhập yêu cầu...' value = "${result.yeuCau}" >
      </div>
      
      <div class="flex flex-col gap-2">
        <label class='' for="product-desc">Sản Phẩm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="sanpham"
          id="sanpham" placeholder='Nhập mô tả sản phẩm đề tài...'value = "${result.sanPham}" >
      </div>
      <!-- Amount -->
      <br />
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type = "submit">Cập nhật</button>
      <a href ="QuanLyDeTai?idloai=${loai}">
      <button type='button'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Hủy</button>
      </a>
    </form>
  </div>
</body>
</html>