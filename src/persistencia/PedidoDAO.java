/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fernanda
 */
public class PedidoDAO {
    private static PedidoDAO instance;

    private PedidoDAO() {
    }

    public static PedidoDAO getInstance() {
        if (instance == null)
            instance = new PedidoDAO();
        return instance;
    }

    public void save(int tipoCliente, Pedido pedido) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String dataStr = new SimpleDateFormat("yyyy-MM-dd").format(pedido.getDataRecebido());
            String queryCliente = "INSERT INTO cliente(nome, tipo) VALUES('" + pedido.getCliente().getNome()
                    + "', " + tipoCliente + ");";
            String queryPedido = "INSERT INTO pedido (cliente, aparelho, dataRecebido, status) VALUES (LAST_INSERT_ID(), '" +
                    pedido.getAparelho() + "', '" + dataStr + "', " + StatusFactory.RECEBIDO + ");";
            st.execute(queryCliente + queryPedido);
        } finally {
            closeResources(conn, st);
        }
    }

    public Pedido search(String codigo) throws ClassNotFoundException, SQLException {
        Pedido pedido = null;
        Connection conn = null;
        Statement st = null;

        try {
            String query = "SELECT pedido.*,cliente.* FROM INNER JOIN cliente ON pedido.cliente = cliente.id" +
                    " WHERE pedido.id = " + codigo;

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                StatusPedido statusPedido = StatusFactory.getStatusPedido(rs.getInt("status"));
                Cliente cliente = ClienteFactory.getCliente(rs);
                pedido = new Pedido(rs.getInt("codigo"), cliente, rs.getString("aparelho"),
                        rs.getDate("data"), statusPedido);
            }
        } finally {
            closeResources(conn, st);
        }

        return pedido;
    }

    public void alter(Pedido pedido) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            String query = "UPDATE pedido SET cliente ='" + pedido.getCliente() + "' , "
                    + "     aparelho='" + pedido.getAparelho() + "' , "
                    + "     where codigo = '" + pedido.getId() + "'";

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute(query);

        } finally {
            closeResources(conn, st);
        }

    }

    private void closeResources(Connection conn, Statement st) throws SQLException {
        if (st != null) st.close();
        if (conn != null) conn.close();
    }

    public List<Pedido> searchAll() throws SQLException, ClassNotFoundException {
        List<Pedido> pedidos = new ArrayList<>();
        Connection conn = null;
        Statement st = null;

        try {
            String query = "SELECT pedido.*,cliente.* FROM pedido INNER JOIN cliente ON pedido.cliente = cliente.id";

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StatusPedido statusPedido = StatusFactory.getStatusPedido(rs.getInt("status"));
                Cliente cliente = ClienteFactory.getCliente(rs);
                pedidos.add(new Pedido(rs.getInt("id"), cliente, rs.getString("aparelho"),
                        rs.getDate("dataRecebido"), statusPedido));
            }
        } finally {
            closeResources(conn, st);
        }

        return pedidos;
    }
}
