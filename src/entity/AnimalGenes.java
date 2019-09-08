/*
    The animal genetics class holds a set of variable that affect how the Animal behaves.
    The goal of the Animal is to find food. Each Animals will have its own unique set of genes.
    Genes will affect the Animals size, speed, and food seeking characteristics
 */

package entity;

import java.awt.*;

public class AnimalGenes {

    private float speed;
    private float turningRate;
    private int seekRadius; // The radius that the animal can detect food
    private int health; // Health determines how long the Animal can live without food
    private int size;
    private Color color;
    private static final Color DEFAULT_COLOR = Color.CYAN;

    public AnimalGenes(float speed, float turningRate, int seekRadius, int health, int size) {
        this.speed = speed;
        this.turningRate = turningRate;
        this.seekRadius = seekRadius;
        this.health = health;
        this.size = size;
        this.color = DEFAULT_COLOR;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getTurningRate() {
        return turningRate;
    }

    public void setTurningRate(float turningRate) {
        this.turningRate = turningRate;
    }

    public int getSeekRadius() {
        return seekRadius;
    }

    public void setSeekRadius(int seekRadius) {
        this.seekRadius = seekRadius;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        this.color = c;
    }
}
