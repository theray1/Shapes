package projetPOO;


import java.awt.Point;

public class SpiralPath implements Path{

	private int growthModifier;
	private Point center;
	private int rotation;
	private int distanceToCenter;
	
	public SpiralPath(Point center, int growthModifier) {
		this.growthModifier = growthModifier;
		this.center = center;
		rotation = 0;
		distanceToCenter = 0;
	}	

	@Override
	public Point nextPoint() {
		rotation ++;
		distanceToCenter++;
		
		if(distanceToCenter > 400 / growthModifier) {
			distanceToCenter = 0;
			rotation =0;
		}
		
		return new Point((int) (Math.cos(rotation * Math.PI / 12) * distanceToCenter * growthModifier + center.getX()), (int) (Math.sin(rotation * Math.PI / 12) * distanceToCenter * growthModifier + center.getY()));	
	}
}
