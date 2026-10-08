package padroescomportamentais.observer;

import java.util.Observable;
import java.time.LocalDate;

public class PontoEletronico extends Observable {

    private String endereco;
    private LocalDate horario;

    public PontoEletronico(String endereco) {
        this.endereco = endereco;
        this.horario = null;
    }

    public void lancarHorario() {
        this.horario = LocalDate.now();
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "PontoEletronico{" +
                "endereco=" + endereco +
                ", horario=" + horario +
                '}';
    }
}
