package  br.ifpr.jogo.modelo;

import br.ifpr.jogo.principal.Principal;
import javax.swing.ImageIcon;

public class Asteroide extends ElementoGrafico {
    
    private static final int VELOCIDADE = 2;

    public Asteroide(int xAleatorio, int yAleatorio){
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\asteroide.gif");
        super.setImagem(carregando.getImage());
    }

    @Override
    public void atualizar() {
        if (this.getPosicaoEmX() < 0) {
            int y = (int) (Math.random() * Principal.ALTURA_DA_JANELA);
            super.setPosicaoEmX(Principal.LARGURA_DA_JANELA);
            super.setPosicaoEmY(y);           
        } else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
        }
    }
}