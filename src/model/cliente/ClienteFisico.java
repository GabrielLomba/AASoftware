package model.cliente;

public class ClienteFisico extends Cliente {

    public ClienteFisico(int codigo, String nome) {
        super(codigo, nome);
    }

    public ClienteFisico(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "PF";
    }
}
