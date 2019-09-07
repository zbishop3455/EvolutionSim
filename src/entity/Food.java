package entity;

public class Food
{
    int x2;
    int y2;
    double x, x1;
    double y, y1;
    double pizzasize = 15 + (25 * Math.random());
    int donutsize = (int) (15 + (25 * Math.random()));
    int donuthole;
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
        this.x = 400;
        this.y = 200;
        this.x1 = Math.floor(Math.random()*500);
        this.y1 = Math.floor(Math.random()*500);

    }

    public void show(){
        //Finds points for pizza, pepperoni, and crust. Each portion of code calculates each peice of the pizza relative to one of the three corners.
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

        this.donuthole = (int) (this.donutsize / 3.0);

        y2 = (int) y1;
        x2 = (int) x1;

    }
}