<%@include file="DashboardHeader.jsp"%>
<%--
  FileReportCriteriaView.jsp
  User: black
  Date: 9/26/2022
  Time: 7:32 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report Criteria</title>
</head>
<body>

  <div style="border-color:blue; width: 40ch; border-style: solid">
    <h3>Report Criteria</h3>
  <form method="get">
    <label for="id_begindate">Begin date:</label>
    <input id="id_begindate" type="date" name="begin_date"><br>
    <label for="id_enddate" >End date:</label>
    <input id="id_enddate" type="date" name="end_date"><br>
    <div><br>
      <input id="id_radio_orderinvoice" type="radio" name="report_type" value = "purchase_order" checked>
      <label for="id_radio_orderinvoice">Purchase Order</label><br>
      <input id="id_radio_orderproduct" type="radio" name="report_type" value="product_purchase">
      <label for="id_radio_orderproduct">Product Purchase</label><br>
    </div><br>
    <button type="submit" formaction="dispatchReport">Report</button>
    <button type="reset">Reset</button>
  </form></div>

</body>
</html>
