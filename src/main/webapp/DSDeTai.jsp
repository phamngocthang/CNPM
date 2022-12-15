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
    <div id="menu">
       <li class="list-group-item" style="text-align: right;font-weight:bold;font-family:verdana;background-color:#efefef;">Danh Mục</li>
        <a href="/DangKyDeTai" class="list-group-item"><img src="Content/public/images/house-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Trang Chủ</a>
        <a href="/Home/LoaiDeTai" class="list-group-item "><img src="Content/public/images/Actions-view-calendar-list-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Danh sách đề tài</a>
        <a href="/Home/ThongTinGiangVien" class="list-group-item "><img src="Content/public/images/Teacher-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thông tin giảng viên</a>
        <a href="/Home/ThongTinSinhVien" class="list-group-item "><img src="Content/public/images/Student-3-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thông tin sinh viên</a>
        <a href="/Home/HuongDanDangKy" class="list-group-item "><img src="Content/public/images/Actions-help-contents-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Hướng dẫn đăng ký</a>
        <a href="/Home/ThongKe" class="list-group-item "><img src="Content/public/images/chart-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thống kê</a>
        <a data-toggle="modal" href="#seach_box" class="list-group-item"><img src="Content/public/images/Search-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Tìm kiếm</a>
        <hr />   
    </div>
    <div id="container">
<div id="mobile-bar">
    <span style="cursor: pointer;" class="pull-left" href="javascript:;" onclick="slideMenu(); return false;" id="slideicon"><i class="icon-reorder"></i></span>
        <span data-toggle="modal" href="#dang_nhap" class="pull-right btn btn-default btn-sm" id="#">Sign In</span>
        <p style="text-align: center;font-weight:bold;">Đăng ký đề tài</p>
