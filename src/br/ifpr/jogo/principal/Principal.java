package br.ifpr.jogo.principal;

import javax.swing.JFrame;

import br.ifpr.jogo.modelo.Fase;
public class Principal extends JFrame {

    public Principal() {
        Fase fase = new Fase();
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
