package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;


public class Tiro extends ElementoGrafico{
    
    private static int VELOCIDADE = 5;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.setPosicaoEmX(posicaoPersonagemEmX);
        this.setPosicaoEmY(posicaoPersonagemEmY);

    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\tiro.gif");
        this.setImagem(carregando.getImage());
        this.setAlturaImagem(this.getImagem().getWidth(null));
        this.setLarguraImagem(this.getImagem().getHeight(null));
    }

    public void atualizar() {
        this.setPosicaoEmX(this.getPosicaoEmX() + VELOCIDADE);
    }


}