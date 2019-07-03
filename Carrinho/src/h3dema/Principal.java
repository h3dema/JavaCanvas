/**
 * nossa classe principal
 */
package h3dema;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Henrique
 */
public class Principal {
    
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        JFrame tela = new JFrame();
        tela.setSize(width, height);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // facha a tela se clicar no X
        tela.setTitle("Carrinhos");
        /**
         * para melhorar um pouquinho, vamos trocar o fundo
         */
        tela.getContentPane().setBackground(Color.white);
        
        /**
         * cria o painel de desenho
         */
        PainelDesenho p = new PainelDesenho();
        tela.add(p);
        
        tela.setVisible(true); // mostra o Frame
    }
    
}
