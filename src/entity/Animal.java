package entity;

import java.awt.*;

@SuppressWarnings({ "unused"})
public class Animal extends Entity {

    private AnimalGenes genes;
    private float xMove;
    private float yMove;
    private float heading;


    public Animal(int x, int y, AnimalGenes genes){

        super(x, y, genes.getSize(), genes.getSize());
        this.genes = genes;
        this.xMove = genes.getSpeed();
        this.yMove = genes.getSpeed();
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
        g.drawLine((int) x, (int) y, (int) (x + Math.cos(heading + 0.5) * genes.getSeekDistance()), (int) (y + Math.sin(heading + 0.5) * genes.getSeekDistance()));
        g.drawLine((int) x, (int) y, (int) (x + Math.cos(heading - 0.5) * genes.getSeekDistance()), (int) (y + Math.sin(heading - 0.5) * genes.getSeekDistance()));

    }

    @Override
    public void tick() {
        checkCollision();
        move();
    }

    // moves the x, y in direction of heading
    private void move() {
        xMove = (float) Math.cos(heading) * genes.getSpeed();
        yMove = (float) Math.sin(heading) * genes.getSpeed();
        this.x += xMove;
        this.y += yMove;

    }

    private void checkCollision() {

    }

}
