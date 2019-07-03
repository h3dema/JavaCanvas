/*
 * esta classe chamará as demais classes que criaremos para escrever no canvas
 */
package com.blogspot.h3dema;

import com.blogspot.h3dema.formas.Quadrilatero;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author h3dema
 */
public class EscrevendoCanvas {

    public static Color getCorAleatoria() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();      
        return new Color(r, g, b);
    }
    
    /**
     * sem parâmetros de entrada
     */
    public static void main(String[] args) {
        JFrame tela = new JFrame("Tutorial para escrita direta no canvas"); // nossa tela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para garantir que a aplicação será fechada
        
        MyCanvas canvas = new MyCanvas();
        tela.getContentPane().add(canvas); // desenhamos o canvas dentro da tela

        // QUADRILATEROS
        for(int i = 0; i < 1; i++) {
            Point[] pontos = new Point[4];
            for(int j = 0; j <= 3; j++) {
                int x = (int) (Math.random() * 300);
                int y = (int) (Math.random() * 300);                
                pontos[j] = new Point(x, y);
            }
            Quadrilatero q = new Quadrilatero(pontos[0], pontos[1], pontos[2], pontos[3]);
            Color cor = getCorAleatoria();
            q.setCorBorda(cor);
            if (Math.random() > 0.5) {
                q.setCorFundo(cor);            
            }
            canvas.adicionar(q);
        }
        
        
        /*
        // CIRCULOS
        for(int i = 0; i < 30; i++) {
            int x = (int) (Math.random() * 300);
            int y = (int) (Math.random() * 300);
            int raio = (int) (Math.random() * 50);
            Circulo c = new Circulo(x, y, raio);
            Color cor = getCorAleatoria();
            c.setCorBorda(cor);
            if (Math.random() > 0.5) {
                c.setCorFundo(cor);            
            }
            canvas.adicionar(c);
        }
        
        // TRIANGULOS
        for(int i = 0; i < 30; i++) {
            Point[] pontos = new Point[3];
            for(int j = 0; j <= 2; j++) {
                int x = (int) (Math.random() * 300);
                int y = (int) (Math.random() * 300);                
                pontos[j] = new Point(x, y);
            }
            Triangulo t = new Triangulo(pontos[0], pontos[1], pontos[2]);
            Color cor = getCorAleatoria();
            t.setCorBorda(cor);
            if (Math.random() > 0.5) {
                t.setCorFundo(cor);            
            }
            canvas.adicionar(t);
        }
              
        // PONTOS
        for(int i = 0; i < 200; i++) {
            int x = (int) (Math.random() * 300);
            int y = (int) (Math.random() * 300);
            Ponto p = new Ponto(x, y);
            canvas.adicionar(p);
        }
        
        */
        
        tela.pack();
        tela.setVisible(true);
    }
}
