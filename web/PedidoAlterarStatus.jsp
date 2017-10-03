<jsp:useBean id="bean" class="bean.StatusBean" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Alterar Status</title>
</head>
<body>
<h1>Alterar status do pedido</h1>

<br>Status atual: ${param.statusPedido}
<form action="FrontController?action=PedidoAlterarStatus" method="post">
    Mudar o status para:
    <select id="comboStatus" name="statusId">
        <option value="">..</option>
        <c:forEach var="statusPedido" items="${bean.status}" varStatus="loop">
            <option value="${loop.index + 1}">${statusPedido.retornarStatus()}</option>
        </c:forEach>
    </select>
    <input type="hidden" name="pedidoId" value="${param.pedidoId}">
    <input type="hidden" name="statusPedido" value="${param.statusPedido}">
    <input type="submit"/>
</form>

${resultado}
</body>
</html>
