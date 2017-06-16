
package checkers;

import java.awt.Color;
import java.awt.Graphics;

public class Field {
    private Point sPoint;//верхняя левая точка поля
    private Point fPoint;//нижняя правая точка поля
    private Quadrate arr[][];//массив квадратов, из которых состоит поле
    private Point pointOfMoveFigure;//точка расположения текущей фигуры, которую собираемся двигать
    private boolean movesFirst = true;//true, если ходит первый игрок, если второй игрок - false
    private boolean wasFight = false;//нужен для боя больше одной фигуры подряд
    
    public Field(Point sPoint, Point fPoint){//Конструктор копирования
        this.sPoint = new Point(sPoint);
        this.fPoint = new Point(fPoint);
        arr = new Quadrate[8][8];//8х8, так как поле состоит из 8х8 квадратов
        for(int i=0;i<8;i++)//Пройдемся по доске
            for(int j=0;j<8;j++){
                arr[i][j] = new Quadrate(sPoint.getX()+i*Quadrate.getA(), sPoint.getY()+j*Quadrate.getA());
                if((i%2==0&&j%2!=0) || (i%2!=0&&j%2==0)){//каждый второй квадрат - черный
                    arr[i][j].setColor(Color.BLACK);
                    if(i<3)//ставим красные фигуры
                        arr[i][j].setFigure(new Figure(arr[i][j].getPoint().getX() + Quadrate.getA()/8, arr[i][j].getPoint().getY() + Quadrate.getA()/8, Color.RED));
                    if(i>4)//ставим белые фигуры
                        arr[i][j].setFigure(new Figure(arr[i][j].getPoint().getX() + Quadrate.getA()/8, arr[i][j].getPoint().getY() + Quadrate.getA()/8, Color.WHITE));
                }
                else//каждый первый квадрат - белый
                    arr[i][j].setColor(Color.WHITE);
                
            }
    }
    
