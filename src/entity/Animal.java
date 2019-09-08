package entity;

import java.awt.*;

@SuppressWarnings({ "unused"})
public class Animal extends Entity {
    /* Animals will be assigned random DNA that affects how they will find food
     * Over time, the health of each animal will decline
     * Animals gain health by eating food
     *
     */


    public Animal(int x, int y, int width, int height){

        super(x, y, width, height);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawRect(x, y, width, height);
    }

    @Override
    public void tick() {
        x += 1;
    }

}
