
package checkers;

public class Point {
    private int x;//координата по Х
    private int y;//координата по У
    
    public Point(int x, int y){//конструктор 
        this.x = x;
        this.y = y;
    }
    
    public Point(Point obj){//Конструкор копирования
        this.x = obj.x;
        this.y = obj.y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setY(int y){
        this.y = y;
    }
}
