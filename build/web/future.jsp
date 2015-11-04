
<!--Copyright Jack Landry and Lexa Grasz 2015-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/graszlandry.tld" prefix="elon"  %>
<%@ include file="/includes/header.html" %>


<body>
  <h1>Future Value Calculator</h1>

   

    <label class="display">Investment Amount:</label>
    <span><elon:currencyFormat investment="${user.investment}"/> </span><br>
    <label class="display">Yearly Interest Rate:</label>
    <span>${user.interest}</span><br>
    <label class="display">Number of Years:</label>
    <span>${user.years}</span><br>
    <label class="display">Future Value:</label>
    <span><elon:currencyFormat investment="${calculator.futureValue}"/></span><br>
    
    <table>
      <tr>
        <th>Year</th>
        <th>Value</th> 
      </tr>
      <c:forEach var="year" items="${years.user.years}">
        <tr>
          <td>
            <c:out value='${user.years}'/>
          </td>
          <td>
            <c:out value='${calculator.futureValue}'/>
          </td>
        </tr>
      </c:forEach>
      
    </table>
 

        
        <a href="<c:url value='/calculate' />">Return to Calculator</a>
  

<%@ include file="/includes/footer.jsp" %>