</div>
        <div id="navigation">
            <div id="banner-desktop">
                <div class="container">
                    <div id="banner">
                        <div id="login-area">
                                   <a data-toggle="modal" href="#dang_nhap"><img src="Content/public/images/Login-icon.png" width="24" height="24" /> Đăng nhập</a>



                        </div>
                    </div>
                </div>
            </div>
            <!-- ############################ Đăng nhập ############################## -->
            <div class="modal fade" id="dang_nhap">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Đăng nhập</h4>
                        </div>
                        <form method="post" action="/Home/DangNhap" id="frm-login">
                            <div class="modal-body">
                                <div id="err_login"></div>
                                <div id="login_here">
                                    <label>Username : </label>
                                    <input type="text" class="form-control" name="username" id="username" />
                                    <label>Password : </label>
                                    <input type="password" class="form-control" name="password" id="password" />
                                    <br />
                                    <a href="/Home/QuenMatKhau" class="text-danger">Quên mật khẩu</a>
                                </div>
                                <br />
                                <div id="waiting" style="display: none;">
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" id="login_btn">Đăng nhập</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- ===================================Thông tin người dùng=========================-->
            <div class="modal fade" id="thong_tin">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">Thông tin người dùng</h4>
                        </div>

                    

                    


                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!-- ===================================Ajax Login=========================-->
            <script>
                $(document).ready(function () {
                    $("#frm-login").submit(function (e) {
                        if ($("#username").val() == '') {
                            $('#err_login').html('<div class="alert alert-danger">Username chưa nhập</div>');
                            $("#username").focus();
                            return false;
                        }
                        else if ($("#password").val() == '') {
                            $('#err_login').html('<div class="alert alert-danger">Password chưa nhập</div>');
                            $("#password").focus();
                            return false;
                        }
                        else {
                            var form_data_login = {
                                username: $("#username").val(),
                                password: $("#password").val()
                            };
                            $.ajax({
                                url: '/Home/DangNhap',
                                type: 'POST',
                                async: true,
                                data: form_data_login,
                                success: function (msg_login) {
                                    //alert(msg);
                                    if (msg_login == 'false') {
                                        $('#err_login').html('<div class="alert alert-danger">Tên hoặc mật khẩu không chính xác</div>');
                                        $("#password").val("");
                                        $("#password").focus();
                                        return false;
                                    }
                                    else if(msg_login=='er_block')
                                    {
                                        $('#err_login').html('<div class="alert alert-danger">Tài khoản đang bị khóa</div>');
                                    }
                                    else {
                                        $("#login_here").hide();
                                        $(".modal-footer").hide();

                                        $('#err_login').html('<div class="alert alert-success"><strong>Đăng nhập thành công</strong><span> Hệ thống tự chuyển sau vài giây ...</span></div>');
                                        setTimeout(
                                           //chuyển đến địa chỉ msg_login của controler gửi qua
                                          function () {
                                              window.location.href = '' + msg_login + '';
                                          }, 2000);
                                    }
                                }
                            });
                            return false;
                        }
                    });
                })
                //Load wating bar
                $(document).ajaxStart(function () {
                    $("#waiting").show();
                }).ajaxStop(function () {
                    $("#waiting").hide();
                });
            </script>

        </div>
        <div id="wrapper">
            <div class="container">
                <div class="row">
                    <div id="left-content">
                        <div class="col-md-3">
                            <!-- Menu desktop -->
                            <div id="desktop-menu">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 id="mobile_home">Danh Mục</h4>
                                    </div>
                                    
                                    <a href="/Home/Index" class="list-group-item"><img src="Content/public/images/house-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Trang Chủ</a>
                                    <a href="/Home/LoaiDeTai" class="list-group-item "><img src="Content/public/images/Actions-view-calendar-list-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Danh sách đề tài</a>
                                    <a href="/Home/ThongTinGiangVien" class="list-group-item "><img src="Content/public/images/Teacher-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thông tin giảng viên</a>
                                    <a href="/Home/ThongTinSinhVien" class="list-group-item "><img src="Content/public/images/Student-3-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thông tin sinh viên</a>
                                    <a href="/Home/HuongDanDangKy" class="list-group-item "><img src="Content/public/images/Actions-help-contents-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Hướng dẫn đăng ký</a>
                                    <a href="/Home/ThongKe" class="list-group-item "><img src="Content/public/images/chart-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Thống kê</a>
                                    <a data-toggle="modal" href="#seach_box" class="list-group-item"><img src="Content/public/images/Search-icon.png" width="24" height="24" /><span class="pull-right"><i class="icon-chevron-right"></i></span> Tìm kiếm</a>
                                </div><!-- /panel-default -->

                                



                                <!--============================Bench==================-->
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 id="mobile_thongke">Thống kê</h4>
                                    </div>
                                    
                                    <a class="list-group-item"><img src="Content/public/images/user-group-icon (1).png" width="24" height="24" /> Lượt truy cập : <span class="badge">107679</span></a>
                                    <a style="text-decoration: underline;" data-toggle="modal" data-target="#who_online" title="Who is online ?" href="javascript:void();" class="list-group-item"><img src="Content/public/images/online-icon.png" width="24" height="24" /> Đang trực tuyến: <span class="badge">2</span></a>
                                </div>
                            </div>
                            <!-- Modal Who online -->
                            <div class="modal fade" id="who_online" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Online Users</h4>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <td>STT</td>
                                                        <td>Tên SV</td>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- ########################### Form ###########################-->
                            <!-- =========================Tìm kiếm box================================ -->
                            <div class="modal fade" id="seach_box">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">Tìm kiếm</h4>
                                        </div>
                                        <form action="/Home/TimKiem" method="get" id="cpa-form">
                                            <div class="modal-body">
                                                <div id="err_tk"></div>
                                                <select class="form-control text-center" name="param_option" id="tim_kiem_tong_hop">
                                                    <option value="timkiemgiangvien">Tìm kiếm giảng viên</option>
                                                    <option value="timkiemsinhvien">Tìm kiếm sinh viên</option>
                                                    <option value="timkiemdetai">Tìm kiếm đề tài</option>
                                                </select>
                                                <br />
                                                <label>Nhập từ khoá :</label>
                                                <input type="text" class="form-control" id="parameter1" name="param_textbox" value="" placeholder="Mọi thứ..." />
                                                <div class="clear"></div>
                                                <div id="search_advance">
                                                    <br />
                                                    <div id="type_detai" style="display: none;">
                                                        
                                                        <fieldset>
    <legend>Chọn loại đề tài</legend>
        <input type="radio" name="group_loaidt" value="1" /> <span>Tiểu luận chuy&#234;n ng&#224;nh | K 14 <br /></span>
        <input type="radio" name="group_loaidt" value="3" /> <span>Đề t&#224;i tốt nghiệp | K 14 <br /></span>
        <input type="radio" name="group_loaidt" value="4" /> <span>Tiểu luận chuy&#234;n ng&#224;nh | K 17 <br /></span>
        <input type="radio" name="group_loaidt" value="8" /> <span>Tiểu luận chuy&#234;n ng&#224;nh | K 19 <br /></span>
    
