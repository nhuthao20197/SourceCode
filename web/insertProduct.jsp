<%-- 
    Document   : insertProduct
    Created on : Oct 11, 2016, 9:09:01 AM
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
       <h1 align="center">Insert Product</h1>
        <div class="ii">
            
              <form align="center"  action="ControllerProducts">
                  <input type="text" placeholder="Code" name="txtCode"  ><br/>
                 <input type="text" placeholder="Name"name="txtName"><br/>
                 <input type="text"placeholder="Price" name="txtPrice"><br/>
                 <input type="submit" name="action" value="Insert">

        </form>
        </div>
      
    </body>
</html>
