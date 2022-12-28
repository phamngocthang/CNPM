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
    <h1 class='font-semibold uppercase text-lg text-center mb-4'>Sửa đề tài</h1>
    <form class='' action="${pageContext.request.contextPath}/PhanCongDeTai?idDeTai=${resultD.idDeTai}" method="post">
    	
    	<div class="flex flex-col gap-2">
        <label class='' for="product-name">Tên Đề Tài</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="tendetai"
          id="tendetai" disabled placeholder='Vui lòng nhập tên đề tài....' value = "${resultD.tenDeTai}" >
      </div>
    	
      <div class="flex flex-col gap-2">
        <label class='' for="product-category">Giang Viên Phản Biện</label>
		  	<select name="gvpb" id="gvpb">
		  	  <c:if test="${GVPB == null}">
		  	  	<option value=${ -1} selected>Chưa chọn</option>
		  	  	<c:forEach items="${listGV}" var="rs">
	        	  	<option value=${rs.userName }>${rs.fullName}</option>
	        	 </c:forEach>
		  	  </c:if>
		  	  <c:if test="${GVPB != null}">
			  	  <c:forEach items="${listGV}" var="rs">
	        	  	<option value=${rs.userName } ${GVPB.userName == rs.userName?"selected":""}>${rs.fullName}</option>
	        	  </c:forEach>
        	  </c:if>
	        </select>
      </div>
      
      
      <div class="flex flex-col gap-2">
        <label class='' for="product-brand">Điểm</label>
        <input class='p-2 outline rounded-md outline-2 focus:outline-yellow-500' type="text" name="diem"
          id="diem" placeholder='Vui lòng nhập muc tiêu đề tài...' value = "${resultDK == null ? -1 : resultDK.diem}" >
      </div>
      
      <!-- Amount -->
      <br />
      <button class='bg-blue-500 hover:bg-blue-400 text-center text-white p-2 mb-2 rounded-md shadow-md' type = "submit">Cập nhật</button>
      <a href ="LoaiDeTaiTBM">
      <button type='button'
        class='bg-gray-400 hover:bg-gray-300 text-center text-white p-2 mb-2 rounded-md shadow-md'>Hủy</button>
      </a>
    </form>
  </div>
</body>
</html>