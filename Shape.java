package projetPOO;

import java.awt.*;

public interface Shape {
	public abstract Point getPosition();
	public abstract void moveTo(double x, double y);
	public abstract void moveTo(Point p);
	public abstract void rotate(double angle);
	public abstract Color getColor();
	public abstract void setColor(Color newColor);
	public abstract int getRotation();
	public abstract Drawable clone();
	public abstract boolean contains(Point point);
	public abstract Point getReferencePoint();
}