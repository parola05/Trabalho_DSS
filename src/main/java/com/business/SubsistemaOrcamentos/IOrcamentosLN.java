package com.business.SubsistemaOrcamentos;

import com.business.Excecoes.*;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrcamentosLN {
    public List<String> getOrcamentosDoTecnico(String codTecnico);
    // public List<codOrcamento> getOrcamentos();
    public List<String> getOrcamentos();
    public Orcamento getOrcamento(String codOrcamento) throws OrcamentoInvalidoException;
    public void registarPagamento(String codOrcamento);
    public void arquivarOrcamentoRecusado(String codOrcamento);
    public void arquivarOrcamentosSemConfirmacao();
    // public codOrcamento registarOrcamento(...);
    public String registarOrcamentoProgramado(String nif, String codTecnico, String codEquipamento);
    public void registarOrcamentoConcluido(String codOrcamento);
    // Não me lembro do contexto desta função
    // Mas ela não deveria retornar alguma coisa?
    public void verificarCustoUltrapassado(String codOrcamennto);
    // public codOrcamento registarOrcamentoFixo(...);
    public String registarOrcamentoFixo(String nif, String produto, String codPedidoOrcamento) throws PedidoOrcamentoInvalidoException, ProdutoInvalidoException;
    public void registarOrcamentoFixoConcluido(String codOrcamento);
    // public void registarPlanoTrabalho();
    // TODO verificar este método está na interface mais genérica
    public String registarPlanoTrabalho();
    public void adicionarPasso(String descricao, LocalDateTime previsaoTempo, double previsaoCusto, String codOrcamento, String passo)
            throws OrcamentoInvalidoException;
    // Tinhamos concordado que os noPasso era uma String certo?
    public void assinalarPasso(LocalDateTime duracao, double custo, String passo, String codOrcamente)
            throws OrcamentoInvalidoException, PassoInvalidoException;
    public PlanoTrabalho getPlanoTrabalho(String codOrcamento) throws OrcamentoInvalidoException;

    // Métodos relativos aos pedidos de orçamento
    public void registarPedidoOrcamento(String nif, String nomeEquipamento, String codFunc);
    // public List<codPedidoOrcamento> getPedidosOrcamento();
    public List<String> getPedidosOrcamento();
    // public codEquipamento getEquipamentoPedido(String codPedidoOrcamento);
    public String getEquipamentoPedido(String codPedidoOrcamento) throws PedidoOrcamentoInvalidoException;
    public PedidoOrcamento getPedidoOrcamento(String codPedidoOrcamento);
    public void registarPedidoOrcamentoExpresso(String nif, String nomeEquipamento, String codFunc, String codTecnico);
    //public codEquipamento getCodEquipamentoOrcamento(String codOrcamento);
    public String getCodEquipamentoOrcamento(String codOrcamento);
    public void registarOrcamentoAndamento(String codOrcamento);
    public void removePedidoOrcamento(String codPedidoOrcamento);
    public boolean validarPedidoOrcamento(String codPedidoOrcamento);
    public Passo getPasso(String codOrcamento, String passo) throws OrcamentoInvalidoException, PassoInvalidoException;
    public List<Passo> getSubPassos(String codOrcamento, String passo)
            throws OrcamentoInvalidoException, PassoInvalidoException, SemSubPassosException;
    public List<String> getOrcamentosPorConfirmar();
    public List<String> getOrcamentosAndamento();
    public List<String> getOrcamentosPorPagar();
    public List<String> getOrcamentosPagos();
    public List<String> getOrcamentosArquivados();

}
