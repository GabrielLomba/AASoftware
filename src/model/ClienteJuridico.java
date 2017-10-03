package model;

public class ClienteJuridico extends Cliente{

    public ClienteJuridico(int codigo, String nome, String email) {
        super(codigo, nome, email);
    }

    @Override
    public String getTipo() {
        return "PJ";
    }
}
