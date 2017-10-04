package model.cliente;

public class ClienteJuridico extends Cliente {

    public ClienteJuridico(int codigo, String nome) {
        super(codigo, nome);
    }

    public ClienteJuridico(String nome) {
        super(nome);
    }

    @Override
    public String getTipo() {
        return "PJ";
    }
}