    public Field(int x1, int y1, int x2, int y2){
        this.sPoint = new Point(x1, y1);
        this.fPoint = new Point(x2, y2);
        arr = new Quadrate[8][8];//8х8 так как поле состоит из 8х8 квадратов
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                arr[i][j] = new Quadrate(sPoint.getX()+i*Quadrate.getA(), sPoint.getY()+j*Quadrate.getA());
                if((i%2==0&&j%2!=0) || (i%2!=0&&j%2==0)){//каждый второй квадрат черный
                    arr[i][j].setColor(Color.BLACK);
                    if(j<3)//Ставим красные фигуры
                        arr[i][j].setFigure(new Figure(arr[i][j].getPoint().getX() + Quadrate.getA()/8, arr[i][j].getPoint().getY() + Quadrate.getA()/8, Color.RED));
                    if(j>4)//Ставим белые фигуры
                        arr[i][j].setFigure(new Figure(arr[i][j].getPoint().getX() + Quadrate.getA()/8, arr[i][j].getPoint().getY() + Quadrate.getA()/8, Color.WHITE));
                }
                else//каждый первый квадрат белый
                    arr[i][j].setColor(Color.WHITE);
            }
    }
    
    public boolean willFigths(){//возвращет true, если есть фигура, которая должна бить
        for(int i=0;i<8;i++)//Проходимся по доске
            for(int j=0;j<8;j++)
                if(arr[i][j].getFigure()!=null){//Если стоит фигура
                    if(arr[i][j].getFigure().getColor().equals(Color.RED) && movesFirst){//если ходит первый игрок и фигура красная
                        if(i-1>=0 && j-1>=0 && i-2>=0 && j-2>=0)
                            if(arr[i-1][j-1].getFigure()!=null)
                                if(arr[i-1][j-1].getFigure().getColor().equals(Color.WHITE)&&arr[i-2][j-2].getFigure()==null){//Если нету фигуры  и цвет белый
                                    return true;
                                }
                        
                        if(i+1<8 && j-1>=0 && i+2<8 && j-2>=0)
                            if(arr[i+1][j-1].getFigure()!=null)
                                if(arr[i+1][j-1].getFigure().getColor().equals(Color.WHITE)&&arr[i+2][j-2].getFigure()==null){
                                    return true;
                                }
                        
                        if(i-1>=0 && j+1<8 && i-2>=0 && j+2<8)
                            if(arr[i-1][j+1].getFigure()!=null)
                                if(arr[i-1][j+1].getFigure().getColor().equals(Color.WHITE)&&arr[i-2][j+2].getFigure()==null){
                                    return true;
                                }
                        
                        if(i+1<8 && j+1<8 && i+2<8 && j+2<8)
                            if(arr[i+1][j+1].getFigure()!=null)
                                if(arr[i+1][j+1].getFigure().getColor().equals(Color.WHITE)&&arr[i+2][j+2].getFigure()==null){
                                    return true;
                                }
                    }
                    if(arr[i][j].getFigure().getColor().equals(Color.WHITE) && !movesFirst){//если ходит второй игрок и фигура белая
                        
                       
                        if(i-1>=0 && j-1>=0 && i-2>=0 && j-2>=0)
                            if(arr[i-1][j-1].getFigure()!=null)
                                if(arr[i-1][j-1].getFigure().getColor().equals(Color.RED)&&arr[i-2][j-2].getFigure()==null){
                                    return true;
                                }
                        
                        if(i+1<8 && j-1>=0 && i+2<8 && j-2>=0)
                            if(arr[i+1][j-1].getFigure()!=null)
                                if(arr[i+1][j-1].getFigure().getColor().equals(Color.RED)&&arr[i+2][j-2].getFigure()==null){
                                    return true;
                                }
                        
                        if(i-1>=0 && j+1<8 && i-2>=0 && j+2<8)
                            if(arr[i-1][j+1].getFigure()!=null)
                                if(arr[i-1][j+1].getFigure().getColor().equals(Color.RED)&&arr[i-2][j+2].getFigure()==null){
                                    return true;
                                }
                        
                        if(i+1<8 && j+1<8 && i+2<8 && j+2<8)
                            if(arr[i+1][j+1].getFigure()!=null)
                                if(arr[i+1][j+1].getFigure().getColor().equals(Color.RED)&&arr[i+2][j+2].getFigure()==null){
                                    return true;
                                }
                    }
                }
        return false;
    }
    
    public void realMovesForClickedFigure(Point obj){//рисует возможные ходы, для выбраной фигуры
        if(willFigths()){//если есть фигура, которая должна бить
            
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    if(arr[i][j].clickIn(obj)&&arr[i][j].getFigure()!=null){//если клик был в квадрате и  в квадрате есть фигура
                    
                        pointOfMoveFigure = new Point(arr[i][j].getPoint());
                    
                        if(arr[i][j].getFigure().getColor().equals(Color.RED)&&movesFirst){//для первого игрока и красной фигуры
                       
                            if(i-1>=0 && j-1>=0 && i-2>=0 && j-2>=0)
                                if(arr[i-1][j-1].getFigure()!=null)
                                    if(arr[i-1][j-1].getFigure().getColor().equals(Color.WHITE)&&arr[i-2][j-2].getFigure()==null){
                                        arr[i-2][j-2].setColor(Color.GREEN);
                                    }
                        
                            if(i+1<8 && j-1>=0 && i+2<8 && j-2>=0)
                                if(arr[i+1][j-1].getFigure()!=null)
                                    if(arr[i+1][j-1].getFigure().getColor().equals(Color.WHITE)&&arr[i+2][j-2].getFigure()==null){
                                        arr[i+2][j-2].setColor(Color.GREEN);
                                    }
                        
                            if(i-1>=0 && j+1<8 && i-2>=0 && j+2<8)
                                if(arr[i-1][j+1].getFigure()!=null)
                                    if(arr[i-1][j+1].getFigure().getColor().equals(Color.WHITE)&&arr[i-2][j+2].getFigure()==null){
                                        arr[i-2][j+2].setColor(Color.GREEN);
                                    }
                        
                            if(i+1<8 && j+1<8 && i+2<8 && j+2<8)
                                if(arr[i+1][j+1].getFigure()!=null)
                                    if(arr[i+1][j+1].getFigure().getColor().equals(Color.WHITE)&&arr[i+2][j+2].getFigure()==null){
                                        arr[i+2][j+2].setColor(Color.GREEN);
                                    }
                            wasFight = true;
                        }
                    
                        if(arr[i][j].getFigure().getColor().equals(Color.WHITE)&&!movesFirst){//для второго игрока и белой фигуры
                       
                            if(i-1>=0 && j-1>=0 && i-2>=0 && j-2>=0)
                                if(arr[i-1][j-1].getFigure()!=null)
                                    if(arr[i-1][j-1].getFigure().getColor().equals(Color.RED)&&arr[i-2][j-2].getFigure()==null){
                                        arr[i-2][j-2].setColor(Color.GREEN);

                                    }
                        
                            if(i+1<8 && j-1>=0 && i+2<8 && j-2>=0)
                                if(arr[i+1][j-1].getFigure()!=null)
                                    if(arr[i+1][j-1].getFigure().getColor().equals(Color.RED)&&arr[i+2][j-2].getFigure()==null){
                                        arr[i+2][j-2].setColor(Color.GREEN);
                                }
                        
                        if(i-1>=0 && j+1<8 && i-2>=0 && j+2<8)
                            if(arr[i-1][j+1].getFigure()!=null)
                                if(arr[i-1][j+1].getFigure().getColor().equals(Color.RED)&&arr[i-2][j+2].getFigure()==null){
                                    arr[i-2][j+2].setColor(Color.GREEN);
                                }
                        
                        if(i+1<8 && j+1<8 && i+2<8 && j+2<8)
                            if(arr[i+1][j+1].getFigure()!=null)
                                if(arr[i+1][j+1].getFigure().getColor().equals(Color.RED)&&arr[i+2][j+2].getFigure()==null){
                                    arr[i+2][j+2].setColor(Color.GREEN);
                                }
                        wasFight = true;
                    }
               }
        }
        else{//если нету возможности бить
            
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    if(arr[i][j].clickIn(obj)&&arr[i][j].getFigure()!=null){
                    
                        pointOfMoveFigure = new Point(arr[i][j].getPoint());
                    
                        if(arr[i][j].getFigure().getColor().equals(Color.RED)&&movesFirst&&arr[i][j].getFigureQ()==false){
                            
                            if(i-1>=0 && j+1<8)
                                if(arr[i-1][j+1].getFigure()==null) 
                                    arr[i-1][j+1].setColor(Color.GREEN);
                            if(i+1<8 && j+1<8)
                                if(arr[i+1][j+1].getFigure()==null) 
                                    arr[i+1][j+1].setColor(Color.GREEN);
                            
                        }
                    
                        if(arr[i][j].getFigure().getColor().equals(Color.WHITE)&&!movesFirst&&arr[i][j].getFigureQ()==false){
                            if(i-1>=0 && j-1>=0)
                                if(arr[i-1][j-1].getFigure()==null) 
                                    arr[i-1][j-1].setColor(Color.GREEN);
                            if(i+1<8 && j-1>=0)
                                if(arr[i+1][j-1].getFigure()==null) 
                                    arr[i+1][j-1].setColor(Color.GREEN);
                        }
                        
                        if(arr[i][j].getFigure().getColor().equals(Color.RED)&&movesFirst&&arr[i][j].getFigureQ()==true){
                            
                            if(i-1>=0 && j-1>=0)
                                if(arr[i-1][j-1].getFigure()==null) 
                                    arr[i-1][j-1].setColor(Color.GREEN);
                            if(i+1<8 && j-1>=0)
                                if(arr[i+1][j-1].getFigure()==null) 
                                    arr[i+1][j-1].setColor(Color.GREEN);    
                            if(i-1>=0 && j+1<8)
                                if(arr[i-1][j+1].getFigure()==null) 
                                    arr[i-1][j+1].setColor(Color.GREEN);
                            if(i+1<8 && j+1<8)
                                if(arr[i+1][j+1].getFigure()==null) 
                                    arr[i+1][j+1].setColor(Color.GREEN);
                            
                        }
                        
                        if(arr[i][j].getFigure().getColor().equals(Color.WHITE)&&!movesFirst&&arr[i][j].getFigureQ()==true){
                            if(i-1>=0 && j-1>=0)
                                if(arr[i-1][j-1].getFigure()==null) 
                                    arr[i-1][j-1].setColor(Color.GREEN);
                            if(i+1<8 && j-1>=0)
                                if(arr[i+1][j-1].getFigure()==null) 
                                    arr[i+1][j-1].setColor(Color.GREEN);
                            if(i-1>=0 && j+1<8)
                                if(arr[i-1][j+1].getFigure()==null) 
                                    arr[i-1][j+1].setColor(Color.GREEN);
                            if(i+1<8 && j+1<8)
                                if(arr[i+1][j+1].getFigure()==null) 
                                    arr[i+1][j+1].setColor(Color.GREEN);
                        }
               }
        }
    }
    
    public boolean willFight(int i, int j){//может ли текущая фигура побить еще раз
        if(arr[i][j].getFigure().getColor().equals(Color.RED) && movesFirst){
            if(i-1>=0 && j-1>=0 && i-2>=0 && j-2>=0)
                if(arr[i-1][j-1].getFigure()!=null)
                    if(arr[i-1][j-1].getFigure().getColor().equals(Color.WHITE)&&arr[i-2][j-2].getFigure()==null){
                        return true;
                    }
                        
            if(i+1<8 && j-1>=0 && i+2<8 && j-2>=0)
                if(arr[i+1][j-1].getFigure()!=null)
                    if(arr[i+1][j-1].getFigure().getColor().equals(Color.WHITE)&&arr[i+2][j-2].getFigure()==null){
                        return true;
                    }
                        
            if(i-1>=0 && j+1<8 && i-2>=0 && j+2<8)
                if(arr[i-1][j+1].getFigure()!=null)
                    if(arr[i-1][j+1].getFigure().getColor().equals(Color.WHITE)&&arr[i-2][j+2].getFigure()==null){
                        return true;
                    }
                        
            if(i+1<8 && j+1<8 && i+2<8 && j+2<8)
                if(arr[i+1][j+1].getFigure()!=null)
                    if(arr[i+1][j+1].getFigure().getColor().equals(Color.WHITE)&&arr[i+2][j+2].getFigure()==null){
                        return true;
                    }
        }
        if(arr[i][j].getFigure().getColor().equals(Color.WHITE) && !movesFirst){
                        
                       
            if(i-1>=0 && j-1>=0 && i-2>=0 && j-2>=0)
                if(arr[i-1][j-1].getFigure()!=null)
                    if(arr[i-1][j-1].getFigure().getColor().equals(Color.RED)&&arr[i-2][j-2].getFigure()==null){
                        return true;
                    }
                        
            if(i+1<8 && j-1>=0 && i+2<8 && j-2>=0)
                if(arr[i+1][j-1].getFigure()!=null)
                    if(arr[i+1][j-1].getFigure().getColor().equals(Color.RED)&&arr[i+2][j-2].getFigure()==null){
                        return true;
                    }
                        
            if(i-1>=0 && j+1<8 && i-2>=0 && j+2<8)
                if(arr[i-1][j+1].getFigure()!=null)
                    if(arr[i-1][j+1].getFigure().getColor().equals(Color.RED)&&arr[i-2][j+2].getFigure()==null){
                        return true;
                    }
                        
            if(i+1<8 && j+1<8 && i+2<8 && j+2<8)
                if(arr[i+1][j+1].getFigure()!=null)
                    if(arr[i+1][j+1].getFigure().getColor().equals(Color.RED)&&arr[i+2][j+2].getFigure()==null){
                        return true;
                    }
        }
        return false;
    }
    
    public boolean realMove(Point obj){//переносит фигуру на выбраный зеленый квадрат, если была побита какая-то фигура, то она удаляется.
        boolean result = false;
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(arr[i][j].clickIn(obj) && arr[i][j].getColor().equals(Color.green)){//Если кликнули на зеленый квадрат
                    result = true;
                    for(int i1=0;i1<8;i1++)
                        for(int j1=0;j1<8;j1++)
                            if(arr[i1][j1].getPoint().getX()==pointOfMoveFigure.getX()&&arr[i1][j1].getPoint().getY()==pointOfMoveFigure.getY()){
                                   arr[i][j].setFigure(new Figure(arr[i][j].getPoint().getX() + Quadrate.getA()/8, arr[i][j].getPoint().getY() + Quadrate.getA()/8, arr[i1][j1].getFigure().getColor()));
                                   if(arr[i1][j1].getFigureQ()==true) arr[i][j].setFigureQ();
                                   arr[i1][j1].removeFigure();
                                   
                                    if(i-2>=0 && j-2>=0)
                                        if(arr[i-2][j-2].getPoint().getX()==pointOfMoveFigure.getX()&&arr[i-2][j-2].getPoint().getY()==pointOfMoveFigure.getY())
                                            arr[i-1][j-1].removeFigure();
                                    if(i+2<8 && j-2>=0)
                                        if(arr[i+2][j-2].getPoint().getX()==pointOfMoveFigure.getX()&&arr[i+2][j-2].getPoint().getY()==pointOfMoveFigure.getY())
                                            arr[i+1][j-1].removeFigure();
                                    if(i-2>=0 && j+2<8)
                                        if(arr[i-2][j+2].getPoint().getX()==pointOfMoveFigure.getX()&&arr[i-2][j+2].getPoint().getY()==pointOfMoveFigure.getY())
                                            arr[i-1][j+1].removeFigure();
                                    if(i+2<8 && j+2<8)
                                        if(arr[i+2][j+2].getPoint().getX()==pointOfMoveFigure.getX()&&arr[i+2][j+2].getPoint().getY()==pointOfMoveFigure.getY())
                                            arr[i+1][j+1].removeFigure();
                                    
                                    if(movesFirst){
                                        if(arr[i][j].getPoint().getY()==arr[7][7].getPoint().getY())
                                            arr[i][j].setFigureQ();
                                    }
                                    else{
                                        if(arr[i][j].getPoint().getY()==sPoint.getY())
                                            arr[i][j].setFigureQ();
                                    }
                                    
                                    if(!wasFight || wasFight&&!willFight(i, j)){
                                        movesFirst = !movesFirst;
                                    }
                                    
                                    wasFight = false;
                            }
                }
        for(int i=0;i<8;i++)//убирает зеленый цвет квадратов
            for(int j=0;j<8;j++)
                if((i%2==0&&j%2!=0) || (i%2!=0&&j%2==0))
                    arr[i][j].setColor(Color.BLACK);
                else 
                    arr[i][j].setColor(Color.WHITE);
        return result;
    }
    
    public boolean isMovesFirst(){
        return movesFirst;
    }
    
    public void drawField(Graphics g){//рисует поле
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length;j++)
                arr[i][j].drawQuadrate(g);
    }
    
}
