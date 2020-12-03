package projetPOO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle implements Shape{
	private int radius;
	private Point center; //center is the reference point of the circle shape
	private Color color;
	
	public Circle(int radius, Point center) {
		this.radius = radius;
		this.center = center;
		this.color = Color.black;
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.setPosition(x, y);
	}
	
	@Override
	public void moveTo(Point p) {
		this.setPosition((int) p.getX(), (int) p.getY());
	}
	
	public void setPosition(int x, int y) {
		this.center.x = x;
		this.center.y = y;
	}
	
	public void setPosition(Point p) {
		this.center = p;
	}
	
	public Point getPosition() {
		return new Point(this.center);
	}

	public Point getCenter() {
		return this.center;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void setColor(Color newColor) {
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