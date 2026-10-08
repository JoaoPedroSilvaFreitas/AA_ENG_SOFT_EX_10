package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String nome;
    private String ultimaNotificacao;
    private FuncionarioEstado estado;    

    public Funcionario(String nome) {
        this.nome = nome;
        this.estado = FuncionarioEstadoAtivo.getInstance();
    }

    public String getNome() {
        return this.nome;
    }


    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void setUltimaNotificacao(String ultimaNotificacao) {
        this.ultimaNotificacao = ultimaNotificacao;
    }

    public void registrarFuncionario(PontoEletronico pontoEletronico) {
        pontoEletronico.addObserver(this);
    }

    public void setEstado(FuncionarioEstado estado) {
        this.estado = estado;
    }

    public boolean ativo() {
        return estado.ativo(this);
    }
    
    public boolean inativo() {
        return estado.inativo(this);
    }
    
    public boolean desligado() {
        return estado.desligado(this);
    }

    public FuncionarioEstado getEstado() {
        return estado;
    }   

    public void update(Observable pontoEletronico, Object arg1) {
        this.estado.update(this, pontoEletronico, arg1);
    }
}
