/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author fernanda
 */
public class StatusConsertado implements StatusPedido {

    @Override
    public void receber(Pedido pedido) throws InvalidStateChangeException {
        throw new InvalidStateChangeException("Mudança de status de \'Consertado\' para \'Recebido\' é inválida!");
    }

    @Override
    public void avaliar(Pedido pedido) throws InvalidStateChangeException {
        throw new InvalidStateChangeException("Mudança de status de \'Consertado\' para \'Em avaliação\' é inválida!");
    }

    @Override
    public void realizarManutencao(Pedido pedido) throws InvalidStateChangeException {
        throw new InvalidStateChangeException("Mudança de status de \'Consertado\' para \'Em manutenção\' é inválida!");
    }

    @Override
    public void aguardarPeca(Pedido pedido) throws InvalidStateChangeException {
        throw new InvalidStateChangeException("Mudança de status de \'Consertado\' para \'Aguardando peça\' é inválida!");
    }

    @Override
    public void cancelar(Pedido pedido) throws InvalidStateChangeException {
        throw new InvalidStateChangeException("Mudança de status de \'Consertado\' para \'Cancelado\' é inválida!");
    }

    @Override
    public void informarSemConserto(Pedido pedido) throws InvalidStateChangeException {
        throw new InvalidStateChangeException("Mudança de status de \'Consertado\' para \'Sem Conserto\' é inválida!");
    }

    @Override
    public void informarConserto(Pedido pedido) throws InvalidStateChangeException {

    }

    @Override
    public String retornarStatus() {
        return "Consertado";
    }
}