</fieldset>;
                                                    </div><!-- End #search_advance -->
                                                </div><!--End body -->
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-primary" id="timkiem_btn">Tìm kiếm</button>
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                </div>
                                            </div><!-- /.modal-content -->
                                        </form>
                                    
                                </div><!-- /.modal-dialog -->
                            </div><!-- /.modal -->
                        </div><!-- ===================================Ajax========================= -->
                        <script>
                            $(document).ready(function () {
                                $("#cpa-form").submit(function (e) {
                                    if ($("#parameter1").val() == '') {
                                        $('#err_tk').html('<div class="alert alert-danger">Vui lòng nhập từ khoá tìm kiếm</div>');
                                        $("#parameter1").focus();
                                        return false;
                                    }
                                    if ($('#tim_kiem_tong_hop').val() == "timkiemdetai")
                                    {
                                        //$('*[name=group_loaidt]').is(":not(:checked)") kiểm tra radio chưa check

                                        if ($("*[name=group_loaidt]").is(":checked")) {
                                            return true;
                                        }
                                        else //radio chưa check
                                        {
                                            $('#err_tk').html('<div class="alert alert-danger">Vui lòng chọn loại đề tài</div>');
                                            return false;
                                        }
                                    }
                                });
                            })
                        </script>
                        
                    </div>
                </div>
                <div class="col-md-9">
                    <ol class="breadcrumb">
                        <li><a href="/Home/Index">Home</a></li>
                        
                    </ol>    <div class="well-sm">
                        <span>
                            <span id="random_tin">
                                <i class="icon-bullhorn"></i>&nbsp;
                                <img src="Content/public/images/bullet-blue-icon.png" />
                                      <small>
        <a href="/Home/TinTuGiaoVu?id=9">

            Th&#244;ng b&#225;o đăng k&#253; chuy&#234;n ng&#224;nh kh&#243;a 2018 <small style="color: rgb(87,87,87);">(30/11/2020 10:15:04)</small>
        </a>
    </small>


                            </span>
                            <span id="time_bar">

                                <span id="time" class="label label-primary pull-right"><i class="icon-time"></i> 21 giờ 56 phút, ngày 20 tháng 11, 2022</span><br>                             
                            </span>
                        </span>
                    </div>
                        
