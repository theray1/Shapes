package projetPOO;


import java.awt.Graphics;
/**
 * this interface adds clone and draw methods
 * @author theray1
 *
 */
public interface Drawable {
	public abstract void draw(Graphics g);
	public abstract Drawable clone();
}
