<%-- 
    Document   : contentright
    Created on : Aug 27, 2021, 2:23:18 PM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <div class="contentleft" style="width: 20%;height:860px; float: left;">
    <div class="card" style="width:100%;">
        <c:forEach var="user" items="${user}">
         <img class="card-img-top" src="${user.hinhanh}" alt="Card image">
        </c:forEach>
         <div class="card-body">

           <h4 class="card-title">${pageContext.request.userPrincipal.name}</h4>
         </div>
    </div>
   <ul class="list-group">

         <li class="list-group-item active"> Các Chức Năng</li> 
    <sec:authorize access="hasRole('ROLE_ADMIN')">  
         <li class="list-group-item"><a href="<c:url value="/admin/user"/>">Quản lí người dùng</a></li>
         <li class="list-group-item"><a href="<c:url value="/admin/taixe"/>">Quản lí Tài Xế</a></li>
         <li class="list-group-item"><a href="<c:url value="/admin/chuyenxe"/>">Quản lí chuyến xe</a></li>
         <li class="list-group-item"><a href="<c:url value="/admin/thongke"/>">Thống kê báo cáo</a></li>
         <li class="list-group-item"><a href="<c:url value="/admin/hoadon"/>">Quản lí Hóa Đơn</a></li>
     </sec:authorize>
     
     <li class="list-group-item"><a href="<c:url value="/profile/update/${pageContext.request.userPrincipal.name}"/>">Chỉnh Sửa Thông Tin</a></li>
     <c:forEach var="user" items="${user}">
     <li class="list-group-item"><a href="<c:url value="/lichsu/?id=${user.id}"/>">Lịch Sử </a></li>
      </c:forEach>
      
   </ul>
    </div>


