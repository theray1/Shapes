package projetPOO;


import java.awt.Point;

public class CirclePath implements Path{
	private int radius;
	private Point center;
	private int position;
	
	public CirclePath(int rad, Point center) {
		this.radius = rad;
		this.center = center;
		this.position = 0;
	}
		
	@Override
	public Point nextPoint() {
		position++;
		return new Point(((int) ((Math.cos(position  * Math.PI / 12.0) * radius + center.getX()))), (int) ((Math.sin(position  * Math.PI / 12.0) * radius + center.getY())));
	}
}
