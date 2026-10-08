package padroescomportamentais.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate; 

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        funcionario = new Funcionario("João");
    }


    // Funcionario Ativo
    @Test
    public void naoDeveAtivarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertFalse(funcionario.ativo());
    }

    @Test
    public void deveInativarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.inativo());
        assertEquals(FuncionarioEstadoInativo.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveDesligarFuncionarioAtivo() {
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        assertTrue(funcionario.desligado());
        assertEquals(FuncionarioEstadoDesligado.getInstance(), funcionario.getEstado());
    }


    // Funcionario Inativo
    @Test
    public void naoDeveInativarFuncionarioInativo() {
        funcionario.setEstado(FuncionarioEstadoInativo.getInstance());
        assertFalse(funcionario.inativo());
    }

    @Test
    public void deveAtivarFuncionarioInativo() {
        funcionario.setEstado(FuncionarioEstadoInativo.getInstance());
        assertTrue(funcionario.ativo());
        assertEquals(FuncionarioEstadoAtivo.getInstance(), funcionario.getEstado());
    }

    @Test
    public void deveDesligarFuncionarioInativo() {
        funcionario.setEstado(FuncionarioEstadoInativo.getInstance());
        assertTrue(funcionario.desligado());
        assertEquals(FuncionarioEstadoDesligado.getInstance(), funcionario.getEstado());
    }


    // Funcionario Desligado
    @Test
    public void naoDeveDesligarFuncionarioDesligado() {
        funcionario.setEstado(FuncionarioEstadoInativo.getInstance());
        assertFalse(funcionario.inativo());
    }

    @Test
    public void naoDeveAtivarFuncionarioDesligado() {
        funcionario.setEstado(FuncionarioEstadoDesligado.getInstance());
        assertFalse(funcionario.ativo());
    }

    @Test
    public void naoDeveInativarFuncionarioDesligado() {
        funcionario.setEstado(FuncionarioEstadoDesligado.getInstance());
        assertFalse(funcionario.inativo());
    }
    
    @Test
    void naoDeveNotificarUmfuncionarioInativo() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario = new Funcionario("funcionario 1");
        funcionario.setEstado(FuncionarioEstadoInativo.getInstance());
        funcionario.registrarFuncionario(pontoEletronico);
        pontoEletronico.lancarHorario();
        assertEquals(null, funcionario.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUmfuncionarioDesligado() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario = new Funcionario("funcionario 1");
        funcionario.setEstado(FuncionarioEstadoDesligado.getInstance());
        funcionario.registrarFuncionario(pontoEletronico);
        pontoEletronico.lancarHorario();
        assertEquals(null, funcionario.getUltimaNotificacao());
    }
    
    @Test
    void deveNotificarUmfuncionario() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario = new Funcionario("funcionario 1");
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario.registrarFuncionario(pontoEletronico);
        pontoEletronico.lancarHorario();
        assertEquals("funcionario 1, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario.getUltimaNotificacao());
    }


    @Test
    void deveNotificarfuncionarios() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario1 = new Funcionario("funcionario 1");
        Funcionario funcionario2 = new Funcionario("funcionario 2");
        funcionario1.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario2.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario1.registrarFuncionario(pontoEletronico);
        funcionario2.registrarFuncionario(pontoEletronico);
        pontoEletronico.lancarHorario();
        assertEquals("funcionario 1, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario1.getUltimaNotificacao());
        assertEquals("funcionario 2, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarfuncionario() {
        PontoEletronico pontoEletronico = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        Funcionario funcionario = new Funcionario("funcionario 1");
        funcionario.setEstado(FuncionarioEstadoAtivo.getInstance());
        pontoEletronico.lancarHorario();
        assertEquals(null, funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarfuncionariopontoEletronicoA() {
        PontoEletronico pontoEletronicoA = new PontoEletronico("Juiz de Fora - MG, Rua 123");
        PontoEletronico pontoEletronicoB = new PontoEletronico("Juiz de Fora - MG, Rua das Dores");
        Funcionario funcionario1 = new Funcionario("funcionario 1");
        Funcionario funcionario2 = new Funcionario("funcionario 2");
        funcionario1.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario2.setEstado(FuncionarioEstadoAtivo.getInstance());
        funcionario1.registrarFuncionario(pontoEletronicoA);
        funcionario2.registrarFuncionario(pontoEletronicoB);
        pontoEletronicoA.lancarHorario();
        assertEquals("funcionario 1, ponto registrado em PontoEletronico{endereco=Juiz de Fora - MG, Rua 123, horario=" + LocalDate.now() + "}", funcionario1.getUltimaNotificacao());
        assertEquals(null, funcionario2.getUltimaNotificacao());
    }
}