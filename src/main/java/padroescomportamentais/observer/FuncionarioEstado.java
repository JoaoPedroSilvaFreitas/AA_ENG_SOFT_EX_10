package padroescomportamentais.observer;

import java.util.Observable;

public abstract class FuncionarioEstado {
    
    public abstract String getEstado();

    public boolean ativo(Funcionario funcionario) {
        return false;
    }

    public boolean inativo(Funcionario funcionario) {
        return false;
    }

    public boolean desligado(Funcionario funcionario) {
        return false;
    }

    public void update(Funcionario funcionario, Observable pontoEletronico, Object arg) {
    }

}
