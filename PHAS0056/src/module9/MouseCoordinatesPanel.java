package module9;

import java.awt.event.*;
import javax.swing.*;

/** Panel illustrating mouse input. */
public class MouseCoordinatesPanel extends JPanel
									implements MouseListener {
	/** Just need to register this object as MouseListener. */
	public MouseCoordinatesPanel() {addMouseListener(this);}
	/** Print number of mouse button in location of click. */
	public void mouseClicked(MouseEvent e) {
		int iButton = e.getButton();
		int x = e.getX(); int y = e.getY();
		String s = String.format("%d",iButton);
		this.getGraphics().drawString(s, x, y);
	}
	/**
	 * We have to implement all the methods of the
	 * MouseListener interface, even if they don't
	 * do anything. An alternative would be to extend
	 * the abstract MouseAdapter class, which provides
	 * dummy implementations, but we cannot do this
	 * as well as extending JPanel, so we would need
	 * to create an additional class.
	 */
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}