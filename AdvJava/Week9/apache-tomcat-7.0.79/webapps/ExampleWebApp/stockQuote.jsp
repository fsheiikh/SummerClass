<html>
<body>
<h2>Stock Quote Page</h2>

<h3>
    <UL>
        <form name="myform" action="servlets/ServletForwardingExample/" method="get">
            <input type="text" name="stock" placeholder="stock symbol">
            <input type="text" name="from" placeholder="date from ">
            <input type="text" name="until" placeholder="date until">
            Interval:
            <select id="interval" name="interval">
                <option value="DAILY">Daily</option>
                <option value="WEEKLY">Weekly</option>
                <option value="YEARLY">Yearly</option>
              </select>
            <input type="SUBMIT" value="Submit">
            <input type="HIDDEN" name="submit" value="true">
        </form>


       
    </UL>
</h3>
</body>
</html>
