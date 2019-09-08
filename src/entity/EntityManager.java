package entity;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entity> entities;

    public EntityManager() {
        entities = new ArrayList<Entity>();
    }

    public void tick(){
        for (Entity e: entities)
            e.tick();
    }

    public void render(Graphics g){
        for (Entity e: entities) {
            e.render(g);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }
}
