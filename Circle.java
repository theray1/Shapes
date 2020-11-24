package projetPOO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle implements Shape, Drawable{
	private int radius;
	private Point center;
	
	public Circle(int rad, Point cen) {
		this.setRadius(rad);
		this.center = cen;
	}
	
	public void setPosition(int newX, int newY) {
		this.center.x = newX;
		this.center.y = newY;
	}
	
	
	public Point getPosition() {
		return new Point();
	}

	@Override
	public void moveTo(double x, double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(double angle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color newColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics graphics) {
		// TODO Auto-generated method stub
		//Graphics2D g2d = (Graphics2D)graphics;
        //g2d.rotate(Math.toRadians(this._rotation),this._topLeftCorner.x + this._size/2, this._topLeftCorner.y + this._size/2);
        //graphics.drawCircle(this._topLeftCorner.x, this._topLeftCorner.y, _size, _size);
		graphics.drawOval(this.center.x, this.center.y, this.radius, this.radius);
		
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
}