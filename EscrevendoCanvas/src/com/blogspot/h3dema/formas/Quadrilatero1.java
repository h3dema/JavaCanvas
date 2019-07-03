/*
 * desenha uma figura de 4 lados
 */
package com.blogspot.h3dema.formas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author h3dema
 */
public class Quadrilatero1 implements Forma {

    private Point[] p = new Point[4];
    private Color corBorda = null;
    private Color corFundo = null;
    
    /*
     * cria um circulo na posição (x,y) com raio "raio"
     */
    public Quadrilatero1(Point p1, Point p2, Point p3, Point p4) {
        this.p[0] = p1;
        this.p[2] = p2;
        this.p[2] = p3;
        this.p[3] = p4;
    }

    public static double anguloEntre(Point p1, Point p2) {
        double ang = Math.atan2(p1.y - p2.y, p1.x - p2.x);
        if (ang < 0) ang = 2 * Math.PI - ang;
        return ang;         
    }
    
    @Override
    public void draw(Graphics g) {
        // um triangulo é desenhado como um poligono
        Polygon poli = new Polygon();
        
        HashMap<Integer, Double> angulo = new HashMap<>(3);        
        for(int i = 0; i < 3; i++) {
            angulo.put(i+1, anguloEntre(p[0], p[i+1]));
        }
        
        
        
        for(int i = 0; i <= 3; i++) {
            poli.addPoint(p[i].x, p[i].y);
        }
        if (null != getCorBorda()) {
            g.setColor(getCorBorda());
            g.drawPolygon(poli);
        }
        if (null != getCorFundo()) {
            // se tem cor de fundo, desenha o circulo (preenchido)
            g.setColor(getCorFundo());
            g.fillPolygon(poli);
        }
        
    }

    public Point getP1() {
        return p[0];
    }

    public void setP1(Point p1) {
        this.p[0] = p1;
    }

    public Point getP2() {
        return p[1];
    }

    public void setP2(Point p2) {
        this.p[1] = p2;
    }

    public Point getP3() {
        return p[2];
    }

    public void setP3(Point p3) {
        this.p[2] = p3;
    }

    public Point getP4() {
        return p[3];
    }

    public void setP4(Point p4) {
        this.p[3] = p4;
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
