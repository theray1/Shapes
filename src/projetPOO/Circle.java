package projetPOO;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * this class represents the drawable shape, circle 
 * @
 * @author theray1
 *
 */

public class Circle implements Shape{
	private int radius;
	private Point center; 
	private Color color;
	
	/**
	 * Class constructor
	* @param radius the radius of the circle
	* @param center the center of the circle
	*/
	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
		this.color = Color.black;
	}
	
	/**
	 * set the current position of the circle to the one described by x and y coordinates
	 * @param x the absciss of the coordinates the circle is being moved to
	 * @param y the ordinate of the coordinates the circle is being moved to
	 */
	@Override
	public void moveTo(int x, int y) {
		setPosition(x, y);
	}
	
	/**
	 * set the current position of the circle to the point given as parameter
	 * @param p the point where the circle is being move to
	 */
	@Override
	public void moveTo(Point p) {
		setPosition((int) p.getX(), (int) p.getY());
	}
	
	/**
	 * change the x and y position of the center of the circle to x and y parameters, respectively
	 * @param x the new abscissa of the center of the circle
	 * @param y the new ordinate of the center of the circle
	 */
	public void setPosition(int x, int y) {
		center.x = x;
		center.y = y;
	}
	
	/**
	 * change the position of the center of the circle to p
	 * @param p the new position of the center of the circle
	 */
	public void setPosition(Point p) {
		center = p;
	}
	
	/**
	 * @return a new point with the coordinates of the actual center of the circle
	 */
	public Point getPosition() {
		return new Point(center);
	}

	/**
	 * center getter
	 * @return the center of the circle
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * color getter
	 * @return the color of the circle
	 */
	@Override
	public Color getColor() {
		return color;
	}
	
	/**
	 * color setter
	 * @param newColor the new color of the circle
	 */
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	/**
	 * draws the cercle on the drawing panel of the application
	 * @param graphics the visual context which the circle is drawn on 
	 */
	@Override
	public void draw(Graphics graphics) {
		graphics.drawOval((int) center.getX() - radius, (int) center.getY() - radius, radius * 2, radius * 2);
	}

	/**
	 * radius getter
	 * @return the radius of the circle
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * radius setter
	 * @param radius the new radius of the circle
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * rotation getter
	 * @return 0, since a circle doesn't have a rotation
	 */
	@Override
	public int getRotation() {
		return 0;
	}
	
	/**
	 * clones the circle in its current state
	 * @return the clone of the circle
	 */
	public Shape clone() {
		return new Circle(radius, center);
	}

	/**
	 * checks if a point is with the boundaries of the circle
	 * @param point the point which the test is ran on 
	 * @return <code>true</code> if the point is within the the circle; <code>false</code> otherwise
	 */
	@Override
	public boolean contains(Point point) {
		return Math.sqrt(Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2)) <= radius;
	}
	
	/**
	 * doesn't have any effect on the circle, since a any rotation applied on a circle doesn't change it
	 */
	@Override
	public void rotate(double angle) {}

	/**
	 * returns the point of reference of the circle, in that case the center of the circle
	 * @return center the center of the circle
	 */
	@Override
	public Point getReferencePoint() {
		return center;
	}
}