import java.awt.Graphics;
import java.awt.Color;

public class Food
{
	int k;
	double x;
	double y;
	double pizzasize = 15 + (25 * Math.random());
	int[] pepsize = new int[3]; 
	int[] xpizza = new int[3];
	int[] ypizza = new int[3];
	int[] xpep = new int [3];
	int[] ypep = new int [3];
	int[] xcrust = new int [4];
	int[] ycrust = new int [4];
	double pizzah =  Math.random() * (2.0 * Math.PI);
	
	public Food()
	{
		//random x y position
		//x and y are the center of the food
		this.x = Math.floor(Math.random()*500);
		this.y = Math.floor(Math.random()*500);
	}
	
	public void show(Graphics g){
		//Finds points for pizza, pepperoni, and crust
		 xpizza[1] = (int) (this.x + (this.pizzasize * Math.cos(this.pizzah)));
		 ypizza[1] = (int) (this.y - (this.pizzasize * Math.sin(this.pizzah)));
		 pepsize[1] = (int) ((this.pizzasize) / 4);
		 xpep[1] = (int) (this.x + ((this.pizzasize / 3.5)* Math.cos(this.pizzah)));
		 ypep[1] = (int) (this.y - ((this.pizzasize / 3.5) * Math.sin(this.pizzah)));

	     xpizza[0] = (int) (this.x + (this.pizzasize * Math.cos(this.pizzah + (2.2*Math.PI/3))));
	     ypizza[0] = (int) (this.y - (this.pizzasize * Math.sin(this.pizzah + (2.2*Math.PI/3))));
	     pepsize[0] = (int) ((this.pizzasize + 4) / 4);
	     xpep[0] = (int) (this.x + ((this.pizzasize / 2.0) * Math.cos(this.pizzah + (2.4*Math.PI/3))));
	     ypep[0] = (int) (this.y - ((this.pizzasize / 2.0) * Math.sin(this.pizzah + (2.4*Math.PI/3))));
	     xcrust[0] = xpizza[0];
	     xcrust[1] = (int) (this.x + ((this.pizzasize * 1.25) * Math.cos(this.pizzah + (2.2*Math.PI/3))));
	     ycrust[0] = ypizza[0];
	     ycrust[1] = (int) (this.y - ((this.pizzasize * 1.25) * Math.sin(this.pizzah + (2.2*Math.PI/3))));

	     xpizza[2] = (int) (this.x +  (this.pizzasize * Math.cos(this.pizzah + (3.8*Math.PI/3))));
	     ypizza[2] = (int) (this.y -  (this.pizzasize * Math.sin(this.pizzah + (3.8*Math.PI/3))));
	     pepsize[2] = (int) ((this.pizzasize + 2) / 4);
	     xpep[2] = (int) (this.x +  ((this.pizzasize / 3.0) * Math.cos(this.pizzah + (3.6*Math.PI/3))));
	     ypep[2] = (int) (this.y -  ((this.pizzasize / 3.0) * Math.sin(this.pizzah + (3.6*Math.PI/3))));
	     xcrust[3] = xpizza[2];
	     xcrust[2] = (int) (this.x + ((this.pizzasize * 1.15) * Math.cos(this.pizzah + (3.6*Math.PI/3))));
	     ycrust[3] = ypizza[2];
	     ycrust[2] = (int) (this.y - ((this.pizzasize * 1.15) * Math.sin(this.pizzah + (3.6*Math.PI/3))));
	     
	    //prints pizza 
		g.setColor(Color.YELLOW);
		g.fillPolygon(xpizza, ypizza,3);
		
		g.setColor(Color.ORANGE);
		g.fillPolygon(xcrust, ycrust,4);
		
		for(k = 0; k < xpep.length; k++)
		{
		g.setColor(Color.RED);
		g.fillOval(xpep[k], ypep[k], pepsize[k], pepsize[k]);
		}
	}	
}
