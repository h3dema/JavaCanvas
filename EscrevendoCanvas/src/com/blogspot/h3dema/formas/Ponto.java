/*
 * permite desenhar um ponto na tela
 */
package com.blogspot.h3dema.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author h3dema
 */
public class Ponto implements Forma {
    
    private Point p;
    private Color cor;
    
    // construtor padrão
    public Ponto(int x, int y) {
        cor = Color.BLACK; // cor default
        p = new Point(x, y);
    }

    public int x() { return p.x; } // retorna a coordenada X do ponto
    public int y() { return p.y; } // coordenada Y
    
    public Point mover(Point vetor) {
        p.x += vetor.x;
        p.y += vetor.y;
        return p; // retorna a nova posição do ponto
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(cor);
        g.drawLine(p.x, p.y, p.x, p.y);
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
    
}
