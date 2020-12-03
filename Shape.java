package projetPOO;

import java.awt.*;

public interface Shape {
	public abstract Point getPosition();
	public abstract void moveTo(int x, int y);
	public abstract void moveTo(Point p);
	public abstract void rotate(double angle);
	public abstract Color getColor();
	public abstract void setColor(Color newColor);
	public abstract int getRotation();
	public abstract boolean contains(Point point);
	public abstract Point getReferencePoint();
}