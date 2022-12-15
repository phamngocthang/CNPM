<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-wrapper">
   <div class="offcanvas__option">
      <div class="offcanvas__links">
         <a href="./login.jsp">Đăng nhập</a>
      </div>
   </div>
</div>
<!-- Offcanvas Menu End -->

<!-- Header Section Begin -->
<header class="header">
   <div class="header__top">
      <div class="container">
         <div class="row">
            <div class="col-lg-6 col-md-5">
               <div class="header__top__right">
                  <div class="header__top__links">
                     <c:choose>
                        <c:when test="${userLogged!=null}">
                           <a href="Logout">Đăng xuất</a>
                        </c:when>
                        <c:otherwise>
                           <a href="Login">Đăng nhập</a>
                        </c:otherwise>
                     </c:choose>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</header>
<!-- Header Section End -->