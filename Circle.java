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
		setPosition(x, y);
	}
	
	@Override
	public void moveTo(Point p) {
		setPosition((int) p.getX(), (int) p.getY());
	}
	
	public void setPosition(int x, int y) {
		center.x = x;
		center.y = y;
	}
	
	public void setPosition(Point p) {
		center = p;
	}
	
	public Point getPosition() {
		return new Point(center);
	}


	public Point getCenter() {
		return center;
	}


	@Override
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color newColor) {
		color = newColor;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.drawOval((int) center.getX() - radius, (int) center.getY() - radius, radius * 2, radius * 2);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int getRotation() {
		return 0;
	}
	
	public Shape clone() {
		return new Circle(radius, center);
	}

	@Override
	public boolean contains(Point point) {
		return Math.sqrt(Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2)) <= radius;
	}

	@Override
	public void rotate(double angle) {}

	@Override
	public Point getReferencePoint() {
		return center;
	}
}