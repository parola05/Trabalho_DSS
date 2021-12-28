package com.business.SubsistemaEquipamentos;

public class Equipamento {
    private String codEquipamento;
    private String nomeEquipamento;
    private String nifCliente;
    private static int nextId = 0;

    public Equipamento(String nomeEquipamento, String nifCliente) {
        this.nomeEquipamento = nomeEquipamento;
        this.nifCliente = nifCliente;
        this.codEquipamento = getNextId();
    }

    public String getCodEquipamento() {
        return codEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    private String getNextId() {
        try {
            return Integer.toString(nextId);
        } finally {
            nextId++;
        }
    }


}
