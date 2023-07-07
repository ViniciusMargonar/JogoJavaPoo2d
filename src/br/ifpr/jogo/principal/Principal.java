package br.ifpr.jogo.principal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ifpr.jogo.modelo.Fase;
import br.ifpr.jogo.modelo.FaseUm;
public class Principal extends JFrame {

    public Principal() {
        JOptionPane.showMessageDialog(this, "           LISTA DE COMANDOS\n\n MOVIMENTAR : WASD ou DIRECIONAIS\n\n ATIRAR : BARRA DE ESPAÇO\n\n ESPECIAL : R\n\n INICIAR/REINICIAR : Q \n\n PAUSAR/DESPAUSAR: P \\n ESC : SAIR");

        Fase fase = new FaseUm();
        super.add(fase);
        setVisible(true);
        setSize(1920, 1080);
        setTitle("Meu Jogo");
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}
