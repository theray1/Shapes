package projetPOO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle implements Shape, Drawable{
	private int radius;
	private Point center;
	private Color color;
	
	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
		this.color = Color.black;
	}
	
	public void setPosition(int x, int y) {
		this.center.x = x;
		this.center.y = y;
	}
	
	public Point getPosition() {
		return new Point();
	}

	public Point getCenter() {
		return this.center;
	}
	
	@Override
	public void moveTo(double x, double y) {
		// TODO Auto-generated method stub
		this.setPosition((int) x, (int) y);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public void setColor(Color newColor) {
		// TODO Auto-generated method stub
		this.color = newColor;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawOval((int) this.center.getX() - this.radius, (int) this.center.getY() - this.radius, this.radius * 2, this.radius * 2);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void moveTo(Point p) {
		// TODO Auto-generated method stub
		this.setPosition((int) p.getX(), (int) p.getY());
	}

	@Override
	public int getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Drawable clone() {
		return new Circle(this.radius, this.center);
	}

	@Override
	public boolean contains(Point point) {
		return Math.sqrt(Math.pow(point.getX() - this.center.getX(), 2) + Math.pow(point.getY() - this.center.getY(), 2)) <= this.radius;
	}

	@Override
	public void rotate(double angle) {}

	@Override
	public Point getReferencePoint() {
		return this.center;
	}
}