/*
 * desenha um carrinho simples usando Graphics2D
 */
package h3dema;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Henrique
 */
public class Carro2D {
    
    Point posicao;
    
    public Carro2D(int x, int y) {
        posicao = new Point(x,y);
    }
    
    /**
     * aqui vao os desenhos das linhas e pontos
     * @param g 
     */
    public void draw(Graphics g) {
        /**
         * precisamos de Graphics2D para usar os metodos deste draw()
         * usamos outras formas de desenho diferentes do post anterior
         * 
         */
        Graphics2D g2 = (Graphics2D) g;
        
        Rectangle2D.Double corpo = new Rectangle2D.Double(posicao.x + 5, posicao.y+10, 60, 12);
        Ellipse2D.Double rodaFrente = new Ellipse2D.Double(posicao.x + 15, posicao.y + 20, 10, 10);
        Ellipse2D.Double rodaTras = new Ellipse2D.Double(posicao.x + 45, posicao.y + 20, 10, 10);
        Rectangle2D.Double parachoqueFrente = new Rectangle2D.Double(posicao.x, posicao.y+17, 5, 5);
        Rectangle2D.Double parachoqueTras = new Rectangle2D.Double(posicao.x+65, posicao.y+17, 5, 5);
        /**
         * fechamos o capô
         */
        Point2D.Double capo1 = new Point2D.Double(posicao.x + 15, posicao.y+10);
        Point2D.Double capo2 = new Point2D.Double(posicao.x + 25, posicao.y);
        Point2D.Double capo3 = new Point2D.Double(posicao.x + 45, posicao.y);
        Point2D.Double capo4 = new Point2D.Double(posicao.x + 55, posicao.y+10);
        
        Line2D.Double c1 = new Line2D.Double(capo1, capo2);
        Line2D.Double c2 = new Line2D.Double(capo2, capo3);
        Line2D.Double c3 = new Line2D.Double(capo3, capo4);
        
        g2.draw(corpo);
        g2.draw(rodaFrente);
        g2.draw(rodaTras);
        g2.draw(parachoqueFrente);
        g2.draw(parachoqueTras);
        g2.draw(c1);
        g2.draw(c2);
        g2.draw(c3);        
    }
    
    /**
     * vamos mover o carro
     * @param g Graphics
     * @param incX incremento em X para mover horizontalmente
     * @param maxX somente para manter dentro da tela
     */
    public void move(Graphics g, int incX, int maxX) {
        /**
         * desenhamos em branco para apagar
         */
        g.setColor(Color.white);
        draw(g);
        /**
         * incrementar x
         */
        posicao.x = (posicao.x + incX) % maxX;
        g.setColor(Color.black);
        draw(g);
    }
}
