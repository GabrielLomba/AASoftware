/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import model.Cliente;
import model.ClienteFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fernanda
 */
public class ClienteDAO {

    private static ClienteDAO instance;

    private ClienteDAO() {

    }

    public static ClienteDAO getInstance() {
        if (instance == null)
            instance = new ClienteDAO();
        return instance;
    }

    public Cliente search(String id) throws ClassNotFoundException, SQLException {
        Cliente cliente = null;
        Connection conn = null;
        Statement st = null;

        try {
            String query = "select * from cliente where codigo = " + id;

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                cliente = ClienteFactory.getCliente(rs);
            }
        } finally {
            closeResources(conn, st);
        }

        return cliente;
    }

    public List<Cliente> searchAll() throws ClassNotFoundException, SQLException {
        List<Cliente> clientes = new ArrayList();
        Connection conn = null;
        Statement st = null;

        try {
            String query = "select * from cliente ";

            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                clientes.add(ClienteFactory.getCliente(rs));
            }
        } finally {
            closeResources(conn, st);
        }

        return clientes;
    }

    private void closeResources(Connection conn, Statement st) throws SQLException {
        if (st != null) st.close();
        if (conn != null) conn.close();
    }
}
