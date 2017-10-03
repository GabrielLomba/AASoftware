<%@ page import="model.ClienteFactory" %><%--
    Document   : PedidoCadastrar
    Created on : 28/09/2017, 19:51:27
    Author     : fernanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        <h1>Cadastrar</h1>
        
        <form action="FrontController?action=PedidoCadastrar" method="post">
            Cliente:
            <input type="text" name="nomeCliente"/>
            <select id="comboTipo" name="tipoCliente">
                <option value="<%= ClienteFactory.TIPO_PF %>">Pessoa física</option>
                <option value="<%= ClienteFactory.TIPO_PJ %>">Pessoa jurídica</option>
            </select><br/>
            Aparelho:
            <input type="text" name="textAparelho"/><br/>  
            <input type="submit"/>
        </form>

        ${resultado}
    </body>
</html>

