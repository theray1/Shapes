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
/**
 * this class represents the drawable shape circle
 * @author theray1
 *
 */
public class Square implements Shape{
	/**
	 * the length of a side of the square
	 */
	private int length;
	/**
	 * the position of the top left corner of the square
	 */
	private Point topLeftCorner;
	/**
	 * the current color of the square
	 */
	private Color color;
	/**
	 * the current rotation of the square
	 */
	private int rotation;
	
	/**
	 * class constructor
	 * @param length the length of a side of the square
	 * @param topLeftCorner	the position of the top left corner of the non square, when not rotated
	 */
	public Square(int length, Point topLeftCorner) {
		this.length = length;
		this.topLeftCorner = topLeftCorner;
		this.color = Color.black;
		this.rotation = 0;
	}
	
	/**
	 * position getter
	 * @return a point with the value of the current topLeftCorner
	 */
	@Override
	public Point getPosition() {
		return new Point(topLeftCorner);
	}
	
	/**
	 * change the x and y position of the center of the circle to x and y parameters, respectively
	 * @param x the new abscissa of the top left corner of the square
	 * @param y the new ordinate of the top left corner of the square
	 */
	public void setPosition(int x, int y) {
		topLeftCorner.x = x;
		topLeftCorner.y = y;
	}
	
	/**
	 * change the position of the top left corner of the square to p
	 * @param p the new position of the top left corner of the square
	 */
	public void setPosition(Point p) {
		topLeftCorner = p;
	}
	
	/**
	 * set the current position of the square to the one described by x and y coordinates
	 * @param x the absciss of the coordinates the square is being moved to
	 * @param y the ordinate of the coordinates the square is being moved to
	 */
	@Override
	public void moveTo(int x, int y) {
		setPosition(x, y);
	}

	/**
	 * color getter
	 * @return the current color of the square
	 */
	@Override
	public Color getColor() {
		return color;
	}

	/**
	 * color setter
	 * @param newColor the new color of the square
	 */
	@Override
	public void setColor(Color newColor) {
		color = newColor;
	}

	/**
	 * rotates the square by an angle in radiants
	 * @param angle 
	 */
	@Override
	public void rotate(double angle) {
		rotation += angle;
	}
	
	/**
	 * rotate and draws the square  
	 * @param graphics the visual context which the circle is drawn on 
	 */
	@Override
	public void draw(Graphics graphics) {
		Graphics2D g2d = (Graphics2D) graphics;
		
		g2d.rotate(Math.toRadians(rotation * Math.PI/12.0), topLeftCorner.x + length/2, topLeftCorner.y + length/2);
		
		graphics.drawRect((int) topLeftCorner.x, (int) topLeftCorner.y, (int) length, (int) length);
	}

	/**
	 * set the current position of the circle to the point given as parameter
	 * @param p the point where the circle is being move to
	 */
	@Override
	public void moveTo(Point p) {
		topLeftCorner = p;
	}

	/**
	 * rotation getter
	 * @return the current rotation of the square
	 */
	@Override
	public int getRotation() {
		return rotation;
	}
	
	/**
	 * clones the square in its current state
	 * @return the clone of the square
	 */
	public Shape clone() {
		return new Square(length, topLeftCorner);
	}

	/**
	 * checks if a point is with the boundaries of the square
	 * @param point the point which the test is ran on 
	 * @return <code>true</code> if the point is within the the square; <code>false</code> otherwise
	 */
	@Override
	public boolean contains(Point point) {
		return Math.max(Math.abs(point.x - (topLeftCorner.x + length/2)), Math.abs(point.y - (topLeftCorner.y + length/2))) < length / 2;
	}

	/**
	 * returns the point of reference of the square, in that case the topLeftCorner of the square
	 * @return center the topLeftCorner of the square
	 */
	@Override
	public Point getReferencePoint() {
		return topLeftCorner;
	}
}
