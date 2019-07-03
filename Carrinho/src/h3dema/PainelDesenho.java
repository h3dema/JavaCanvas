/*
 * Esta classe fará o desenho e será inserida no JFrame da classe principal
 */

package h3dema;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 * utilizaremos um Timer para fazer a movimentação
 * @author Henrique
 */
public class PainelDesenho extends JComponent implements ActionListener {
    Carro2D carroSimples;
    int posicaoX = 0;
    
    Timer t;
    boolean timerRodando = false;
   
    /**
     * vamos animar uma imagem também
     */
    Image carroMelhor;
    
    public PainelDesenho() {
        carroSimples = new Carro2D(posicaoX, 0);
        /**
         * carregou na memória a imagem
         */
        carroMelhor = Toolkit.getDefaultToolkit().getImage("src/carro.jpg");
        t = new Timer(10, this);
    }
    
    /**
     * desenha o carro
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        int incremento = 1;
        carroSimples.move(g, incremento, getWidth()); // só funciona quando faz repaint
        
        /**
         * usamos drawImage() para desenhar
         */
        g.drawImage(carroMelhor, posicaoX, getHeight() / 2, null);
        /**
         * vamos atualizar a posição
         */
        posicaoX = (posicaoX + incremento) % getWidth();
        
        /**
         * precisamos ligar o timer para funcionar
         */
        if(!timerRodando) {
            t.start();
            timerRodando = true;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
