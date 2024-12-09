package fractal;

import koch.Koch;
import mountain.Point;
import mountain.Triangle;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[3];
		fractals[0] = new Triangle(new Point(50,500), new Point(120, 80), new Point(560,300), 18.0);
		fractals[1] = new Koch(300);
		fractals[2] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
