package projetPOO;

import java.awt.Point;

public class CirclePath implements Path{
	
	private int radius;
	private Point center;
	private int travelSpeed; //unit tbd, probably in radians.sec^-1
	private int position;
	
	public CirclePath(int rad, Point center, int travelSpeed) {
		this.radius = rad;
		this.center = center;
		this.travelSpeed = travelSpeed;
		this.position = 0;
	}
		
	@Override
	public Point nextPoint() {
		position++;
		return new Point(((int) ((Math.cos(position * this.travelSpeed / 20) * this.radius + this.center.getX()))), (int) ((Math.sin(position * this.travelSpeed / 20) * this.radius + this.center.getY())));
	}

	@Override
	public void highenSpeed(int addedSpeed) {
		this.travelSpeed += addedSpeed;
	}

	@Override
	public void lowerSpeed(int substractedSpeed) {
		this.travelSpeed -= substractedSpeed;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return this.travelSpeed;
	}

	@Override
	public void setSpeed(int speed) {
		this.travelSpeed = speed;
	}

}
