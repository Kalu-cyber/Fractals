package Kaludev.Fractals;

public class PointF {
	public float x;
	public float y;
	public PointF() {
		x = 0;
		y = 0;
	}
	public PointF(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public PointF(PointF p) {
		x = p.x;
		y = p.y;
	}
	public PointF distance(PointF to) {
		return new PointF(to.x - x, to.y - y);
	}
	public double distanceEuclid(PointF to) {
		return Math.sqrt((to.x-x)*(to.x-x)+(to.y-y)*(to.y-y));
	}
	public void scale(float factor) {
		x *= factor;
		y *= factor;
	}
	public void add(PointF a) {
		x+= a.x;
		y+= a.y;
	}
}
