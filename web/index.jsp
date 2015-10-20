<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>
<body>
    <h1>Future Value Calculator</h1>
    
    <c:if test="${message != null}">
      <p><i>${message}</i></p>  
    </c:if>
    
    <form action="homework2" method="post">
        <input type="hidden" name="action" value="add">        
        <label class="pad_top">Investment Amount:</label>
        <input type="number" min="0" name="investment" value="${user.investment}"><br>
        <label class="pad_top">Yearly Interest Rate:</label>
        <input type="number" min="0" name="interest" value="${user.interest}"><br>
        <label class="pad_top">Number of Years:</label>
        <input type="number"  min="0" name="years" value="${user.years}"><br> 
        <label class="pad_top">Future Value:</label>
        <input type="submit" value="Calculate" class="margin_left">
    </form>
</body>
</html>


<%@ include file="/includes/footer.jsp" %>
