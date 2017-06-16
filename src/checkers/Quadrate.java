
package checkers;

import java.awt.*;

public class Quadrate{
    private Point sPoint;//крайняя левая точка
    private static final int A = 70;//длина соторны
    private Color c;//цвет квадрата
    private Figure f = null;//фигура в квадрате
    
    public Quadrate(Point sPoint){//Конструктор копирования
        this.sPoint = new Point(sPoint);//Споинт получает ссылку на обект Point
    }
    
    public Quadrate(int x, int y){//Конструктор копирования
        this.sPoint = new Point(x, y);
    }
    
    public void setColor(Color c){//устанавливает цвет квадрата
        this.c = c;
    }
    
    public void removeFigure(){//удаляет фигуру внутри квадрата
        f = null;
    }
    
    public void setFigure(Figure obj){//устанавливает фигуру внутри квадрата
        f = new Figure(obj);
    }
    
    public void setFigureQ(){//делает фигуру внутри квадрата "дамкой"
        f.setQueenable();
    }
    
    public boolean getFigureQ(){//возвращает "true", если фигура "дамка"
        return f.getQueenable();
    }
    
    public Figure getFigure(){//возвращает фигуру в квадрате
        return this.f;
    }
    
    public Point getPoint(){//возвращает левую верхнюю точку квадрата
        return this.sPoint;
    }
    
    public Color getColor(){//возвращает цвет квадрата
        return this.c;
    }
    
    public boolean clickIn(Point obj){//возвращает 'true', если передаваемая в метод точка лежит в квадрате
        return obj.getX()>=sPoint.getX() && obj.getY()>=sPoint.getY()&&
               obj.getX()<=sPoint.getX()+A && obj.getY()<=sPoint.getY()+A;
    }
    
    public static int getA(){//возвращает длину стороны квадрата
        return A;
    }
    
    public void drawQuadrate(Graphics g){//рисует квадрат
        g.setColor(c);
        g.fillRect(sPoint.getX(), sPoint.getY(), A, A);
        if(f!=null)//если есть фигура, то рисуем и фигуру
            f.drawFigure(g);
    }
    
}
