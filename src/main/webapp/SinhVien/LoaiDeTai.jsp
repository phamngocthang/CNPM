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
    <title>::. Loại đề t&#224;i .::</title>
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
 
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!--[if gt IE 8]>
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" >
    <![endif]-->
    <!-- Font Awesom core -->
    <!--[if IE 7]>
      <link rel="stylesheet" href="http://dkdt.fit.hcmute.edu.vn/public/font-awesome/css/font-awesome-ie7.min.css">
      <link rel="stylesheet" href="http://dkdt.fit.hcmute.edu.vn/public/font-awesome/css/bootstrap-ie7.css">
    <![endif]-->
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
                    <ol class="breadcrumb">
                        <li><a href="/Home/Index">Home</a></li>
                        
                    </ol>    <div class="well-sm">
                        <span>
                            <span id="random_tin">
                                <i class="icon-bullhorn"></i>&nbsp;
                                <img src="Content/public/images/bullet-blue-icon.png" />
                                      <small>
   									 </small>


                            </span>
                        </span>
                    </div>
                        
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Danh sách loại đề tài</h4>
    </div>
    <div class="panel-body">
        <table class="table demo footable-loaded footable" data-page-size="5">
            <thead>
                <tr>
                    <th data="true">STT</th>
                    <th>Loại đề tài</th>
                    <th>Ngày bắt đầu</th>
                    <th>Ngày kết thúc</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="rs">
                     <tr>
                        <td>${rs.idLoaiDeTai }</td>
                        <td>
                        	<c:if test="${userLogged.loaiTaiKhoan != 2}">
                            <a href="${pageContext.request.contextPath}/DanhSachDeTai?index=1&cn=-1&loai=${rs.idLoaiDeTai}" style="color: rgb(68,68,68)!important;">${rs.tenLoaiDeTai}</a>
                            </c:if>
                            <c:if test="${userLogged.loaiTaiKhoan == 2}">
                            <a href="${pageContext.request.contextPath}/DSDetaiGV?index=1&cn=-1&loai=${rs.idLoaiDeTai}" style="color: rgb(68,68,68)!important;">${rs.tenLoaiDeTai}</a>
                        	</c:if>
                        </td>
                        <td>${rs.ngayBatDau }</td>
                        <td>${rs.ngayKetThuc }</td>
                    </tr>
			</c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5"></td>
                </tr>
            </tfoot>
        </table>
    </div>
</div>

                        <ol class="breadcrumb">
                            <li><a href="/Home/Index">Home</a></li>
                            
                        </ol>                    
                    <div class="panel panel-default" id="thongke_right">
                            <div class="panel-heading">
                                <h4 id="mobile_thongke">Thống kê</h4>
                            </div>
                        <a class="list-group-item"><img src="Content/public/images/user-group-icon (1).png" width="24" height="24" /> Lượt truy cập : <span class="badge">111368</span></a>
                        <a style="text-decoration: underline;" data-toggle="modal" data-target="#who_online" title="Who is online ?" href="javascript:void();" class="list-group-item"><img src="Content/public/images/online-icon.png" width="24" height="24" /> Đang trực tuyến: <span class="badge">9</span></a>
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

