<html>
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
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
