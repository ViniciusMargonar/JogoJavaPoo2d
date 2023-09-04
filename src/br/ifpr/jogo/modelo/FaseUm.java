package br.ifpr.jogo.modelo;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;

import br.ifpr.jogo.principal.Principal;

import java.awt.Color;
import java.awt.Font;


public class FaseUm extends Fase{

    private int tempo = 0;
    private boolean podeAtirar = true;
    private static final int PONTOS_POR_INIMIGO = 2;

     public FaseUm(){
        super();
        ImageIcon referencia = new ImageIcon("recursos\\planoDeFundo.gif");
        this.planoDeFundo = referencia.getImage();
        personagem = new Personagem();
        personagem.carregar();
        this.inicializaElementosGraficosAdicionais();
        timer = new Timer(DELAY, this);
        timer.start();
    }
    @Override
    public void inicializaElementosGraficosAdicionais() {
        super.asteroides = new ArrayList<Asteroide>();
            for (int i = 0; i < QTDE_DE_ASTEROIDES; i++) {
                int x = (int) (Math.random() * Principal.LARGURA_DA_JANELA);
                int y = (int) (Math.random() * Principal.ALTURA_DA_JANELA);
                Asteroide asteroide = new Asteroide(x, y);
                super.asteroides.add(asteroide);
            }
    }
       
     @Override
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;

        if(emJogo){
            graficos.drawImage(planoDeFundo, 0, 0, null);
            for (Asteroide asteroide : asteroides) {
                // Desenhar o asteroide na nossa tela.
                graficos.drawImage(asteroide.getImagem(), asteroide.getPosicaoEmX(), asteroide.getPosicaoEmY(), this);
            }
            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);
            ArrayList<Tiro> tiros = personagem.getTiros();
            ArrayList<Especial> especiais = personagem.getEspeciais();
            
            for(Tiro tiro : tiros){
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }

            for(Especial especial : especiais){
                especial.carregar();
                graficos.drawImage(especial.getImagem(), especial.getPosicaoEmX(), especial.getPosicaoEmY(), this);
            }

            for(Inimigo inimigo : inimigos){
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }

            super.desenhaPontuacao(graficos);
            super.desenhaVidas(graficos);

        }else{
            ImageIcon fimJogo = new ImageIcon("recursos\\gameover.jpg");
            graficos.drawImage(fimJogo.getImage(), 0, 0, null);
        }

        if(tempo >= 500){
            graficos.setColor(Color.WHITE);
            graficos.setFont(new Font("Calibri", Font.BOLD, 15));
            graficos.drawString("ULTIMATE DISPONÍVEL (R)", 20, 65);
        }

        graficos.dispose();
    }      
  
    @Override
    public void inicializaInimigos(){
        inimigos = new ArrayList<Inimigo>();

        for(int i = 0; i < QTDE_DE_INIMIGOS; i++){
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            inimigos.add(new Inimigo(x, y));
        }
    }

    @Override
    public void verificarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if (formaInimigo.intersects(formaPersonagem)) {
                personagem.perderVidas();
                inimigo.setVisivel(false);

                if (personagem.getVidas() <= 0) {
                    personagem.perderVidas();
                    emJogo = false;
                    this.personagem.setVisivel(false);
                    inimigo.setVisivel(false);
                    this.personagem.setVidas(3); //Rever essa LINHA

                }

            }
            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                    inimigo.setVisivel(false);
                    tiro.setVisivel(false);
                }
            }
            ArrayList<Especial> ultimates = this.personagem.getEspeciais();
            for (int a = 0; a < ultimates.size(); a++) {
                Especial ultimate = ultimates.get(a);
                Rectangle formaUltimate = ultimate.getRectangle();
                if (formaInimigo.intersects(formaUltimate)) {
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                    inimigo.setVisivel(false);
                    ultimate.setVisivel(false);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            emJogo = true;
            personagem.setVisivel(true);
            this.inicializaInimigos();
        }

        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE && podeAtirar){
            personagem.atirar();
            podeAtirar = false;
        }else{
            personagem.mover(e);
        }

        if(e.getKeyCode() == KeyEvent.VK_R && podeAtirar && tempo >= 500){
           personagem.ultimate();
           podeAtirar = false;
           tempo = 0;
        }else{
            personagem.mover(e);
        }

        if(e.getKeyCode() == KeyEvent.VK_Q){
           emJogo = true;
           personagem.carregar();
           this.inicializaInimigos();
           timer.restart();
        }

    }

     @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            podeAtirar = true;
        }else{
            personagem.parar(e);
        }

        if(e.getKeyCode() == KeyEvent.VK_R){
            podeAtirar = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tempo++;
        personagem.atualizar();
        for (Asteroide asteroide : this.asteroides) {
            asteroide.atualizar();
        }
        ArrayList<Especial> especiais = personagem.getEspeciais();
        for (int i = especiais.size() - 1; i >= 0; i--) {
                Especial especial = especiais.get(i);
                if (especial.getPosicaoEmX() > LARGURA_DA_JANELA || !especial.getVisivel())
                    // Remover da lista se estiver fora do campo de visão (LARGURA_DA_TELA)
                    especiais.remove(i);
                else
                    // Atualizar a posição do tiro.
                    especial.atualizar();
            }

            ArrayList<Tiro> tiros = personagem.getTiros();
            for (int i = tiros.size() - 1; i >= 0; i--) {
                Tiro tiro = tiros.get(i);
                if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getVisivel())
                    // Remover da lista se estiver fora do campo de visão (LARGURA_DA_TELA)
                    tiros.remove(i);
                else
                    // Atualizar a posição do tiro.
                    tiro.atualizar();
            }

            for (int i = 0; i < this.inimigos.size(); i++) {
                Inimigo inimigo = this.inimigos.get(i);
                if (inimigo.getPosicaoEmX() < 0 || !inimigo.getVisivel())
                    inimigos.remove(inimigo);
                else
                    inimigo.atualizar();
                
            }       
            this.verificarColisoes();
            repaint();
    }
}
    