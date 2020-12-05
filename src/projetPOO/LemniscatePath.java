package projetPOO;


import java.awt.Point;

/**
 * this class represents a lemniscate-like path
 * @author theray1
 *
 */
public class LemniscatePath implements Path {
	/**
	 * the furthest left point of the lemniscate
	 */
	private Point center1;
	/**
	 * the furthest right point of the lemniscate
	 */
	private Point center2;
	/**
	 * the integer that keeps track of the current position of the shape on its path
	 */
	private double position;
	
	/**
	 * class constructor
	 * @param center1 the point situated the furthest on the left of the lemniscate
	 * @param center2 the point situated the furthest on the right of the lemniscate
	 */
	public LemniscatePath(Point center1, Point center2) {
		this.center1 = center1;
		this.center2 = center2;
		/**
		 * iterator which keeps track of the current position of a shape on the lemniscate path
		 */
		position = 0;
	}
	
	/**
	 * gives the next position of the shape and saves that position by incrementing the position variable
	 * @return the next point on the path, which is used as a reference to draw a shape
	 */
	@Override
	public Point nextPoint() {
		position += 0.1;
		int temp = (int) (center2.getX()-center1.getX());
		return new Point((int) (800 + temp * Math.cos(position)/(1 + Math.sin(position) * Math.sin(position))),(int) (400 + temp * Math.cos(position) * Math.sin(position)/(1 + Math.sin(position) * Math.sin(position))));
	}
}
