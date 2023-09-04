package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class ElementoGrafico {
private int posicaoEmX;
private int posicaoEmY;
private Image imagem;
private int larguraImagem;
private int alturaImagem;
private boolean visivel = true;

    public abstract void carregar();

    public abstract void atualizar();

    public Rectangle getRectangle() {
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
    }
    public boolean isVisivel() {
        return this.visivel;
    }

    public boolean getVisivel() {
        return this.visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
    
    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return this.posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

}