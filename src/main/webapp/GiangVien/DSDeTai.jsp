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
			
			        
			        <h4 style="font-family: verdana;color:rgb(87,87,87);">Đề Tài Tốt Nghiệp </h4>
			    </div>
			    <div class="panel-body">
			        <div id="search">
			            <select id="search_cn" class="form-control text-center" onchange="changeFunc();">
			                <option value="${pageContext.request.contextPath}/DSDetaiGV?index=1&cn=-1&loai=${loai}" ${tagcn==-1 ? "selected": ""}>Tất cả chuyên ngành</option>
			                <option value="${pageContext.request.contextPath}/DSDetaiGV?index=1&cn=1&loai=${loai}" ${tagcn==1 ? "selected": ""}>Công nghệ phần mềm</option>
			                <option value="${pageContext.request.contextPath}/DSDetaiGV?index=1&cn=2&loai=${loai}" ${tagcn==2 ? "selected" : ""}>Hệ thống thống tin</option>
			                <option value="${pageContext.request.contextPath}/DSDetaiGV?index=1&cn=3&loai=${loai}" ${tagcn==3 ? "selected" : ""}>Mạng máy tính</option>
			            </select>
			            
			            <script type="text/javascript">
			            	function changeFunc() {
			            		var selectBox = document.getElementById("search_cn");
			            		var selectedValue = selectBox.options[selectBox.selectedIndex].value;
			            		location.href=selectedValue;
			            	}
						</script>
			        </div>
		        <br />
		        <br />
		        <div id="show_detai">
		            <div class="text-center">
		                <p class="badge red">Tổng số đề tài : ${totalD}</p>
		            </div>
		            <c:if test="${fn:length(listD) == 0}">
			        	<div class="text-center">
			                <p class="badge red" style="font-size: 20px;">Hiện tại bạn chưa đăng ký đề tài</p>
			            </div>
		            </c:if>
		            <c:if test="${fn:length(listD) > 0}">
		            <table class="table" data-page-size="5">
		                <thead>
		                    <tr>
		                        <th data="true">STT</th>
		                        <th data="true">Tên đề tài</th>
		                        <th data="true" style="width: 140px!important;">GVHD</th>
		                        <th data-hide="phone,tablet">Chuyên ngành </th>
		                        <th data-hide="phone">Chi tiết</th>
		                    </tr>
		                </thead>
		                <tbody>
								<c:forEach begin="0" end="${fn:length(listD) - 1}" step="1" varStatus="position">
										<c:set var="chuyennganh" value="${listD[position.current].chuyennganh}" />
										<tr>
				                            <td><span class="text-info">${listD[position.current].idDeTai}</span></td>
				                            <td><span class="caret"></span>${listD[position.current].tenDeTai}</td>
												<c:if test="${listGVHD[position.current] != null}">
				                            		<td>${listGVHD[position.current].account.inforaccount.fullName}</td>
				                            	</c:if>
				                            	<c:if test="${listGVHD[position.current] == null}">
				                            		<td>Chưa có người đăng ký</td>
				                            	</c:if>
				                            <td>${chuyennganh.tenChuyenNganh}</td>
				                            
				                            <td><a target="_blank" href="ChiTietDeTai?id=${listD[position.current].idDeTai}" class="btn btn-success btn-xs"><img src="Content/public/images/Windows-View-Detail-icon.png" width="24" height="24" data-toggle="tooltip" title="Xem chi tiết" /></a></td>    
			                       		 </tr>
								</c:forEach>
		                </tbody>
		                <tfoot>
		                    <tr>
		                        <td colspan="6">
		                            
		                            <div class="pagination-container">
		                            	<ul class="pagination">
		                            		<c:if test="${tag > 1}">
		                            			<li class="PagedList-skipToPrevious"><a href="${pageContext.request.contextPath}/DSDetaiGV?index=${tag-1}&cn=${tagcn}&loai=${loai}" rel="prev">«</a></li>
		                            		</c:if>
		                            		<c:forEach begin="1" end="${endP}" var="i">
												<c:choose>
												   <c:when test="${tag == i}">
												   		<li class="active"><a>${i}</a></li>
												   </c:when> 
												   <c:otherwise>
												   		<li><a href="${pageContext.request.contextPath}/DSDetaiGV?index=${i}&cn=${tagcn}&loai=${loai}">${i}</a></li>
												   </c:otherwise>   
												</c:choose>   
					                        </c:forEach>
					                        <c:if test="${endP != tag}">
		                            			<li class="PagedList-skipToNext"><a href="${pageContext.request.contextPath}/DSDetaiGV?index=${tag+1}&cn=${tagcn}&loai=${loai}" rel="next">»</a></li>
		                            		</c:if>
		                            	</ul>
		                            </div>
		                        </td>
		                    </tr>
		                </tfoot>
		            </table>
		            </c:if>
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

