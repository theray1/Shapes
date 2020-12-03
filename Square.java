package projetPOO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Square implements Shape{
	
	private double length;
	private Point topLeftCorner;
	private Color color;
	private double rotation;
	
	public Square(double length, Point topLeftCorner) {
		this.length = length;
		this.topLeftCorner = topLeftCorner;
		this.color = Color.black;
		this.rotation = 0;
	}
	
	@Override
	public Point getPosition() {
		return new Point((int)topLeftCorner.getX(), (int)topLeftCorner.getY());
	}

	@Override
	public void moveTo(int x, int y) {
		this.topLeftCorner = new Point((int) x, (int) y);
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
	public void rotate(double angle) {
		rotation += angle;
		
		
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.rotate(Math.toRadians(rotation), this.topLeftCorner.getX() + this.length/2, this.topLeftCorner.getY() + this.length/2);
		
		g.drawRect((int) this.topLeftCorner.getX(), (int) this.topLeftCorner.getY(), (int) this.length, (int) this.length);
	}

	@Override
	public void moveTo(Point p) {
		this.topLeftCorner = p;
	}

	@Override
	public int getRotation() {
		return (int) this.rotation;
	}
	
	public Drawable clone() {
		return new Square(this.length, this.topLeftCorner);
	}

	@Override
	public boolean contains(Point point) {
		return Math.max(Math.abs((point.getX() - (this.getReferencePoint().getX() + this.length/2)) * Math.cos(this.rotation)), Math.abs((point.getY() - (this.getReferencePoint().getY() + this.length/2)) * Math.cos(this.rotation))) <= this.length / 2;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	@Override
	public Point getReferencePoint() {
		return this.topLeftCorner;
	}
}
