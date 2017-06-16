
package checkers;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MFrame extends JFrame{
    private final Point mainSize = new Point(600, 600);
    private Field mainField = new Field(mainSize.getX()/2+2 - Quadrate.getA()*4, mainSize.getY()/2+12 - Quadrate.getA()*4, //поле для игры
                                        mainSize.getX()/2 + Quadrate.getA()*4, mainSize.getY()/2 - Quadrate.getA()*4);
    private boolean firstClick = true;//true, если первый клик, иначе false
    
    public MFrame(){
        setSize(mainSize.getX(), mainSize.getY());
        this.setVisible(true);
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                if(firstClick){//если первый клик, то рисуем доступные шаги, для выбраной фигуры и меняем firstClick
                        mainField.realMovesForClickedFigure(new Point((int)e.getPoint().getX(), (int)e.getPoint().getY()));
                        firstClick = !firstClick;
                }
                else{//если второй клик
                    if(!mainField.realMove(new Point((int)e.getPoint().getX(), (int)e.getPoint().getY()))){//если клик был не по зеленому квадрату
                            mainField.realMovesForClickedFigure(new Point((int)e.getPoint().getX(), (int)e.getPoint().getY()));//снова вызываем функцию для поиска доступных шагов, для выбраной фигуры
                    }
                    else{
                        firstClick = !firstClick;//если клик был по зеленому квадрату, то меняем firstClick
                    }
                }
                repaint();//перерисовуем поле
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
    }
    
    public static void main(String[] args){
        MFrame frame = new MFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, mainSize.getX(), mainSize.getY());
        mainField.drawField(g);
    }
}
