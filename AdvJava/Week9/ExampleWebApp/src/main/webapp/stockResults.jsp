<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--

This example JSP uses JTSL rather than scriplets to access data.

In the MoodSurvey servlet, an instance of a Mood is placed in the http session.

The code on this page gets that instance of out the session and uses'
it values to determine what to display to the user.

--%>

<%-- get the Mood instance out of the session context --%>
<jsp:useBean id="mood" class="com.origami.teach.model.Mood" scope="session">
    <c:set target='${stockquote}'  value='${sessionScope.get("stockquote")}'/>
</jsp:useBean>

<jsp:useBean id="mood1" class="com.origami.teach.model.Mood" scope="session">
    <c:set target='${stock}'  value='${sessionScope.get("stock")}'/>
</jsp:useBean>

<jsp:useBean id="mood2" class="com.origami.teach.model.Mood" scope="session">
    <c:set target='${interval}'  value='${sessionScope.get("interval")}'/>
</jsp:useBean>

<jsp:useBean id="mood3" class="com.origami.teach.model.Mood" scope="session">
    <c:set target='${listOfQuotes}'  value='${sessionScope.get("listOfQuotes")}'/>
</jsp:useBean>


<html>
<head>
    <title>Stock Response</title>
</head>
<body>

<%--

Now use the mood values to see what message to send to the user
Note the use of c:if which is a JSTL tag the makes it easy to do if statements in
JSP code. There JSTL tags for all common  operations
--%>

Here is the stock result of call mood.toString() but using JSTL: <br>
<br><br>
<c:out value="${stock}"/>
<c:out value="${stockquote}"/>
<c:out value="${interval}"/>
<c:out value="${listOfQuotes}"/>



<P>
    Thanks for taking our survey.
</P>

</body>
</html>
