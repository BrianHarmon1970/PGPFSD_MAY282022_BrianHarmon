<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="DashBoardHeader.jsp"%>
</head>
<body>

<%

    String strNavigate = request.getParameter("nav") ;
    if ( strNavigate != null )
        resultSelectorBean.setNavigate( strNavigate ) ;
    int ndx = resultSelectorBean.getNdx() ;


    if( resultSelectorBean.size() > 0 ) {
        FlightDetailBean record = resultSelectorBean.getRecord();
        selectedRecord.setID(record.getID());
        selectedRecord.setDepartureCity(record.getDepartureCity());
        selectedRecord.setArrivalCity(record.getArrivalCity());
        selectedRecord.setAirlineName(record.getAirlineName());
        selectedRecord.setRequiredSeats(record.getRequiredSeats());
        selectedRecord.setTicketPrice(record.getTicketPrice());
        selectedRecord.setTravelDate(record.getTravelDate());

        criteriaBean.setID( record.getID() );
    }

    /*
    ArrayList<FlightDetailBean> queryResult = resultSelectorBean.getQueryResult() ;

    selectedRecord.setID( queryResult.get(ndx).getID()) ;
    selectedRecord.setDepartureCity( queryResult.get(ndx).getDepartureCity()) ;
    selectedRecord.setArrivalCity( queryResult.get(ndx).getArrivalCity()) ;
    selectedRecord.setAirlineName( queryResult.get(ndx).getAirlineName()) ;
    selectedRecord.setRequiredSeats( queryResult.get(ndx).getRequiredSeats()) ;
    selectedRecord.setTicketPrice( queryResult.get(ndx).getTicketPrice()) ;
    selectedRecord.setTravelDate( queryResult.get(ndx).getTravelDate()) ;*/

    //out.print( " <datalist id='flight_list' >"  ) ;
%>

<jsp:forward page="FlightDetailSelect.jsp"/>
</body>
</html>
