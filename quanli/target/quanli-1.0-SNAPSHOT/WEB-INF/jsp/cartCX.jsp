<%-- 
    Document   : cartCX
    Created on : Dec 14, 2021, 12:48:35 AM
    Author     : AD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<div class="container" style="height: 1000px">
    <h1 class="text-center "> Giỏ hàng</h1>
    <c:if test="${cart == null}">
        <h1 class="text-center text-danger ">Không có sản phẩm nào trong giỏ</h1>
    </c:if>
        <c:if test="${cart != null}">
            <table class="table">
                <thead>
                    <tr>
                        <th>Mã chuyến</th>
                        <th>Tên chuyến</th>
                        <th>Giá </th>
                        <th>Số lượng</th>
                         <th>Xóa</th>
                    </tr>
                </thead>
                <tbody>
               
                  <c:forEach var="c" items="${carts}">
                  <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${c.gia}"/> VND</td>
                    <td>${c.soluong}</td>
                    
                    <td><a href="" onclick="deleteCart(${c.id})"><i class="fa fa-remove" style="font-size:24px;color: red;"></i></a></td>
                  </tr>
                </c:forEach>
                  <tr>
                      <td></td>
                      <td></td>
                       <td><b>Tổng cộng: </b</td>
                      <td><span><fmt:formatNumber type="number" maxFractionDigits="3" value="${amount}"/>VND</span></td>
                  </tr>
                </tbody>
            </table>
                  <a type="button"  class="btn btn-danger" onclick="pay(${currentUser.id})">Thanh Toán<a/>
                  <a type="button"  class="btn btn-danger" onclick="xamlzxyz()">Thanh Toán MoMo<a/>
        </c:if>
</div>
<script>
    function deleteCart(id)
    {
        fetch("/quanli/api/chuyenxe/delete/"+id,{
            method:"delete",
        }).then(function(res){
         return res.json()
     }).then(function(data){
         let counter = document.getElementById("cartcounter")
         counter.innerText=data
     })
    }
    function pay(id)
    {
        if(confirm("Bạn có chắc chắn thanh toán ") == true)
            fetch("/quanli/api/pay/"+id,{
                method:"post",
            }).then(function(res){
                return res.json()
            }).then(function(code){
                console.info(code)
                location.reload()
            })
    }
    function paymomo(id)
    {
        var rawsignnature = "accessKey=${accessKey}&amount=${amount}&extraData=&ipnUrl=https://momo.vn&orderId=1&orderInfo=toantran&partnerCode=MOMOBWEX20210917&redirectUrl=https://momo.vn&requestId=${requestId}&requestType=captureWallet"
        var hash = sha256.hmac(${secretKey}, rawsignnature)
        if(comfirm("ban co chac chan thanh toan")== true)
            fetch("https://test-payment.momo.vn/v2/gateway/api/create/"+id,{
                method:"post",
                body:JSON.stringify({
                    "partnerCode": "MOMOBWEX20210917",
                    "partnerName" : "Test",
                    "storeId" : "ttfon1432",
                    "requestType": "captureWallet",
                    "ipnUrl": "https://momo.vn",
                    "redirectUrl": "https://momo.vn",
                    "orderId": "1",
                    "amount": ${amount},
                    "lang":  "vi",
                    "orderInfo": "toantran",
                    "requestId": "${requestId}",
                    "extraData": "",
                    "signature": ""
                }),
                headers:{
             "Content-Type":"application/json; charset=UTF-8"
         }
            }).then(function(res){
                return res.json()
            }).then(function(code){
                console.info(code)
                location.reload()
            })
    }
     function xamlzxyz()
    {
        
        var hash = sha256.hmac(${secretKey}, "accessKey=${accessKey}&amount=${amount}&extraData=&ipnUrl=https://momo.vn&orderId=1&orderInfo=toantran&partnerCode=MOMOBWEX20210917&redirectUrl=https://momo.vn&requestId=${requestId}&requestType=captureWallet")
        console.log(hash)
    }
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>

