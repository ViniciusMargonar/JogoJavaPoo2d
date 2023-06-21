package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Fase extends JPanel implements ActionListener, KeyListener{

    private Image planoDeFundo;
    private Personagem personagem;
    private static final int DELAY = 5;
    private Timer timer;
    private static final int LARGURA_DA_JANELA = 1920;

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
    
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.planoDeFundo, 0, 0,null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(), this.personagem.getPosicaoEmY(),null);
        ArrayList<Tiro> tiros = personagem.getTiros();        
        for (Tiro tiro : tiros) {
            tiro.carregar();
            graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
        }

        g.dispose();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        else
            personagem.mover(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {
            personagem.parar(e);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            personagem.atualizar();
            ArrayList<Tiro> tiros = personagem.getTiros();
            for (Tiro tiro : tiros) {
                if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA)
                    // Remover da lista se estiver fora do campo de visão (LARGURA_DA_TELA)
                    tiros.remove(tiro);
                else
                    // Atualizar a posição do tiro.
                    tiro.atualizar();
            }
            repaint();
    }

}
