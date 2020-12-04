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
	
	private int length;
	private Point topLeftCorner;
	private Color color;
	private int rotation;
	
	public Square(int length, Point topLeftCorner) {
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
		
		g2d.rotate(Math.toRadians(rotation), topLeftCorner.getX() + length/2, topLeftCorner.getY() + length/2);
		
		g.drawRect((int) topLeftCorner.getX(), (int) topLeftCorner.getY(), (int) length, (int) length);
	}

	@Override
	public void moveTo(Point p) {
		topLeftCorner = p;
	}

	@Override
	public int getRotation() {
		return (int) rotation;
	}
	
	public Shape clone() {
		return new Square(length, topLeftCorner);
	}

	@Override
	public boolean contains(Point point) {
		return Math.max(Math.abs((point.getX() - (topLeftCorner.getX() + length/2)) * Math.cos(rotation)), Math.abs((point.getY() - (topLeftCorner.getY() + length/2)) * Math.cos(rotation))) <= length / 2;
	}
	
	public void setRotation(int newRotation) {
		rotation = newRotation;
	}

	@Override
	public Point getReferencePoint() {
		return topLeftCorner;
	}
}
