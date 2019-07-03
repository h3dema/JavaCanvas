/*
 * desenha um circulo no canvas
 */
package com.blogspot.h3dema.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author h3dema
 */
public class Circulo implements Forma {
    
    private Point p;
    private int raio;
    private Color corBorda = null;
    private Color corFundo = null;
    
    /*
     * cria um circulo na posição (x,y) com raio "raio"
     */
    public Circulo(int x, int y, int raio) {
        p = new Point(x, y);
        this.raio = raio;
    }
    
    public int x() { return p.x; } // retorna a coordenada X do centro do circulo
    public int y() { return p.y; } // coordenada Y do centro do circulo
    public int raio() { return raio; } // raio do circulo
    public Point mover(Point vetor) {
        p.x += vetor.x;
        p.y += vetor.y;
        return p; // retorna a nova posição do centro do circulo
    }
    
    public void dimensionar(int deltaRaio) {
        raio += deltaRaio;
        if (raio < 0) raio = 0; // não aceitamos raios negativos
    }
    
    @Override
    public void draw(Graphics g) {
        // se a cor de borda for definida, desenha a circunferência (somente a borda)
        if (null != getCorBorda()) {
            g.setColor(getCorBorda());
            g.drawOval(p.x, p.y, raio, raio);
        }
        if (null != getCorFundo()) {
            // se tem cor de fundo, desenha o circulo (preenchido)
            g.setColor(getCorFundo());
            g.fillOval(p.x, p.y, raio, raio);
        }
        
    }

    public Color getCorBorda() {
        return corBorda;
    }

    public void setCorBorda(Color corBorda) {
        this.corBorda = corBorda;
    }

    public Color getCorFundo() {
        return corFundo;
    }

    public void setCorFundo(Color corFundo) {
        this.corFundo = corFundo;
    }

}
