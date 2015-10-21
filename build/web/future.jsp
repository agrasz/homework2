<!--Copyright Jack Landry and Lexa Grasz 2015-->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>

<body>
    <h1>Future Value Calculator</h1>

   

    <label class="display">Investment Amount:</label>
    <span>${user.investmentCurrencyFormat}</span><br>
    <label class="display">Yearly Interest Rate:</label>
    <span>${user.interest}</span><br>
    <label class="display">Number of Years:</label>
    <span>${user.years}</span><br>
    <label class="display">Future Value:</label>
    <span>${calculator.totalCurrencyFormat}</span><br>

    <form action="" method="post">
        <input type="hidden" name="action" value="join">
    </form>

</body>
</html>


<%@ include file="/includes/footer.jsp" %>