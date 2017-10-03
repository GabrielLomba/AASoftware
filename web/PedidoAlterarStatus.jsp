<%-- 
    Document   : PedidoAlterar
    Created on : 28/09/2017, 20:36:35
    Author     : fernanda
--%>
<jsp:useBean id="bean" class="bean.StatusBean" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Status</title>
    </head>
    <body>
    <h1>Alterar status do pedido</h1>

    <br>Status atual: <%= request.getParameter("statusPedido") %>
    <form action="FrontController?action=PedidoAlterarStatus" method="post">
        Mudar o status para:
        <select id="comboStatus" name="textStatusId">
            <option value="">..</option>
            <c:forEach var="statusPedido" items="${bean.status}" varStatus="loop">
                <option value="${loop.index + 1}">${statusPedido.retornarStatus}</option>
            </c:forEach>
        </select>
        <input type="hidden" name="textPedidoId" value="${pedidoId}">
        <input type="submit"/>
    </form>
    </body>
</html>
