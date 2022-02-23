package Kaludev.Fractals;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;


import Kaludev.Fractals.Listeners.*;

@SuppressWarnings("serial")
public class Main extends JFrame{
	private List<PointF> dots = new ArrayList<PointF>();
	private List<PointF> dotsB = new ArrayList<PointF>();
	private PointF tracer;
	private static Main m;
	public List<PointF> getDots() {
		return dots;
	}

	public void setDots(List<PointF> dots) {
		this.dots = dots;
	}

	
	private Random r = new Random();
	private boolean clear = true;
	private  int precision = 1;
	public boolean DrawDots = true;
	public boolean ClearDots = false;
	public static int moving = -1; 
	public static PointF MousePos = new PointF();
	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}
	public Main() {

		super("Fractals");
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		setBackground(Color.BLACK);
		

		addMouseListener(new MouseListener());
		addKeyListener(new KeyboardListener());
		addMouseMotionListener(new MouseListener());

		dots.add(new PointF(1920/2,100));
		dots.add(new PointF(1920/4,980));
		dots.add(new PointF(1920/4*3,980));
		
		dotsB = dots;
		
		tracer = new PointF(r.nextInt(1920),r.nextInt(1080));

		revalidate();
	}

	@Override
	public void paint(Graphics g) {
		if(clear) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			clear = false;
			tracer = new PointF(r.nextInt(1920),r.nextInt(1080));
		}
		if(ClearDots) {
			g.setColor(Color.BLACK);
			for(PointF dot: dotsB) {
				g.clearRect((int)dot.x-3,(int)dot.y-3, 6, 6);
			}
			ClearDots = false;
			dotsB = dots;
		}
		if(DrawDots ) {
			
			for(PointF dot: dots) {
				g.setColor(Color.BLACK);
				g.clearRect((int)dot.x-3,(int)dot.y-3, 6, 6);
				g.setColor(Color.WHITE);
				g.fillOval((int)dot.x-3,(int)dot.y-3, 6, 6);
			}
			DrawDots = false;
		}
		if(moving != -1) {
			g.setColor(Color.yellow);
			g.drawLine((int)MousePos.x,(int)MousePos.y,(int)MousePos.x,(int)MousePos.y);
		}
		int choice = r.nextInt(dots.size());
		PointF dist = tracer.distance(dots.get(choice));
		dist.scale(0.5f);
		tracer.add(dist);
		g.setColor(Color.BLUE);
		g.drawLine((int)tracer.x,(int)tracer.y, (int)tracer.x, (int)tracer.y);
		repaint();
	}
	public static void main(String[] args) {
		m = new Main(); 


	}

	public static Main getM() {
		return m;
	}


	public static void setM(Main m) {
		Main.m = m;
	}

}
