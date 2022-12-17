<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="icon" href="Content/public/images/it_spkt.png" type="image/x-icon" />
    <link rel="shortcut icon" href="Content/public/images/it_spkt.png" />
    <title>Danh Sách Đề Tài</title>
    <link rel="stylesheet" media="all" type="text/css" href="Content/public/css/bootstrap.min.css" />
    <link rel="stylesheet" media="all" type="text/css" href="Content/public/css/style.css" />
    <link rel="stylesheet" media="all" type="text/css" href="Content/public/css/footable.core.css" />
    <link rel="stylesheet" media="all" type="text/css" href="Content/public/css/footable.standalone.css" />
    <link href="Content/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href="Content/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" />
	
    <script type="text/javascript" src="Content/public/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="Content/public/js/footable.js"></script>
    <script type="text/javascript" src="Content/public/js/my_script.js"></script>
    <script src="Content/public/ckeditor/ckeditor.js"></script>
    <link href="Content/public/datepicker/jquery.simple-dtpicker.css" rel="stylesheet" />
    <script src="Content/public/datepicker/jquery.simple-dtpicker.js"></script>
</head>
<body>
    <div id="container">
			<jsp:include page="header.jsp" />
    </div>
    <div id="wrapper">
       <div class="container">
           <div class="row">
              <jsp:include page="leftcontent.jsp" />
           	  <div class="col-md-9">
                        
				<div class="panel panel-default">
			    <div style="color: rgb(7, 132, 163);" class="panel-heading">					        
			        <h4 style="font-family: verdana;color:rgb(87,87,87);">Đề Tài Đã Đăng Ký </h4>
			    </div>
			    <div class="panel-body">
		        <br />
		        <br />
		        <div id="show_detai">
		        	<c:if test="${amountDK == 0}">
			        	<div class="text-center">
			                <p class="badge red" style="font-size: 20px;">Hiện tại bạn chưa đăng ký đề tài</p>
			            </div>
		            </c:if>
		            <table class="table" data-page-size="5">
		                <thead>
		                    <tr>
		                        <th data="true">ID</th>
		                        <th data="true">Tên đề tài</th>
		                        <th data-hide="phone">Chi tiết</th>
		                    </tr>
		                </thead>
		                <tbody>
							<c:forEach items="${listDK}" var="rs">
									<tr>
			                            <td><span class="text-info">${rs.idDangKy}</span></td>
			                            <td><span class="caret"></span>${rs.detai.tenDeTai}</td>
			                                <td>
			                                <a href="ChiTietDeTai?id=${rs.detai.idDeTai}" class="btn btn-success btn-xs" style="background-color: transparent; border-color: transparent;">
			                                	<img src="https://uxwing.com/wp-content/themes/uxwing/download/user-interface/search-icon.png" width="24" height="24" data-toggle="tooltip" title="Xem chi tiết"/>
			                                </a>
			                                <a href="XoaDangKy?id=${rs.idDangKy}" class="btn btn-success btn-xs" style="background-color: transparent; border-color: transparent;">
			                                	<img src="https://icon-library.com/images/icon-remove/icon-remove-19.jpg" width="24" height="24" data-toggle="tooltip" title="Xóa Đăng Ký"/>
			                                </a>
			                                </td>    
		                       		 </tr>
		                     </c:forEach>
		                </tbody>
		            </table>
		        </div>
    			</div>
			</div>                
     	</div>
    </div>
    </div>
    <div class="container">
        <div id="footer">
            <hr />
            <h5 class="text-center text-danger">Khoa Công nghệ Thông tin - Đại học Sư phạm Kỹ thuật TP. Hồ Chí Minh</h5>
            <h5 class="text-center text-danger">Số 1, Võ Văn Ngân, Thủ Đức, TP. Hồ Chí Minh</h5>
        </div>
    </div>
    </div><!-- End #container -->
    <div id="loading">
        <span>Đang xử lý</span>
    </div>
    <script>
        $(document).ready(function () {
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
    <script type="text/javascript" src="Content/public/js/bootstrap.min.js"></script>
</body>
</html>

