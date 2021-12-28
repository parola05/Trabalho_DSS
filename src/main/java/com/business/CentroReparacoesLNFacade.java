package com.business;

import com.business.Excecoes.*;
import com.business.SubsistemaClientes.Cliente;
import com.business.SubsistemaClientes.ClienteLNFacade;
import com.business.SubsistemaClientes.IClienteLN;
import com.business.SubsistemaEquipamentos.Equipamento;
import com.business.SubsistemaEquipamentos.EquipamentoLNFacade;
import com.business.SubsistemaEquipamentos.IEquipamentoLN;
import com.business.SubsistemaFuncionarios.FuncionarioLNFacade;
import com.business.SubsistemaFuncionarios.IFuncionarioLN;
import com.business.SubsistemaOrcamentos.IOrcamentosLN;
import com.business.SubsistemaOrcamentos.OrcamentosLNFacade;
import com.business.SubsistemaOrcamentos.Passo;

import java.time.LocalDateTime;
import java.util.List;

public class CentroReparacoesLNFacade implements ICentroReparacoesLN {
    IClienteLN clienteLN = new ClienteLNFacade();
    IEquipamentoLN equipamentoLN = new EquipamentoLNFacade();
    IFuncionarioLN funcionarioLN = new FuncionarioLNFacade();
    IOrcamentosLN orcamentosLN = new OrcamentosLNFacade();

    public boolean isTecnicoDisponivel() {
        return false;
    }

    //returns codOrcamento
    public String registarOrcamentoProgramado(String nif, String codTecnico, String codPedidoOrcamento)
            throws ClienteInvalidoException, FuncionarioInvalidoException, PedidoOrcamentoInvalidoException {
        boolean nifValido = clienteLN.validarCliente(nif);
        boolean tecnicoValido = funcionarioLN.validarTecnico(codTecnico);
        boolean pedidoOrcamentoValido = orcamentosLN.validarPedidoOrcamento(codPedidoOrcamento);

        if (nifValido && tecnicoValido && pedidoOrcamentoValido) {
        String codEquipamento = orcamentosLN.getEquipamentoPedido(codPedidoOrcamento);

        return orcamentosLN.registarOrcamentoProgramado(nif, codTecnico, codEquipamento);
        }
        else {
                // Eu sei que ele vai fazer throw da primeira condição que der falsa
                // mas assim sempre dá para perceber qual o problema exato
            if (!nifValido) throw new ClienteInvalidoException();
            else if (!tecnicoValido) throw new FuncionarioInvalidoException();
            else throw new PedidoOrcamentoInvalidoException();
        }
    }

    @Override
    public void adicionarPasso(String descricao, LocalDateTime previsaoTempo, double custoPecas, String codOrcamento, String passo)
            throws OrcamentoInvalidoException {
        orcamentosLN.adicionarPasso(descricao, previsaoTempo, custoPecas, codOrcamento, passo);
    }

    @Override
    public void assinalarPasso(LocalDateTime duracao, double custoReal, String passo, String codOrcamento)
            throws OrcamentoInvalidoException, PassoInvalidoException {
        orcamentosLN.assinalarPasso(duracao,custoReal,passo,codOrcamento);
    }

    public Passo getPasso(String codOrcamento, String passo) throws OrcamentoInvalidoException, PassoInvalidoException {
        return orcamentosLN.getPasso(codOrcamento, passo);
    }


    public List<Passo> getSubPassos(String codOrcamento, String passo)
            throws OrcamentoInvalidoException, PassoInvalidoException, SemSubPassosException {
        return null;
    }

    @Override
    public void registarPedidoOrcamento(String nif, String nomeEquipamento, String codFunc) throws ClienteInvalidoException {
        if (!validarCliente(nif)) throw new ClienteInvalidoException();
        String codEquipamento = equipamentoLN.registarEquipamento(nif, nomeEquipamento);
        orcamentosLN.registarPedidoOrcamento(nif, codEquipamento, codFunc);
    }

    // Clientes

    @Override
    public boolean validarCliente(String nif) {
        return clienteLN.validarCliente(nif);
    }

    public void registarCliente(String nif, String nome, String email, String telemovel) {
        clienteLN.registarCliente(nif, nome, email, telemovel);
    }
    // returns List<codCliente>
    public List<String> getClientes() {
        return clienteLN.getClientes();
    }
    public Cliente getCliente(String codCliente) throws ClienteInvalidoException {
        return clienteLN.getCliente(codCliente);
    }

    // Equipamentos
    public List<String> getEquipamentosAndamento() {
        return equipamentoLN.getEquipamentosAndamento();
    }
    public List<String> getEquipamentosPago() {
        return equipamentoLN.getEquipamentosPago();
    }
    public List<String> getEquipamentosPorPagar() {
        return equipamentoLN.getEquipamentosPorPagar();
    }
    public List<String> getEquipamentosRecusado() {
        return equipamentoLN.getEquipamentosRecusado();
    }
    public List<String> getEquipamentosAbandonado() {
        return equipamentoLN.getEquipamentosAbandonado();
    }
    public Equipamento getEquipamento(String codEquipamento) throws EquipamentoInvalidoException {
        return equipamentoLN.getEquipamento(codEquipamento);
    }
}
