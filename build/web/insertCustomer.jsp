<%-- 
    Document   : insertCustomer
    Created on : Oct 18, 2016, 8:37:15 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css insert.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1 align="center">Insert Customers</h1>
        <div class="ii">
            <form action="ControllerCustomers">
              <input type="text" placeholder="Username" name="txtUsername" ><br/>
              <input type="text" placeholder="Password" name="txtPassword"><br/>
              <input type="text" placeholder="Hoten" name="txtHoten"><br/>
              <input type="text" placeholder="Gioitinh" name="txtGioitinh"><br/>
              <input type="text" placeholder="Email" name="txtEmail"><br/>
              <input type="text" placeholder="Role" name="txtRole"><br/>
            <input type="submit" name="action" value="Insert">

        </form>
        </div>
          
    </body>
</html>
