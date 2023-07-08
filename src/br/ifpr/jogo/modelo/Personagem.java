package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

    public class Personagem extends ElementoGrafico{

        private int deslocamentoEmX;
        private int deslocamentoEmY;
        private static final int velocidadeDeslocamento = 2;
        private static final int POSICAO_INICIAL_X = 100;
        private static final int POSICAO_INICIAL_Y = 100;
        private ArrayList<Tiro> tiros;
        private ArrayList<Especial> especiais;
        private long ultimoUsoEspecial;
         



    public Personagem() {
        this.tiros = new ArrayList<Tiro>();
        this.especiais = new ArrayList<Especial>();
        this.deslocamentoEmX = 0;
        this.deslocamentoEmY = 0;
        setPosicaoEmX(POSICAO_INICIAL_X);
        setPosicaoEmY(POSICAO_INICIAL_Y);
    }


    public void carregar() {
        ImageIcon loading = new ImageIcon("recursos\\samurai.png");
        setImagem(loading.getImage());
        setAlturaImagem(getImagem().getWidth(null));
        setLarguraImagem(getImagem().getHeight(null));
        setPosicaoEmX(POSICAO_INICIAL_X);
        setPosicaoEmY(POSICAO_INICIAL_Y);
    }

    public void atualizar() {
       this.setPosicaoEmX((this.getPosicaoEmX() + this.getDeslocamentoEmX()));
       this.setPosicaoEmY((this.getPosicaoEmY() + this.getDeslocamentoEmY()));
    }

    public void atirar(){
        int frenteNave = this.getPosicaoEmX() + this.getLarguraImagem();
        int meioNave =  this.getPosicaoEmY() + (this.getAlturaImagem() / 2);

        
        Tiro tiro = new Tiro(frenteNave, meioNave);
        this.tiros.add(tiro);
    }

    public void ultimate(){
        long tempoAtual = System.currentTimeMillis();

        if (tempoAtual - ultimoUsoEspecial >= 1000) {
            int frenteNave = this.getPosicaoEmX() + this.getLarguraImagem();
            int meioNave =  this.getPosicaoEmY() + (this.getAlturaImagem() / 2);

            
            Especial especial = new Especial(frenteNave, meioNave);
            this.especiais.add(especial);
            ultimoUsoEspecial = tempoAtual;
        }
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