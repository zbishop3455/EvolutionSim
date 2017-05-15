import java.awt.Graphics;

@SuppressWarnings({ "unused"})
public class Animal {
	/* Animals will be assigned random DNA that affects how they will find food
	 * Over time, the health of each animal will decline
	 * Animals gain health by eating food
	 * 	
	 */
	
	float x;
	float y;
	float speed;
	int size = 20;
	int[] xVals = new int[3];
	int[] yVals = new int[3];
	float heading =  (float) (5*Math.PI/3);
	float dx;
	float dy;
	float maxSpeed;
	float maxTurningForce;
	int seekRadius;
	
	
	public Animal(){
		//random x y position
		//x and y are the center of the animal (a triangle)
		this.x = (float) Math.floor(Math.random()*500);
		this.y = (float) Math.floor(Math.random()*500);
		this.speed = +1;
		
	}
	
	public void show(){
		//find the center node of the triangle
		xVals[1] = (int) (this.x + (this.size * Math.cos(this.heading)));
        yVals[1] = (int) (this.y - (this.size * Math.sin(this.heading)));

        xVals[0] = (int) (this.x + (this.size * Math.cos(this.heading - (2.5*Math.PI/3))));
        yVals[0] = (int) (this.y - (this.size * Math.sin(this.heading - (2.5*Math.PI/3))));

        xVals[2] = (int) (this.x +  (this.size * Math.cos(this.heading - (3.5*Math.PI/3))));
        yVals[2] = (int) (this.y -  (this.size * Math.sin(this.heading - (3.5*Math.PI/3))));	
	}
	
	private void seek(double targetX,double targetY){
		//uses steering algorithm to figure out how much to change the animals heading, than passes this data to applySteeringForce()
		//steering force = desired velocity - current velocity. 
		float direction;
		float desiredSpeed;
	}
	
	private void applySteeringForce(float steeringForceDirection, float steeringForceMagnitude){
		//add the steering force to the current acceleration
		
		
		//magnitude
		this.heading+= steeringForceDirection * steeringForceMagnitude;
		
	}
	
	private float findDistance(float x1, float y1, float x2, float y2){
		float distance = (float) Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2) * (y1-y2) );
		return distance;
	}
	
	public void move(){
		
		this.dx =  this.speed * (float)Math.cos(this.heading);
		this.dy = this.speed * (float)Math.sin(this.heading);
		

		applySteeringForce((float) -0.01,5);
		this.dy = this.dy * -1;
		
		this.x += this.dx;
		this.y +=this.dy;
		
		
	}
}
