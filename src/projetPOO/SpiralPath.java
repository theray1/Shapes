package projetPOO;


import java.awt.Point;
/**
 * this class represents a spiraling path
 * @author theray1
 *
 */
public class SpiralPath implements Path{
	/*
	 * this integer regulates how much distance there is between the last point of a revolution and the center of the spiral
	 */
	private int growthModifier;
	/**
	 * the center of the spiral
	 */
	private Point center;
	/**
	 * the current rotation of the path
	 */
	private int rotation;
	/**
	 * the current distance between the center of the point and the current position of a shape, arbitrary unit
	 */
	private int distanceToCenter;
	
	/**
	 * class constructor
	 * @param center the center of the spiral
	 * @param growthModifier the value regulating how much distance there is between the last point of a revolution and the center of the spiral
	 */
	public SpiralPath(Point center, int growthModifier) {
		this.growthModifier = growthModifier;
		this.center = center;
		rotation = 0;
		distanceToCenter = 0;
	}	

	/**
	 * returns the next position of the shape and saves that position by incrementing the rotation and distanceToCenter variable
	 * @return the next point on the path, which is used as a reference to draw a shape
	 */
	@Override
	public Point nextPoint() {
		rotation ++;
		distanceToCenter++;
		
		if(distanceToCenter > 100) {
			distanceToCenter = 0;
			rotation = 0;
		}
		
		return new Point((int) (Math.cos(rotation * Math.PI / 12) * distanceToCenter * growthModifier + center.getX()), (int) (Math.sin(rotation * Math.PI / 12) * distanceToCenter * growthModifier + center.getY()));	
	}
}
