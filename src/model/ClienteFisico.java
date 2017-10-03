package model;

public class ClienteFisico extends Cliente {

    public ClienteFisico(int codigo, String nome, String email) {
        super(codigo, nome, email);
    }

    @Override
    public String getTipo() {
        return "PF";
    }
}
