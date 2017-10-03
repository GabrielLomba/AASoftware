/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import model.Pedido;
import model.StatusFactory;
import model.StatusPedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void save(Pedido pedido) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into pedidos (cliente, aparelho) values ('" + pedido.getCliente() + "', '" + pedido.getAparelho() + "')");
        } finally {
            closeResources(conn, st);
        }
    }

    public Pedido search(String codigo) throws ClassNotFoundException, SQLException {
        Pedido pedido = null;
        Connection conn = null;
        Statement st = null;

        try {
            String query = "select * from pedido where codigo = '" + codigo + "'";

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                StatusPedido statusPedido = StatusFactory.getStatusPedido(rs.getInt("status"));
                pedido = new Pedido(rs.getInt("codigo"), rs.getString("cliente"), rs.getString("aparelho"),
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

    public void delete(String codigo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;

        try {
            String query = "DELETE FROM produto where codigo = '" + codigo + "'";

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
            String query = "select * from pedido";

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                StatusPedido statusPedido = StatusFactory.getStatusPedido(rs.getInt("status"));
                pedidos.add(new Pedido(rs.getInt("id"), rs.getString("cliente"),
                        rs.getString("aparelho"), rs.getDate("dataRecebido"), statusPedido));
            }
        } finally {
            closeResources(conn, st);
        }

        return pedidos;
    }
}
