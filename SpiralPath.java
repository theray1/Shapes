package projetPOO;

import java.awt.Point;

public class SpiralPath implements Path{
	private Point center;
	private int rotation;
	private int distanceToCenter;
	
	public SpiralPath() {
		this.center = new Point(0, 0);
	}
	
	public SpiralPath(Point center) {
		this.center = center;
		rotation = 0;
		distanceToCenter = 0;
	}	

	@Override
	public Point nextPoint() {
		this.rotation ++;
		this.distanceToCenter++;
		
		if(this.distanceToCenter > 400) {
			this.distanceToCenter = 0;
		}
		
		return new Point((int) (Math.cos(rotation * Math.PI / 12) * distanceToCenter + this.center.getX()), (int) (Math.sin(rotation * Math.PI / 12)*distanceToCenter + this.center.getY()));	
	}

	private void setRotation(int i) {
		this.rotation = i;
	}

	private void setDistanceToCenter(int i) {
		this.distanceToCenter = i;
	}
}
