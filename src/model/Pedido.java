/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Observable;

public class Pedido extends Observable {

    private int id;
    private Cliente cliente;
    private String aparelho;
    private Date dataRecebido;
    private StatusPedido status;

    public Pedido(Cliente cliente, String aparelho) {
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.dataRecebido = new Date();
        this.status = new StatusRecebido();
        addObserver(cliente);
    }

    public Pedido(int id, Cliente cliente, String aparelho, Date dataRecebido, StatusPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.dataRecebido = dataRecebido;
        this.status = status;
        addObserver(cliente);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getAparelho() {
        return aparelho;
    }

    public Date getDataRecebido() {
        return dataRecebido;
    }

    public String getStatus() {
        return status.retornarStatus();
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void receber() throws InvalidStateChangeException {
        status.receber(this);
        setChanged();
        notifyObservers();
    }

    public void avaliar() throws InvalidStateChangeException {
        status.avaliar(this);
        setChanged();
        notifyObservers();
    }

    public void realizarManutencao() throws InvalidStateChangeException {
        status.realizarManutencao(this);
        setChanged();
        notifyObservers();
    }

    public void aguardarPeca() throws InvalidStateChangeException {
        status.aguardarPeca(this);
        setChanged();
        notifyObservers();
    }

    public void cancelar() throws InvalidStateChangeException {
        status.cancelar(this);
        setChanged();
        notifyObservers();
    }

    public void informarConserto() throws InvalidStateChangeException {
        status.informarConserto(this);
        setChanged();
        notifyObservers();
    }

    public void informarSemConserto() throws InvalidStateChangeException {
        status.informarSemConserto(this);
        setChanged();
        notifyObservers();
    }
}
