package Kaludev.Fractals.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.KeyStroke;

import Kaludev.Fractals.Main;

public class KeyboardListener implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {

		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_SPACE:
			Main.getM().setClear(true);
			Main.getM().DrawDots = true;
			Main.getM().repaint();
			break; 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
