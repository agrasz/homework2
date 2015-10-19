<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/includes/header.html" %>

<body>
    <h1>Future Value Calculator</h1>

   

    <label>Investment Amount:</label>
    <span>${user.investment}</span><br>
    <label>Yearly Interest Rate:</label>
    <span>${user.interest}</span><br>
    <label>Number of Years:</label>
    <span>${user.years}</span><br>
    <label>Future Value:</label>
    <span>${user.futureValue}</span><br>

    <form action="" method="post">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>

</body>
</html>


<%@ include file="/includes/footer.jsp" %>