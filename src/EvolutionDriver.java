
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.*;


@SuppressWarnings({ "unused", "serial" })

public class EvolutionDriver extends Canvas implements Runnable{
	
	//frame
	private static JFrame masterFrame;
	private static int masterWidth = 600;
	private static int masterHeight = 600;
	//timer: 40mil == 25 fps, 12mil = 60fps
	private long timer = 40;
	private long frameCount = 0;
	private int test = 100;
<<<<<<< HEAD
	private int numberOfAnimals = 50;
	private int numberOfFood = 10;
=======
	private int numberOfAnimals = 100;
>>>>>>> a5fbdfb7addd4fb12a39f4d318b1634bad12f95b
	boolean running;
	//create food
	Food snacks[] = new Food[numberOfFood];
	//create animals
	Animal animals[] = new Animal[numberOfAnimals];
	
	
	//default constructor
	public EvolutionDriver(){
		//populate animals
		for(int i=0;i<animals.length;i++){
			animals[i] = new Animal();
		}
		//inserts food
		for(int i=0; i<snacks.length;i++)
		{
			snacks[i] = new Food();
		}
		
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		//check if we need to create one
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, masterWidth, masterHeight);
		
		for(int i=0;i<animals.length;i++){
			animals[i].show();
			g.setColor(Color.ORANGE);
			g.fillPolygon(animals[i].xVals,animals[i].yVals,3);
		
		}
		for(int i=0;i<snacks.length;i++){
			snacks[i].show(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	private void tick(){
		for(int i=0;i<animals.length;i++){
			animals[i].move();
		}
	}
	
	private void start(){
		new Thread(this, "Evolution-Thread").start();
		running = true;
	}
	
	private void stop(){
		running = false;
	}
	
	//run method (practically game loop)
	public void run(){
		double target = 60.0;
        double nsPerTick = 1000000000.0 / target;
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double unprocessed = 0.0;
        int fps = 0;
        int tps = 0;
        boolean canRender = false;
        
        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            
            if(unprocessed >= 1.0){
                tick();
                unprocessed--;
                tps++;
                canRender = true;
            }else canRender = false;
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if(canRender){
                //render
            	render();
                fps++;
            }
            
            if(System.currentTimeMillis() - 1000 > timer){
                timer += 1000;
                System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
                fps = 0;
                tps = 0;
            }
            
        }
        
        System.exit(0);
	}


	public static void main(String args[]){
		EvolutionDriver evolutionDriver = new EvolutionDriver();
		//setup the frame and canvas
		masterFrame = new JFrame("Evolution Simulator");
		masterFrame.setSize(masterWidth, masterHeight);
		masterFrame.getContentPane().add(evolutionDriver);
		masterFrame.setResizable(false);
		masterFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.err.println("Exiting Game");
				evolutionDriver.stop();
			}
		});
		masterFrame.setLocationRelativeTo(null);
		masterFrame.setVisible(true);
		masterFrame.requestFocus();
		evolutionDriver.start();
		

	}
}
        