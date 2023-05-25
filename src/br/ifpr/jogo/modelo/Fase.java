package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel{

    private Image planoDeFundo;
    private Personagem personagem;

    public Fase() {

        ImageIcon carregando = new ImageIcon("recursos\\planoDeFundo.png");
        this.planoDeFundo = carregando.getImage();

        this.personagem = new Personagem();
        this.personagem.carregar();
    }

    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.planoDeFundo, 0, 0,null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(), this.personagem.getPosicaoEmY(),null);
        g.dispose();
    }

}
