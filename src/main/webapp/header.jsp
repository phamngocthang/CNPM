<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Offcanvas Menu Begin -->
<div id="navigation">
            <div id="banner-desktop">
                <div class="container">
                    <div id="banner">
                        <div id="login-area">
                        	<c:if test="${userLogged == null }">
                                   <button type="button" class="btn btn-success" onclick="location.href='login.jsp';">Đăng Nhập</button>
                            </c:if>
                            <c:if test="${userLogged != null }">
                            		<button type="button" class="btn btn-success" onclick="location.href='#';">My Account</button>
                                   <button type="button" class="btn btn-success" onclick="location.href='Logout';">Đăng Xuất</button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>


<!-- Header Section End -->