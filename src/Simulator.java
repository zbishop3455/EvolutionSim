import java.awt.*;
import java.awt.image.BufferStrategy;

public class Simulator implements Runnable{

    private Display display;
    private boolean running;
    private final static int width = 600;
    private final static int height = 600;
    private Graphics g;
    private BufferStrategy bs;
    private Thread thread;

    public Simulator() {
        display = new Display(width,height , "Evolution Simulator");
    }

    private void init() {

    }

    private void tick(){

    }

    private void start(){
        if (running) return;

        running = true;

        thread = new Thread(this);
        thread.start();
    }

    private void stop(){

        if (!running) return;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    private void render(){

        // Get Buffer Strategy
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        // Clear screen
        g = bs.getDrawGraphics();
        g.clearRect(0,0, width, height);

        // Draw black rect
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,width,height);

        bs.show();
        g.dispose();
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.start();
    }

}
