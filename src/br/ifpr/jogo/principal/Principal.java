package br.ifpr.jogo.principal;

import javax.swing.JFrame;

public class Principal extends JFrame{

    public Principal(){
        setVisible(true);
        setSize(640, 400);
        setTitle("Meu Jogo");
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}
