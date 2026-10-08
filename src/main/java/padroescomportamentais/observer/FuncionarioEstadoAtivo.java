package padroescomportamentais.observer;

import java.util.Observable;

public class FuncionarioEstadoAtivo extends FuncionarioEstado{
    
    private FuncionarioEstadoAtivo() {};
    private static FuncionarioEstadoAtivo instance = new FuncionarioEstadoAtivo();
    public static FuncionarioEstadoAtivo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Ativo";
    }
    
    public boolean inativo(Funcionario funcionario) {
        funcionario.setEstado(FuncionarioEstadoInativo.getInstance());
        return true;
    }
    
    public boolean desligado(Funcionario funcionario) {
        funcionario.setEstado(FuncionarioEstadoDesligado.getInstance());
        return true;
    }

    public void update(Funcionario funcionario, Observable pontoEletronico, Object arg) {
        funcionario.setUltimaNotificacao(
            funcionario.getNome() + ", ponto registrado em " + pontoEletronico.toString()
        );
    }
    

}
