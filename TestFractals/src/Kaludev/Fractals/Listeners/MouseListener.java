package Kaludev.Fractals.Listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputAdapter;

import Kaludev.Fractals.Main;
import Kaludev.Fractals.PointF;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		boolean found = false;
		Main.moving = -1;
		for(PointF p : Main.getM().getDots()) {
			if(p.distanceEuclid(new PointF(e.getX(),e.getY()))<10) {
				Main.moving = Main.getM().getDots().indexOf(p);
				found = true;
				break;
			}
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			for(PointF p : Main.getM().getDots()) {
				if(p.distanceEuclid(new PointF(e.getX(),e.getY()))<10) {
					Main.getM().getDots().remove(Main.getM().getDots().indexOf(p));
					Main.getM().ClearDots = true;
					Main.getM().DrawDots = true;
					found = true;
				}
			}
		}
		if(!found) {
			Main.getM().getDots().add(new PointF(e.getX(),e.getY()));
			Main.getM().ClearDots = true;
			Main.getM().DrawDots = true;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(Main.moving != -1) {
			Main.getM().ClearDots = true;
			Main.getM().getDots().get(Main.moving).x = e.getX();
			Main.getM().getDots().get(Main.moving).y = e.getY();
			Main.getM().ClearDots = true;
			Main.getM().DrawDots = true;
			Main.getM().ClearDots = true;
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Main.MousePos = new PointF(e.getX(),e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

