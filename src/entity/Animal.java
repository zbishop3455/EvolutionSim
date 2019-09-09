package entity;

import java.awt.*;

@SuppressWarnings({ "unused"})
public class Animal extends Entity {

    private AnimalGenes genes;
    private float xMove;
    private float yMove;
    private float heading;
    private Point visionPointA;
    private Point visionPointB;


    public Animal(int x, int y, AnimalGenes genes){

        super(x, y, genes.getSize(), genes.getSize());
        this.genes = genes;
        this.xMove = genes.getSpeed();
        this.yMove = genes.getSpeed();
        this.visionPointA = new Point(0, 0);
        this.visionPointB = new Point(0, 0);
    }

    @Override
    public void render(Graphics g) {

        // Draw Animal
        g.setColor(genes.getColor());
        g.fillRect((int) x - genes.getSize() / 2, (int) y - genes.getSize() / 2, genes.getSize(), genes.getSize());

        // Draw movement vector
        g.setColor(Color.RED);
        g.drawLine((int) x, (int) y, (int) (x + Math.cos(heading) * (genes.getSpeed() + 20)), (int) (y + Math.sin(heading) * (genes.getSpeed() + 20)));

        // Draw Animals vision
        g.setColor(Color.GREEN);
        g.drawLine((int) x, (int) y, visionPointA.x, visionPointA.y);
        g.drawLine((int) x, (int) y, visionPointB.x, visionPointB.y);

    }

    @Override
    public void tick() {

        visionPointA.x = (int) (x + Math.cos(heading + (genes.getFieldOfView() / 2)) * genes.getSeekDistance());
        visionPointA.y = (int) (y + Math.sin(heading + (genes.getFieldOfView() / 2)) * genes.getSeekDistance());
        visionPointB.x = (int) (x + Math.cos(heading - (genes.getFieldOfView() / 2)) * genes.getSeekDistance());
        visionPointB.y = (int) (y + Math.sin(heading - (genes.getFieldOfView() / 2)) * genes.getSeekDistance());

        checkAvoidance();
        move();
    }

    // moves the x, y in direction of heading
    private void move() {
        xMove = (float) Math.cos(heading) * genes.getSpeed();
        yMove = (float) Math.sin(heading) * genes.getSpeed();
        this.x += xMove;
        this.y += yMove;
    }

    // Checks if walls are in sight
    private void checkAvoidance() {


        if (visionPointA.x <= 0 || visionPointB.x <= 0 || visionPointA.x >= 600 || visionPointB.x >= 590) {
            this.heading += 0.02f;
            genes.setColor(Color.RED);
        }

        else if (visionPointA.y <= 0 || visionPointB.y <= 0 || visionPointA.y >= 600 || visionPointB.y >= 570){
            this.heading += 0.02f;
            genes.setColor(Color.RED);
        }

        else {
            genes.setColor(Color.MAGENTA);
        }


    }

    // Returns true if a given point is in view of this Animal
    private boolean inView(int x, int y) {
        return true;

    }

}
