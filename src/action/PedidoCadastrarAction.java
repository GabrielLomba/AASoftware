/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import model.Pedido;
import persistencia.PedidoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author fernanda
 */
public class PedidoCadastrarAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cliente = request.getParameter("textCliente");
        String aparelho = request.getParameter("textAparelho");

        if (cliente.equals("") || aparelho.equals("")) {
            response.sendRedirect("PedidoCadastrar.jsp");
        } else {
            try {
                Pedido pedido = new Pedido(cliente, aparelho);
                PedidoDAO.getInstance().save(pedido);
                request.setAttribute("resultado", "Pedido cadastrado com sucesso!");
            } catch (SQLException | ClassNotFoundException ex) {
                request.setAttribute("resultado", "Pedido cadastrado com sucesso!");
                ex.printStackTrace();
            }

            RequestDispatcher rd = request.getRequestDispatcher("PedidoCadastrar.jsp");
            rd.forward(request, response);
        }
    }

}
