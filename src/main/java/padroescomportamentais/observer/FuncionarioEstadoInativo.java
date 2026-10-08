package padroescomportamentais.observer;

public class FuncionarioEstadoInativo extends FuncionarioEstado{
    
    private FuncionarioEstadoInativo() {};
    private static FuncionarioEstadoInativo instance = new FuncionarioEstadoInativo();
    public static FuncionarioEstadoInativo getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Inativo";
    }
    
    public boolean ativo(Funcionario funcionario) {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        return true;
    }
    
    public boolean desligado(Funcionario funcionario) {
        funcionario.setEstado(FuncionarioEstadoDesligado.getInstance());
        return true;
    }
    

}
