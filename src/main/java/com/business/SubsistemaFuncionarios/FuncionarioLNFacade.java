package main.java.com.business.SubsistemaFuncionarios;

import main.java.com.business.Excecoes.FuncionarioNaoValidoException;

import java.util.List;
import java.util.Map;

public class FuncionarioLNFacade implements IFuncionarioLN {

    //Map<codFuncionario, Funcionario>
    private Map<String, Funcionario> funcionarios;


    //public List<codFunc> getTecnicos();
    public List<String> getTecnicos() {
        //TODO getTecnicos
        return null;
    }
    public Tecnico getTecnico(String codTecnico) {
        //TODO getTecnico
        return null;
    }
    //public List<codFunc> getFuncionariosBalcao();
    public List<String> getFuncionariosBalcao() {
        //TODO getFuncionariosBalcao
        return null;
    }

    //public List<codPedidoOrcamento>
    public List<String> getDadosEntregaDoFuncionario(String codFuncionario) throws FuncionarioNaoValidoException {
        //TODO getDadosEntregaDoFuncionario
        return null;
    }
    public FuncBalcao getFuncBalcao(String codFunc) {
        //TODO getFuncBalcao
        return null;
    }
}