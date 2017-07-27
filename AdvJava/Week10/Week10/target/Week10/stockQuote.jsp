<html>

<body>
<h2>Stock Quote Page</h2>

<h3>
    <UL>
        <form name="myform" action="servlets/ServletForwardingExample/" method="get">
            <input type="text" class="form-control" name="stock" placeholder="Stock Symbol (ex. GOOG)"><br>
            <input type="text" class="form-control" name="from" placeholder="Date From (YYYY-MM-DD)"><br>
            <input type="text" class="form-control" name="until" placeholder="Date Until (YYYY-MM-DD)"><br>
            Interval:
            <select id="interval" name="interval"><br>
                <option value="DAILY">Daily</option>
                <option value="WEEKLY">Weekly</option>
                <option value="MONTHLY">Monthly</option>
              </select><br>
              
            <select id="source" name="source"><br>
                <option value="YAHOO">Yahoo Stock API</option>
                <option value="SQL">Local MySQL Database</option>
              </select><br>
            <input type="SUBMIT" class="btn-info" value="Submit">
            <input type="HIDDEN" name="submit" value="true">
        </form>


       
    </UL>
</h3>
</body>
</html>
