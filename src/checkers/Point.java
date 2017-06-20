
package checkers;

public class Point {
    /**współrzędna X.*/
    private int x;
    /**współrzędna Y.*/
    private int y;
    /**Stwarza obiekt klasy {@link Point} za pomocą parametrów X i Y.
     *@param x współrzędna x.
     *@param y współrzędna y.
     */
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Stwarza obiekt klasy {@link Point} za pomocą parametru obj 
     *@param obj link na objekt klasy {@link Point}.
     */
    public Point(Point obj){
        this.x = obj.x;
        this.y = obj.y;
    }
    /**
     * Wraca znaczenie{@link Point#x}.
     * @return współrzędna x.
     */
    public int getX(){
        return this.x;
    }
    /**
     * Nadaje {@link Point#x} znaczenie parametrowi x
     * @param x współrzędna x
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * Wraca znaczenie{@link Point#y}.
     * @return współrzędna y.
     */
    public int getY(){
        return this.y;
    }
    /**
     * Nadaje {@link Point#y} znaczenie parametrowi y
     * @param y współrzędna y
     */
    public void setY(int y){
        this.y = y;
    }
}
