package projetPOO;


import java.awt.Graphics;

public interface Drawable {
	public abstract void draw(Graphics g);
	public abstract Drawable clone();
}
