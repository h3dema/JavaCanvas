/*
 * desenha um triangulo no canvas
 */
package com.blogspot.h3dema.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author h3dema
 */
public class Triangulo implements Forma {

    private Point p1, p2, p3;
    private Color corBorda = null;
    private Color corFundo = null;
    
    /*
     * cria um circulo na posição (x,y) com raio "raio"
     */
    public Triangulo(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void draw(Graphics g) {
        // um triangulo é desenhado como um poligono
        Polygon p = new Polygon();
        p.addPoint(p1.x, p1.y);
        p.addPoint(p2.x, p2.y);
        p.addPoint(p3.x, p3.y);
        if (null != getCorBorda()) {
            g.setColor(getCorBorda());
            g.drawPolygon(p);
        }
        if (null != getCorFundo()) {
            // se tem cor de fundo, desenha o circulo (preenchido)
            g.setColor(getCorFundo());
            g.fillPolygon(p);
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

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }
    
    
}
