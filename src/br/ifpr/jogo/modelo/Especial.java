package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;


public class Especial extends ElementoGrafico{
    private static int VELOCIDADE = 5;

    public Especial(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.carregar();
        this.setPosicaoEmX(posicaoPersonagemEmX);
        this.setPosicaoEmY(posicaoPersonagemEmY);

    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\especial.gif");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getWidth(null));
        this.setLarguraImagem(this.getImagem().getHeight(null));
    }

    public void atualizar() {
        this.setPosicaoEmX(this.getPosicaoEmX() + VELOCIDADE);
    }

}