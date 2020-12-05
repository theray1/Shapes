package projetPOO;


import java.awt.Point;
/**
 * this class represents a circular path
 * @author theray1
 *
 */
public class CirclePath implements Path{
	private int radius;
	private Point center;
	/**
	 * iterator which keeps track of the current position of a shape on the circle path
	 */
	private int position;
	
	/**
	 * class constructor
	 * @param radius the radius of the circle path
	 * @param center returns the point around which a shape is going to move
	 */
	public CirclePath(int radius, Point center) {
		this.radius = radius;
		this.center = center;
		this.position = 0;
	}
		
	/**
	 * gives the next position of the shape and saves that position by incrementing the position variable
	 * @return the next point on the path, which is used as a reference to draw a shape
	 */
	@Override
	public Point nextPoint() {
		position++;
		return new Point(((int) ((Math.cos(position  * Math.PI / 12.0) * radius + center.getX()))), (int) ((Math.sin(position  * Math.PI / 12.0) * radius + center.getY())));
	}
}
