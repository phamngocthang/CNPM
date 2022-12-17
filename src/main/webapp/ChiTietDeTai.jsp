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
    <title>::. Chi tiết đề t&#224;i .::</title>
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
    </div>s


        <div id="wrapper">
            <div class="container">
                <div class="row">
                    <jsp:include page="leftcontent.jsp" />
                <div class="col-md-9">
                        
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Chi tiết đề tài (${mess})</h4>
    </div>
    <div class="panel-body">
        <div id="detail">
        	<c:set var="p" value="${listCT[0]}" />
            <table class="table table-hover">
                <tr>
                    <td>Tên đề tài</td>
                    <td>${p[0]}</td>
                </tr>
                <tr>
                    <td>Mục tiêu</td>
                    <td>${p[1]}</td>
                </tr>
                <tr>
                    <td>Yêu Cầu</td>
                    <td>${p[2] }</td>
                </tr>
                <tr>
                    <td>Sản phẩm</td>
                    <td>${p[3]}</td>
                </tr>
                <tr>
                    <td>Chú thích</td>
                    <td></td>
                </tr>
                <tr>
                    <td>SL sinh viên</td>
                    <td><span class="badge green" title="Số lượng sinh viên đã đăng ký">${count }</span> / <span class="badge red" title="Tổng Số lượng sinh viên tối đa">2</span></td>
                </tr>
                <tr>
                    <td>Được phép đăng ký khác chuyên ngành</td>
                            <td>Không</td>

                </tr>
                <!--
    <tr>
        <td>Thời gian bắt đầu bảo vệ</td>
        <td>0000-00-00 00:00:00</td>
    </tr>
    <tr>
        <td>Thời gian kết thúc bảo vệ</td>
        <td>0000-00-00 00:00:00</td>
    </tr>
    -->
                <tr>
                    <td>Chuyên ngành</td>
                    <td>${p[4] }</td>
                </tr>
                <tr>
                    <td>Loại đề tài</td>
                    <td>${p[5] }</td>
                </tr>
                <tr>
                    <td>Trạng thái</td>
                    <td>Được bảo vệ</td>
                </tr>
                <tr>
                    <td>Niên khóa</td>
                    <td>${p[6] }</td>
                </tr>
                <tr class="success">
                    <td>Trưởng nhóm</td>
                    <td>
                        <a data-toggle="modal" href="#truong_nhom">${listName[0]}</a>
                    </td>
                </tr>
                <tr>
                    <td>Các Thành viên</td>
                    <td>

                        <!-- ========================== Info thanh vien ==========================-->
						<a data-toggle="modal" href="#truong_nhom">${listName[1]}</a>
                    </td>
                </tr>
         
                <tr class="danger">
                    <td>GV hướng dẫn </td>
                    <td>
                        <a data-toggle="modal" href="#GVHD">${listName[2]}</a>
                    </td>
                </tr>
                <tr class="warning">
                    <td>GV phản biện</td>
                    <td>${listName[3]}</td>
                </tr>
                <tr>
                    <td>Điểm đề tài</td>
                    <td>Chưa có điểm</td>
                </tr>
                <c:if test="${userLogged != null }">
	                <tr>
	                    <td colspan="2" style="text-align: center;"><button id="back" type="button" class="btn btn-info" onclick="location.href='DangKy?id=${id}';">Đăng Ký</button></td>
	                </tr>
                </c:if>
            </table>
        </div>
        <!-- ========================== Info nhom truong ==========================-->
        <div class="modal fade" id="truong_nhom">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Thông tin nhóm trưởng</h4>
                    </div>
                    <div class="modal-body">
                            <img style="width: 92px;height:102px;" class="pull-right img-thumbnail" src="Content/avatar/hinh-nen-may-tinh-11.jpg" />
                            <label>Họ tên : <span class="text-info">Trương Ph&#250;c Huy</span></label><br />
                            <label>MSSV : <span class="text-info">14110082</span></label><br />
                            <label>Chuyên ngành : <span class="text-info">Mạng m&#225;y t&#237;nh </span></label><br />
                            <label>Số điện thoại : <span class="text-info"></span></label><br />
                            <label>Email : <span class="text-info"></span></label><br />
                        
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- ========================== Info GVHD ==========================-->
        <div class="modal fade" id="GVHD">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Thông tin GVHD</h4>
                    </div>
                    <div class="modal-body">
                        <img style="width: 92px;height:102px;" class="pull-right img-thumbnail" src="Content/avatar/" />
                        <label>Họ tên : <span class="text-info">Đinh C&#244;ng Đoan</span></label><br />
                        <label>Chuyên ngành : <span class="text-info">Mạng m&#225;y t&#237;nh</span></label><br />
                        <label>Số điện thoại : <span class="text-info"></span></label><br />
                        <label>Email : <span class="text-info">doandc@fit.hcmute.edu.vn</span></label><br />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- ========================== Info GVPB ==========================-->
        <div class="modal fade" id="GVPB">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Thông tin GVPB</h4>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</div>


                        <ol class="breadcrumb">
                            <li><a href="/Home/Index">Home</a></li>
                            
                        </ol>                    
                    <div class="panel panel-default" id="thongke_right">
                            <div class="panel-heading">
                                <h4 id="mobile_thongke">Thống kê</h4>
                            </div>
                        <a class="list-group-item"><img src="Content/public/images/user-group-icon (1).png" width="24" height="24" /> Lượt truy cập : <span class="badge">109438</span></a>
                        <a style="text-decoration: underline;" data-toggle="modal" data-target="#who_online" title="Who is online ?" href="javascript:void();" class="list-group-item"><img src="Content/public/images/online-icon.png" width="24" height="24" /> Đang trực tuyến: <span class="badge">3</span></a>
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