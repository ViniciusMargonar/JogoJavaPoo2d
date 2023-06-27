package br.ifpr.jogo.modelo;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class TrilhaSonora {
    private Clip clip;

    public void carregar() {
        try {
            File arquivo = new File("recursos\\trilhaSonora.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivo);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproduzir() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void parar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
