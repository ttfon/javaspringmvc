<%-- 
    Document   : thongke
    Created on : Sep 27, 2021, 10:59:32 AM
    Author     : AD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <ul class="list-group">
    <li class="list-group-item">
      <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">Doanh Thu Của Tất Cả Khách Sạn</button>
      <br>
    </li>
    <li class="list-group-item">
      <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo1">Doanh Thu Của Từng Khách Sạn</button>
    </li>
     <li class="list-group-item">
      <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo2">Doanh Thu Của Tour Theo Ngày</button>
    </li>
  </ul>
<div class="container">
  <!-- Links -->
 
    
    <div id="demo" class="collapse">
            <h1>Doanh Thu Của Tất Cả Khách Sạn</h1>
            <div>
                <canvas id="myChart"  width="100%" height="50%" style="padding-left: 5%;"></canvas>
            </div>
            <script>



           var ngay =[<c:forEach var="dp" items="${donphong}">
           '${dp[0]}',

                       </c:forEach>
           ];
           var bien = [<c:forEach var="dp" items="${donphong}">
           '${dp[1]}',

                       </c:forEach>];
           var chart =document.getElementById('myChart').getContext('2d');
           var bieudo = new Chart(chart,{
               type:'line',
               data:{
                   labels:ngay,
                   datasets:[{
                           label:"Doanh thu",
                           data:bien,
                            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
                   }]
               }
           })

        </script>
    </div>
     <div id="demo1" class="collapse1">
      <h1>Doanh Thu Của Từng Khách Sạn</h1>
            <div>
                <canvas id="myChart1"  width="100%" height="50%" style="padding-left: 5%;"></canvas>
            </div>
            <script>



           var ngay =[<c:forEach var="dp" items="${donphong2}">
           '${dp[0]}',

                       </c:forEach>
           ];
           var bien = [<c:forEach var="dp" items="${donphong2}">
           '${dp[1]}',

                       </c:forEach>];
           var chart =document.getElementById('myChart1').getContext('2d');
           var bieudo = new Chart(chart,{
               type:'bar',
               data:{
                   labels:ngay,
                   datasets:[{
                           label:"Doanh thu",
                           data:bien,
                            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
                   }]
               }
           })

        </script>
     </div>
     <div id="demo2" class="collapse2">
      <h1>Doanh Thu Của Tour Theo Ngày</h1>
            <div>
                <canvas id="myChart2"  width="100%" height="50%" style="padding-left: 5%;"></canvas>
            </div>
            <script>



           var ngay =[<c:forEach var="dp" items="${dontour}">
           '${dp[0]}',

                       </c:forEach>
           ];
           var bien = [<c:forEach var="dp" items="${dontour}">
           '${dp[1]}',

                       </c:forEach>];
           var chart =document.getElementById('myChart2').getContext('2d');
           var bieudo = new Chart(chart,{
               type:'bar',
               data:{
                   labels:ngay,
                   datasets:[{
                           label:"Doanh thu",
                           data:bien,
                            backgroundColor: [
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 159, 64, 0.2)',
              'rgba(255, 205, 86, 0.2)',
              'rgba(75, 192, 192, 0.2)',
              'rgba(54, 162, 235, 0.2)',
              'rgba(153, 102, 255, 0.2)',
              'rgba(201, 203, 207, 0.2)'
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)'
            ],
            borderWidth: 1
                   }]
               }
           })

        </script>
     </div>
</div>
