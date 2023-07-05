package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;


public class Inimigo extends ElementoGrafico {
    private static final int VELOCIDADE = 5;
    private boolean vivo;

     public Inimigo (int xAleatorio, int yAleatorio) {
        this.carregar();
        setPosicaoEmX(xAleatorio);
        setPosicaoEmY(yAleatorio);
        this.vivo = true;
    }

    public void carregar() {
        ImageIcon loading = new ImageIcon("recursos\\inimigo.gif");
        this.setImagem(loading.getImage());
        this.setAlturaImagem(this.getImagem().getWidth(null));
        this.setLarguraImagem(this.getImagem().getHeight(null));

    }

    public void atualizar() {
        if (!vivo){
            return;
        }
        this.setPosicaoEmX(this.getPosicaoEmX() - VELOCIDADE);
    }


    public boolean isVivo() {
        return this.vivo;
    }

    public boolean getVivo() {
        return this.vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    
}