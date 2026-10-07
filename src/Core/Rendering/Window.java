package Core.Rendering;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    public Window (int width, int height, RenderPanel renderPanel)
    {
        this.setName("ASR");
        this.setTitle("ASR");
        this.add(renderPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.setResizable(false);
        this.pack();
        this.setBackground(Color.BLACK);
        this.setVisible(true);

    }


}
