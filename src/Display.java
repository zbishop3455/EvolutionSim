import javax.swing.*;
import java.awt.*;

public class Display {


    private String title;
    private int width;
    private int height;
    private JFrame frame;
    private Canvas canvas;


    public Display(int width, int height, String title) {

        this.width = width;
        this.height = height;
        this.title = title;
        setup();
    }

    private void setup() {

        // Frame
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

    }


    public Canvas getCanvas() {
        return this.canvas;
    }

}
