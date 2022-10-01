<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="DashboardHeader.jsp"%>
<%--
  File: PurchasesView.jsp
  User: black
  Date: 9/28/2022
  Time: 1:05 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Purchase View</title>
    <style>
        table {
            border: medium solid;
            align-items: center;
        }
    </style>
</head>
<body>

<form method="get">
    <table>
        <thead><tr>
            <td>Order#</td>
            <td>Product#</td>
            <td>description</td>
            <td>categeory</td>
            <td>Season</td>
            <td>Brand</td>
            <td>Color</td>
        </tr></thead>
        <tr>
            <td><input name="order_id"></td>
            <td><input name="product_id"></td>
            <td><input name="product_description"></td>
            <td><input name="product_category"></td>
            <td><input name="product_season"></td>
            <td><input name="product_brand"></td>
            <td><input name="product_color">
                <input hidden name="report_type" value="product_purchase">
                <input hidden name="begin_date" value="${reportCriteriaBean.beginDate}">
                <input hidden name="end_date" value="${reportCriteriaBean.endDate}">
            </td>
            <td><button type="submit" formaction="dispatchReport">Search</button></td>
        </tr>
      <%--  <tr>
            <td><label for="id_begindate">Begin date:</label></td>
            <td><input id="id_begindate" type="date" name="begin_date"value="${reportCriteria.beginDate}"></td>
        </tr>
        <tr>
            <td><label for="id_enddate" >End date:</label></td>
            <td><input id="id_enddate" type="date" name="end_date" value="${reportCriteria.endDate}"></td>
        </tr>--%>
    </table>
</form>

<h2>Product Purchases</h2>
${reportCriteriaBean.beginDate}  -  ${reportCriteriaBean.endDate}
<%--===== Product List ====--%>
<form method = "GET">
  <table>
      <thead><tr>
          <td>Order#</td>
          <td>Product#</td>
          <td>description</td>
          <td>category</td>
          <td>Season</td>
          <td>Brand</td>
          <td>Color</td>
          <td>price</td>
          <td>quantity</td>
          <td>order date</td>
      </tr></thead>
      <c:forEach var="pi" items="${purchaseList}">
      <tr>
          <td>${pi.orderId}</td>
          <td>${pi.productId}</td>
          <td>${pi.product.description}</td>
          <td>${pi.product.category}</td>
          <td>${pi.product.season}</td>
          <td>${pi.product.brand}</td>
          <td>${pi.product.color}</td>
          <td>${pi.product.price}</td>
          <td>${pi.quantity}</td>
          <td>
              <%--
              <fmt:formatDate type="date" value="${pi.order.orderDate}" var="fmtDate" pattern="yyyy-MM-dd"/>

                  <fmt:formatDate type="date" value="${pi.order.orderDate}" var="fmtDate" pattern="E MMM dd HH:mm:ss z yyyy"/>
--%>
                  ${pi.order.orderDate}
          </td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
