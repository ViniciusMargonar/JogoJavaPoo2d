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
    private static final int DESLOCAMENTO = 3; 

     public Fase(){
        this.setFocusable(true); // Permite o foco
        this.setDoubleBuffered(true); // Otimização do buffer

        ImageIcon carregando = new ImageIcon("recursos\\planoDeFundo.gif");
        this.planoDeFundo = carregando.getImage();

        this.personagem = new Personagem(DESLOCAMENTO);
        this.personagem.carregar();
        this.addKeyListener(this); // adiciona o listener do teclado

        this.timer = new Timer(DELAY, this); // cria o timer
        this.timer.start(); // inicia o timer
    }

    
    public void paint(Graphics g) {

        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.planoDeFundo, 0, 0,null);
        graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(), this.personagem.getPosicaoEmY(),null);
        ArrayList<Especial> especiais = personagem.getEspeciais();
        for (Especial especial : especiais) {
            especial.carregar();
            graficos.drawImage(especial.getImagem(), especial.getPosicaoEmX(), especial.getPosicaoEmY(), this); 
        }   
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

        else if (e.getKeyCode() == KeyEvent.VK_R)
            personagem.ultimate();
        
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
            ArrayList<Especial> especiais = personagem.getEspeciais();
            for (int i = especiais.size() - 1; i >= 0; i--) {
                Especial especial = especiais.get(i);
                if (especial.getPosicaoEmX() > LARGURA_DA_JANELA)
                    // Remover da lista se estiver fora do campo de visão (LARGURA_DA_TELA)
                    especiais.remove(i);
                else
                    // Atualizar a posição do tiro.
                    especial.atualizar();
            }
            ArrayList<Tiro> tiros = personagem.getTiros();
            for (int i = tiros.size() - 1; i >= 0; i--) {
                Tiro tiro = tiros.get(i);
                if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA)
                    // Remover da lista se estiver fora do campo de visão (LARGURA_DA_TELA)
                    tiros.remove(i);
                else
                    // Atualizar a posição do tiro.
                    tiro.atualizar();
            }
            repaint();
    }

}
