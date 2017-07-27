<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Stock Response</title>
</head>
<body>
    
    <h2>Stock Name: ${sessionScope.get("stock")}</h2> 
    <h3>Interval: ${sessionScope.get("interval")}</h3>
    <h5>Source: ${sessionScope.get("source")}</h5>

    <div style="margin:30px;width:600px;height:700px;line-height:3em;overflow:scroll;padding:25px;">
        <p>${sessionScope.get("listOfQuotes")}</p>
    </div>





</body>
</html>
