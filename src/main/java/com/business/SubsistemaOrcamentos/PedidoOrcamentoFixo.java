package com.business.SubsistemaOrcamentos;

import java.time.LocalDateTime;

public class PedidoOrcamentoFixo extends PedidoOrcamento {
    private String responsavel;

    public String getResponsavel() {
        return this.responsavel;
    }

    public PedidoOrcamentoFixo(String codEquipamento, LocalDateTime data, String registoBalcao, String codCliente, String responsavel) {
        super(codEquipamento, data, registoBalcao, codCliente);
        this.responsavel = responsavel;
    }
}
