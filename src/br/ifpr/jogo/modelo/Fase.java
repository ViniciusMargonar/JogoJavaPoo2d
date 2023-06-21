package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener, KeyListener{

    private Image planoDeFundo;
    private Personagem personagem;
    private static final int DELAY = 5;
    private Timer timer;

    public Fase(){   
                          
        setFocusable(true);            
        setDoubleBuffered(true);       
        ImageIcon carregando = new ImageIcon("recursos\\planoDeFundo.jpg");
        planoDeFundo = carregando.getImage();
        personagem = new Personagem(); 
        personagem.carregar();        
        addKeyListener((KeyListener) this);          
        timer = new Timer(DELAY, (ActionListener) this);   
        timer.start();                
    }
    
    ImageIcon carregando = new ImageIcon("recursos\\planoDeFundo.jpg");
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.planoDeFundo, 0, 0,null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(), this.personagem.getPosicaoEmY(),null);
        g.dispose();
    }

}
