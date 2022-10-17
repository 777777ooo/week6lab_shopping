<%-- 
    Document   : register
    Created on : Oct 16, 2022, 2:05:29 PM
    Author     : Dont1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username: <input type = "text" name = "username"><br>
            <input type  = "hidden" name= "action" value = "register">
            <br>
            <input type  ="submit"  value ="Register">
        </form>
    </body>
</html>
