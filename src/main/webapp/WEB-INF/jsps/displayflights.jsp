<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display flights</title>
</head>
<body>
<h2>Flight Search Result</h2>
<h2>List Of Flights</h2>
<table border="1">
<tr>
    <tr>
    <th>Airlines</th>
    <th>Departure City</th>
    <th>arrival City</th>
    <th>Departure Time</th>
    <th>Select Flight</th>
    </tr>
    <c:forEach items="${findFly}" var="findFly">
      <tr>
          <td>${findFly.operatingAirlines}</td>
          <td>${findFly.departureCity}</td>
          <td>${findFly.arrivalCity}</td>
          <td>${findFly.estimatedDepartureTime}</td>
          <td><a href="showCompleteReservation?flightId=${findFly.id}">select</a></td>
          
      </tr>
          
    </c:forEach>

</table>

</body>
</html>