<div class="panel panel-default">
    <div style="color: rgb(7, 132, 163);" class="panel-heading">

        
        <h4 style="font-family: verdana;color:rgb(87,87,87);">Đề t&#224;i tốt nghiệp k14 </h4>
    </div>
    <div class="panel-body">
        <div id="search">
            <select id="search_cn" class="form-control text-center">
                <option value="${pageContext.request.contextPath}/DanhSachDeTai?index=1&cn=-1" selected>Tất cả chuyên ngành</option>
                        <option value="${pageContext.request.contextPath}/DanhSachDeTai?index=1&cn=1">C&#244;ng nghệ phần mềm</option>
                        <option value="${pageContext.request.contextPath}/DanhSachDeTai?index=1&cn=2">Hệ thống th&#244;ng tin</option>
                        <option value="${pageContext.request.contextPath}/DanhSachDeTai?index=1&cn=3">Mạng m&#225;y t&#237;nh</option>
                        <!--
                        <option value="/Home/DanhSachDeTai?index=3&cn=4">Kỹ Thuật dữ liệu</option>
                        <option value="/Home/DanhSachDeTai?index=3&cn=5">Sư phạm</option>
                        <option value="/Home/DanhSachDeTai?index=3&cn=9">Tr&#237; tuệ nh&#226;n tạo</option>
                        <option value="/Home/DanhSachDeTai?id=3&cn=10">An to&#224;n th&#244;ng tin</option>
                          -->
            </select>
        </div>
        <br />
        <br />
        <div id="show_detai">
            <a href="/Home/DanhSachDeTaiKhongDuyet?id=3">
                <div class="alert alert-info">
                    Click để xem danh sách đề tài không được duyệt<br />
                    (Nếu sinh viên nằm trong danh sách đề tài không được duyệt vui lòng đăng ký đề tài khác)
                </div>
            </a><br />
            <div class="text-center">
                <p class="badge red">Tổng số đề tài : ${totalD }</p>
            </div>
            <table class="table" data-page-size="5">
                <thead>
                    <tr>
                        <th data="true">STT</th>
                        <th data="true">Tên đề tài</th>
                        <th data="true" style="width: 140px!important;">GVHD</th>
                        <th data-hide="phone,tablet">Chuyên ngành </th>
                        <th data-hide="phone,tablet">Tình trạng </th>
                        <th data-hide="phone,tablet">Số lượng</th>
                        <th data-hide="phone">Chi tiết</th>
                    </tr>
                </thead>
                <tbody>
						<c:forEach begin="0" end="${fn:length(listD) - 1}" step="1" varStatus="position">
							<c:set var="p" value="${listD[position.current]}" />
							<tr>
	                            <td><span class="text-info">${position.current+1}</span></td>
	                            <td><span class="caret"></span>${p[1]}</td>
	                            <td>${p[3]}</td>
	                            <td>${p[2]}</td>
	                                <td>${listM[position.current] > 0 ? "Đã có người đăng ký" : "Chưa có người đăng ký"}</td>
	                                <td><a class="badge red">${listM[position.current]}</a> / <a class="badge green">2</a></td>
	                                <td><a target="_blank" href="ChiTietDeTai?id=${p[0]}" class="btn btn-success btn-xs"><img src="Content/public/images/Windows-View-Detail-icon.png" width="24" height="24" data-toggle="tooltip" title="Xem chi tiết" /></a></td>    
                       		 </tr>
						</c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="6">
                            
                            <div class="pagination-container">
                            	<ul class="pagination">
                            		<c:if test="${tag > 1}">
                            			<li class="PagedList-skipToPrevious"><a href="${pageContext.request.contextPath}/DanhSachDeTai?index=${tag-1}&cn=${tagcn}" rel="prev">«</a></li>
                            		</c:if>
                            		<c:forEach begin="1" end="${endP}" var="i">
										<c:choose>
										   <c:when test="${tag == i}">
										   		<li class="active"><a>${i}</a></li>
										   </c:when> 
										   <c:otherwise>
										   		<li><a href="${pageContext.request.contextPath}/DanhSachDeTai?index=${i}&cn=${tagcn}">${i}</a></li>
										   </c:otherwise>   
										</c:choose>   
			                        </c:forEach>
			                        <c:if test="${endP != tag}">
                            			<li class="PagedList-skipToNext"><a href="${pageContext.request.contextPath}/DanhSachDeTai?index=${tag+1}&cn=${tagcn}" rel="next">»</a></li>
                            		</c:if>
                            	</ul>
                            </div>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>


    </div>
</div>


                        <ol class="breadcrumb">
                            <li><a href="/Home/Index">Home</a></li>
                            
                        </ol>                    
                    <div class="panel panel-default" id="thongke_right">
                            <div class="panel-heading">
                                <h4 id="mobile_thongke">Thống kê</h4>
                            </div>
                        <a class="list-group-item"><img src="Content/public/images/user-group-icon (1).png" width="24" height="24" /> Lượt truy cập : <span class="badge">107679</span></a>
                        <a style="text-decoration: underline;" data-toggle="modal" data-target="#who_online" title="Who is online ?" href="javascript:void();" class="list-group-item"><img src="Content/public/images/online-icon.png" width="24" height="24" /> Đang trực tuyến: <span class="badge">2</span></a>
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

