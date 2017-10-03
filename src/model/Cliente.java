package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Cliente implements Observer {

    private List<String> mensagens = new ArrayList<>();
    private int codigo;
    private String nome;

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Cliente(String nome){
        this.nome = nome;
    }

    public String mostrarInformacoes() {
        return nome + "(" + getTipo() + ")";
    }

    public abstract String getTipo();

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getMensagens() {
        List<String> mensagensCopy = new ArrayList<>();
        mensagensCopy.addAll(mensagens);
        mensagens.clear();
        return mensagensCopy;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Pedido) {
            Pedido pedido = (Pedido) observable;
            mensagens.add("Cliente " + nome + ", seu pedido de conserto do aparelho " + pedido.getAparelho() +
                    " foi atualizado!. Novo status: " + pedido.getStatus());
        }
    }
}
