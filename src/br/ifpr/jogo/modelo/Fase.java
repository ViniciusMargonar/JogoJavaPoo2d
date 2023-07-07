package br.ifpr.jogo.modelo;

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
    public static final int QTDE_DE_INIMIGOS = 40; 

    protected Image planoDeFundo; 
    protected Personagem personagem; 
    protected Timer timer; 
    protected ArrayList<Inimigo> inimigos; 
    protected boolean emJogo = true; 

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

    @Override
    public abstract void keyTyped(KeyEvent e);

    @Override
    public abstract void keyPressed(KeyEvent e);
    
    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}

