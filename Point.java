/**
 * The class "Point" represent a point in Cartesian system in the first quarter.
 * it has many functions such as: setting and getting the coordinates ,calculating distance , etc.
 * if there is a case of illegal point (before or after moving) it will be set to default coordinates (0,0)
 */
public class Point {

    // Instance Variables
    int _x;
    int _y;

    //Constructions

    /**
     *  Constructor for objects of class Point Constructs a new point with the specified x y coordinates
     *  Parameters:
     *  @param x - the x coordinate
     *  @param y - the y coordinate
     */
      public Point (int x , int y){
          _x = Math.max(x, 0);

          _y = Math.max(y, 0);
      }

    /**
     * Copy constructor, constructs and initializes a point using another point
     * Parameters:
     * @param other - Coordinates of the parameter
     */
    public Point(Point other){
          _x = other._x;
          _y = other._y;
      }

    //Methods
    
    /**
     * Returns the x coordinate of the point.
     * Returns:
     * @return  the x coordinate of the point
     */
    public int getX(){
          return _x;
      }

    /**
     * Returns the y coordinate of the point.
     * Returns:
     * @return  the y coordinate of the point
     */
      public int getY(){
          return _y;
      }

    /**
     * Sets the x coordinate of the point
     * Parameters:
     * @param num - a new value for the X coordinate
     */
    public void setX(int num) {
          if (num >= 0)
              _x = num;
      }

    /**
     * Sets the y coordinate of the point
     * Parameters:
     * @param num - a new value for the Y coordinate
     */
      public void setY(int num) {
        if (num >= 0)
            _y = num;

      }

    /**
     * Representation of the object in String
     * Returns:
     * @return the coordinates of a point as a string; for example : (1,2)
     */
    public String toString(){
          return "(" +_x +"," +_y +")";
      }

    /**
     * Checks if two points are equal.
     * @param other - The point to be compared with the current point.
     * @return true if the point to be compared is equal to the current point.
     */
    public boolean equals(Point other){

          return (_x == other._x) && (_y == other._y);
      }

    /**
     * Checks if the current point is above the point it is to be compared with.
     * @param other - the point to be compared with the current point.
     * @return true if the current point is above the pointit is to be compared with.
     */
    public boolean isAbove(Point other){

          return (_y > other._y);
      }

    /**
     * Checks if the current point is left of the point it is to be compared with.
     * @param other - the point to be compared with the current point
     * @return true if the current point is left of the point it is to be compared with.
     */
      public boolean isUnder(Point other){

          return other.isAbove(this);
      }

    /**
     * Checks if the current point is left of the point it is to be compared with.
     * @param other - the point to be compared with the current point
     * @return true if the current point is left of the point it is to be compared with.
     */
      public boolean isLeft(Point other){

          return (_x < other._x);
      }

    /**
     * Checks if the current point is right of the point it is to be compared with.
     * @param other - the point to be compared with the current point
     * @return true if the current point is right of the point it is to be compared with.
     */
    public boolean isRight(Point other){

          return other.isLeft(this);
      }

    /**
     * Moves the current point , at location (x,y) to a new location.
     * This new location is determined by deltaX which changes X's position along the X axis and deltaY
     * which changes Y's position along the Y axis.
     * @param deltaX -  the distance to move the current point along the X axis
     * @param deltaY - the distance to move the current point along the Y axis
     */
      public void move(int deltaX , int deltaY) {
          if ((_x + deltaX >= 0) && (_y + deltaY >= 0)) {
              _x += deltaX;
              _y += deltaY;

          }
      }

    /**
     * Calculates and return the point who is in the middle between the point and is parameter
     * @param p - The values of point parameter p
     * @return new point who is in the middle between the given point and the parameter point
     */

    public Point middle(Point p){

          int middleX = (_x + p.getX())/2;
          int middleY = (_y + p.getY())/2;

          return new Point(middleX,middleY);
      }

    /**
     * Calculates the distance between two points.
     * @param p - the second point whose distance from the current point is to be calculated
     * @return the distance between the current point and the point passed as a parameter.
     */
    public double distance(Point p){

          return Math.sqrt(Math.pow(_x - p._x,2) + Math.pow(_y - p._y ,2));
      }
}
