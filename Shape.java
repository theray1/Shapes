package projetPOO;

import java.awt.*;

public interface Shape {
	public abstract Point getPosition();
	public abstract void moveTo(double x, double y);
	public abstract void rotate(double angle);
	public abstract Color getColor();
	public abstract void setColor(Color newColor);
}