package entity;

import java.awt.*;

@SuppressWarnings({ "unused"})
public class Animal extends Entity {

    private AnimalGenes genes;


    public Animal(int x, int y, AnimalGenes genes){

        super(x, y, genes.getSize(), genes.getSize());
        this.genes = genes;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(genes.getColor());
        g.drawRect(x, y, width, height);
    }

    @Override
    public void tick() {
        x += 1;
    }

}
