package projetPOO;

import java.awt.Point;

public class LemniscatePath implements Path {
	private int radius;
	private Point center1;
	private Point center2;
	private double position;
	
	public LemniscatePath(int radius, Point center1, Point center2) {
		this.radius = radius;
		this.center1 = center1;
		this.center2 = center2;
		position = 0;
	}
	
	@Override
	public Point nextPoint() {
		position += 0.1;
		int temp = (int) (center2.getX()-center1.getX());
		return new Point((int) (800 + temp * Math.cos(position)/(1 + Math.sin(position) * Math.sin(position))),(int) (400 + temp * Math.cos(position) * Math.sin(position)/(1 + Math.sin(position) * Math.sin(position))));
	}
}
