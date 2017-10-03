package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ClienteFactory {

    private static final int TIPO_PF = 1;
    private static final int TIPO_PJ = 2;

    public static Cliente getCliente(ResultSet rs) throws SQLException {
        int tipo = rs.getInt("tipo");
        Cliente cliente;
        switch(tipo){
            case TIPO_PF:
                cliente = new ClienteFisico(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("email"));
                break;
            case TIPO_PJ:
                cliente = new ClienteJuridico(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("email"));
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente inválido: " + tipo);
        }

        return cliente;
    }

}
