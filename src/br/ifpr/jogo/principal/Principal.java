package br.ifpr.jogo.principal;

import javax.swing.JFrame;

//import br.ifpr.jogo.modelo.Fase;
import br.ifpr.jogo.modelo.FaseUm;

public class Principal extends JFrame {

    public static final int LARGURA_DA_JANELA = 1920;
    public static final int ALTURA_DA_JANELA = 1080;
    
    public Principal() {
       
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setTitle("Space Invaders - R&M Version");
        super.setSize(LARGURA_DA_JANELA, ALTURA_DA_JANELA);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}
