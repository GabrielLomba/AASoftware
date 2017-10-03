/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 * @author fernanda
 */
public class Pedido {

    private int id;
    private String cliente;
    private String aparelho;
    private Date dataRecebido;
    private StatusPedido status;

    public Pedido(String cliente, String aparelho) {
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.dataRecebido = new Date();
        this.status = new StatusRecebido();
    }

    public Pedido(int id, String cliente, String aparelho, Date dataRecebido, StatusPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.aparelho = aparelho;
        this.dataRecebido = dataRecebido;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAparelho() {
        return aparelho;
    }

    public void setAparelho(String aparelho) {
        this.aparelho = aparelho;
    }

    public Date getDataRecebido() {
        return dataRecebido;
    }

    public void setDataRecebido(Date dataRecebido) {
        this.dataRecebido = dataRecebido;
    }

    public String getStatus() {
        return status.retornarStatus();
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void receber() throws InvalidStateChangeException {
        status.receber(this);
    }

    public void avaliar() throws InvalidStateChangeException {
        status.avaliar(this);
    }

    public void realizarManutencao() throws InvalidStateChangeException {
        status.realizarManutencao(this);
    }

    public void aguardarPeca() throws InvalidStateChangeException {
        status.aguardarPeca(this);
    }

    public void cancelar() throws InvalidStateChangeException {
        status.cancelar(this);
    }

    public void informarConserto() throws InvalidStateChangeException {
        status.informarConserto(this);
    }

    public void informarSemConserto() throws InvalidStateChangeException {
        status.informarSemConserto(this);
    }
}
