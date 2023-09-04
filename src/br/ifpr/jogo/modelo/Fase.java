package br.ifpr.jogo.modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;


public abstract class Fase extends JPanel implements ActionListener, KeyListener{
    
    public static final int DELAY = 5; 
    public static final int LARGURA_DA_JANELA = 1920; 
    public static final int QTDE_DE_ASTEROIDES = 5;
    public static final int QTDE_DE_INIMIGOS = 40; 

    protected Image planoDeFundo; 
    protected Personagem personagem; 
    protected Timer timer; 
    protected ArrayList<Inimigo> inimigos; 
    protected boolean emJogo = true; 
    protected ArrayList<Asteroide> asteroides;
    
    //private static final int DESLOCAMENTO = 3; 


    public Fase(){
        
        this.setFocusable(true); // Permite o foco
        this.setDoubleBuffered(true); // Otimização do buffer
        this.addKeyListener(this); // adiciona o listener do teclado
        this.emJogo = true;       

        TrilhaSonora trilhaSonora = new TrilhaSonora();
        trilhaSonora.carregar();
        trilhaSonora.reproduzir();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            trilhaSonora.parar();
        }));
    }          

    public abstract void inicializaInimigos();
    public abstract void verificarColisoes();    
    public abstract void inicializaElementosGraficosAdicionais();
    
    @Override
    public abstract void keyTyped(KeyEvent e);

    @Override
    public abstract void keyPressed(KeyEvent e);
    
    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();
        // Recuperar a nossa lista de tiros (getTiros) e atribuímos para uma variável
        // local chamada tiros.
        ArrayList<Tiro> tiros = personagem.getTiros();
        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < tiros.size(); i++) {
            // Obter o objeto do tiro da posicao i do ArrayList
            Tiro tiro = tiros.get(i);
            // Verificar se (if) a posição do x (tiro.getPosicaoEmX()) é maior do que a
            // largura da nossa janela
            if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getVisivel())
                // Remover da lista se estiver fora do campo de visão (LARGURA_DA_JANELA)
                tiros.remove(tiro);
            else
                // Atualizar a posição do tiro.
                tiro.atualizar();
        }
        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < this.inimigos.size(); i++) {
            // Obter o objeto inimigo da posicao i do ArrayList
            Inimigo inimigo = this.inimigos.get(i);
            // Verificar se (if) a posição do x (inimigo.getPosicaoEmX()) é menor do que
            // a largura da nossa janela
            if (inimigo.getPosicaoEmX() < 0 || !inimigo.getVisivel())
                // Remover da lista se estiver fora do campo de visão (LARGURA_DA_JANELA)
                inimigos.remove(inimigo);
            else
                // Atualizar a posição do inimigo.
                inimigo.atualizar();
        }
        this.verificarColisoes();
        repaint();
    }

    public Image getFundo() {
        return this.planoDeFundo;
    }

    public void setFundo(Image fundo) {
        this.planoDeFundo = fundo;
    }

    public Personagem getPersonagem() {
        return this.personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public ArrayList<Inimigo> getInimigos() {
        return this.inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos) {
        this.inimigos = inimigos;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isEmJogo() {
        return this.emJogo;
    }

    public boolean getEmJogo() {
        return this.emJogo;
    }

    public void setEmJogo(boolean emJogo) {
        this.emJogo = emJogo;
    }

    public void desenhaPontuacao(Graphics2D graficos) {
        String textoPontuacao = "PONTOS: " + personagem.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoPontuacao, 20, 25);
    }

    public void desenhaVidas(Graphics2D graficos) {
        String textoVidas = "VIDAS: " + personagem.getVidas();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.drawString(textoVidas, 20, 45);
    }

}
    
    
    


