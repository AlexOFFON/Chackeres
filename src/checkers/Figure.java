
package checkers;

import java.awt.*;

public class Figure {
    private Point coord;//верхние левые координаты фигуры
    private final int D = Quadrate.getA() - 2*Quadrate.getA()/8;//диаметр фигуры = 3/4 стороны квадрата 
    private Color c = Color.BLACK; //цвет фигуры (изначально черный, так как фигуры всегда в черных квадратах
    private boolean isQueen = false; //true, если фигура - "дамка", иначе - false
    
    public Figure(Point coord, Color c){
        this.coord = new Point(coord);
        this.c = c;
    }
    
    public Figure(int x, int y, Color c){
        this.coord = new Point(x, y);
        this.c = c;
    }
    
    private void drawForQueen(Graphics g){//рисует "корону" на фигуре
        g.setColor(Color.BLACK);
        g.drawLine(coord.getX()+Quadrate.getA()/4, coord.getY()+Quadrate.getA()/4, coord.getX()+Quadrate.getA()/4, coord.getY()+Quadrate.getA()/4+10);
        g.drawLine(coord.getX()+Quadrate.getA()/4, coord.getY()+Quadrate.getA()/4+10, coord.getX()+Quadrate.getA()/4+20, coord.getY()+Quadrate.getA()/4+10);
        g.drawLine(coord.getX()+Quadrate.getA()/4+20, coord.getY()+Quadrate.getA()/4, coord.getX()+Quadrate.getA()/4+20, coord.getY()+Quadrate.getA()/4+10);
        g.drawLine(coord.getX()+Quadrate.getA()/4, coord.getY()+Quadrate.getA()/4, coord.getX()+Quadrate.getA()/4+5, coord.getY()+Quadrate.getA()/4+6);
        g.drawLine(coord.getX()+Quadrate.getA()/4+5, coord.getY()+Quadrate.getA()/4+6, coord.getX()+Quadrate.getA()/4+10, coord.getY()+Quadrate.getA()/4);
        g.drawLine(coord.getX()+Quadrate.getA()/4+10, coord.getY()+Quadrate.getA()/4, coord.getX()+Quadrate.getA()/4+15, coord.getY()+Quadrate.getA()/4+6);
        g.drawLine(coord.getX()+Quadrate.getA()/4+15, coord.getY()+Quadrate.getA()/4+6, coord.getX()+Quadrate.getA()/4+20, coord.getY()+Quadrate.getA()/4);
    }
    
    public void setQueenable(){//делает фигуру "дамкой"
        isQueen = true;
    }
    
    public boolean getQueenable(){//возвращает true, если фигура - "дамка", иначе - false
        return isQueen;
    }
    
    public Figure(Figure obj){
        this.coord = new Point(obj.coord);
        this.c = obj.c;
    }
    
    public void setColor (Color c){//устанавливает цвет фигуры
        this.c = c;
    }
    
    public Color getColor(){//возвращает цвет фигуры
        return this.c;
    }
    
    public void drawFigure(Graphics g){
        g.setColor(c);
        g.fillOval(coord.getX(), coord.getY(), D, D);
        if(isQueen){//если фигура "дамка", то рисуем корону
            drawForQueen(g);
        }
    }
}
