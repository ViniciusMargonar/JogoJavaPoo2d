package br.ifpr.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

    public class Personagem {

        private int posicaoEmX;
        private int posicaoEmY;
        private int deslocamentoEmX;
        private int deslocamentoEmY;
        private Image imagem;
        private int larguraImagem;
        private int alturaImagem;
        private static final int velocidadeDeslocamento = 10;
        private static final int POSICAO_INICIAL_X = 100;
        private static final int POSICAO_INICIAL_Y = 100;
        private ArrayList<Tiro> tiros;
        private ArrayList<Especial> especiais;
         



    public Personagem(int velocidadeDeslocamento) {
        this.posicaoEmX = POSICAO_INICIAL_X;
        this.posicaoEmY = POSICAO_INICIAL_Y;
        this.tiros = new ArrayList<Tiro>();
        this.especiais =  new ArrayList<Especial>();

    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\samurai.png");
        this.imagem = carregando.getImage();
        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public void atualizar(){
        this.posicaoEmX += this.deslocamentoEmX;
        this.posicaoEmY += this.deslocamentoEmY;
    }

    public void atirar(){
        int frenteNave = this.posicaoEmX + this.larguraImagem;
        int meioNave =  this.posicaoEmY + (this.alturaImagem / 2);

        
        Tiro tiro = new Tiro(frenteNave, meioNave);
        this.tiros.add(tiro);
    }

    public void ultimate(){
        int frenteNave = this.posicaoEmX + this.larguraImagem;
        int meioNave =  this.posicaoEmY + (this.alturaImagem / 2);

        
        Especial especial = new Especial(frenteNave, meioNave);
        this.especiais.add(especial);
    }

    

    public void mover(KeyEvent tecla){ // movimenta o personagem
        int codigo = tecla.getKeyCode();

        switch(codigo){
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = this.velocidadeDeslocamento;
                break;

            case KeyEvent.VK_W:
                this.deslocamentoEmY = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = -this.velocidadeDeslocamento;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = this.velocidadeDeslocamento;
                break;
        }
    }

    public void parar(KeyEvent tecla){ // para o personagem
        int codigo = tecla.getKeyCode();

        switch(codigo){
            case KeyEvent.VK_UP:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_DOWN:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_LEFT:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.deslocamentoEmX = 0;
                break;
            
            case KeyEvent.VK_W:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = 0;
                break;
        }
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

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
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

    public int getVelocidadeDeslocamento() {
        return this.velocidadeDeslocamento;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }


    public ArrayList<Especial> getEspeciais() {
        return this.especiais;
    }

    public void setEspeciais(ArrayList<Especial> especiais) {
        this.especiais = especiais;
    }

    

}