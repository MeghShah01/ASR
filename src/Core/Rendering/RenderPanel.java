package Core.Rendering;

import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel
{
    private LayerHandler layerHandler;

    public RenderPanel (int width, int height, LayerHandler layerHandler)
    {
        this.layerHandler = layerHandler;
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setVisible(true);
    }

    @Override
    public void paintComponent (Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        layerHandler.drawLayers(graphics2D);
        //graphics2D.setColor(Color.RED);

        //graphics2D.fillRect(200, 200, 200, 100);

        graphics2D.dispose();

    }


}
