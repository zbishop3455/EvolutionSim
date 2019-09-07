package entity;

import java.awt.Graphics;
import java.awt.MouseInfo;

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



    float heading =  (float) (Math.PI/2);
    float dx;
    float dy;
    float maxSpeed = 1;
    float maxTurningForce;
    int seekRadius;
    float d1;
    float h1;




    public Animal(){
        //random x y position
        //x and y are the center of the animal (a triangle)
        //this.x = (float) Math.floor(Math.random()*500);
        this.x = 200;
        this.y = (float) Math.floor(Math.random()*500);
        this.speed = +1;

    }

    public void show(){
        //find the center node of the triangle

        xVals[1] = (int) (this.x + (this.size * Math.cos(this.heading)));
        yVals[1] = (int) (this.y - (this.size * Math.sin(this.heading)));

        xVals[0] = (int) (this.x + (this.size * Math.cos(this.heading + (2.5*Math.PI/3))));
        yVals[0] = (int) (this.y - (this.size * Math.sin(this.heading + (2.5*Math.PI/3))));

        xVals[2] = (int) (this.x +  (this.size * Math.cos(this.heading + (3.5*Math.PI/3))));
        yVals[2] = (int) (this.y -  (this.size * Math.sin(this.heading + (3.5*Math.PI/3))));

        xVals[1] = (int) (this.x + (this.size * Math.cos(this.heading)));
        yVals[1] = (int) (this.y - (this.size * Math.sin(this.heading)));

        xVals[0] = (int) (this.x + (this.size * Math.cos(this.heading - (2.5*Math.PI/3))));
        yVals[0] = (int) (this.y - (this.size * Math.sin(this.heading - (2.5*Math.PI/3))));

        xVals[2] = (int) (this.x +  (this.size * Math.cos(this.heading - (3.5*Math.PI/3))));
        yVals[2] = (int) (this.y -  (this.size * Math.sin(this.heading - (3.5*Math.PI/3))));
    }

    private void seek(float targetX,float targetY){
        //uses steering algorithm to figure out how much to change the animals heading, than passes this data to applySteeringForce()
        //steering force = desired velocity - current velocity.

        //add negative currentVelocity to desired
        float oppositeHeading = (float) (this.heading + Math.PI);

        //find desired components
        float desiredDirection = (float) Math.atan2(-(targetY - this.y), targetX - this.x);

        //System.out.println("Desired: " + desiredDirection);

        double steeringX = Math.cos(desiredDirection) + Math.cos(oppositeHeading);
        double steeringY = Math.sin(desiredDirection) + Math.sin(oppositeHeading);

        float steeringDirection = (float) Math.atan(steeringY / steeringX) * 1 ;
        System.out.println("Steer: "+desiredDirection);
        System.out.println("Head: "+this.heading);



        if(this.heading >= 0 && desiredDirection >= 0 || this.heading < 0 && desiredDirection < 0)
        {
            if(this.heading < desiredDirection){
                this.heading += 0.01;
            }

            if(this.heading > desiredDirection){
                this.heading -= 0.01;
            }
        }
        else if(this.heading >= 0 && desiredDirection < 0)
        {
            if(this.heading - Math.PI < desiredDirection){
                this.heading -= 0.01;
            }

            if(this.heading - Math.PI > desiredDirection){
                this.heading += 0.01;
            }
        }
        else
        {
            if(this.heading < desiredDirection - Math.PI){
                this.heading -= 0.01;
            }

            if(this.heading > desiredDirection - Math.PI){
                this.heading += 0.01;
            }
        }


    }


    private void applySteeringForce(float steeringX, float steeringY, float steeringForceMagnitude){
        //add the steering force to the current acceleration

    }

    private float findDistance(float x1, float y1, float x2, float y2){
        float distance = (float) Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2) * (y1-y2) );
        return distance;
    }

    public void move(){
        //seek(MouseInfo.getPointerInfo().getLocation().x,MouseInfo.getPointerInfo().getLocation().y);
        seek(400,200);
        this.dx =  this.speed * (float)Math.cos(this.heading);
        this.dy = this.speed * (float)Math.sin(this.heading);



        this.dy = this.dy * -1;

        this.x += this.dx;
        this.y +=this.dy;


    }
}
