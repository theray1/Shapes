package projetPOO;

import java.awt.Point;

public interface Path {
	public abstract Point nextPoint();
	public abstract void highenSpeed(int addedSpeed);
	public abstract void lowerSpeed(int substractedSpeed);
	public abstract int getSpeed();
	public abstract void setSpeed(int speed);
}
