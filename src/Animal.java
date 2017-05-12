import java.awt.Graphics;

public class Animal {
	/* Animals will be assigned random DNA that affects how they will find food
	 * Over time, the health of each animal will decline
	 * Animals gain health by eating food
	 * 	
	 */
	
	double x;
	double y;
	int speed;
	int size = 20;
	int[] xVals = new int[3];
	int[] yVals = new int[3];
	double heading =  (Math.PI / 2);
	double dx;
	double dy;
	
	
	public Animal(){
		//random x y position
		//x and y are the center of the animal (a triangle)
		this.x = Math.floor(Math.random()*500);
		this.y = Math.floor(Math.random()*500);
		this.speed = 1;
		
	}
	
	public void show(Graphics g){
		//find the center node of the triangle
		 xVals[1] = (int) (this.x + (this.size * Math.cos(this.heading)));
	     yVals[1] = (int) (this.y + (this.size * Math.sin(this.heading)));

	     xVals[0] = (int) (this.x + (this.size * Math.cos(this.heading + (2.5*Math.PI/3))));
	     yVals[0] = (int) (this.y + (this.size * Math.sin(this.heading + (2.5*Math.PI/3))));

	     xVals[2] = (int) (this.x +  (this.size * Math.cos(this.heading + (3.5*Math.PI/3))));
	     yVals[2] = (int) (this.y +  (this.size * Math.sin(this.heading + (3.5*Math.PI/3))));
	
		g.drawPolygon(xVals, yVals,3);
	}	
}
