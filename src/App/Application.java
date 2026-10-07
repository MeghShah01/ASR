package App;

import Core.Rendering.*;
import Core.IO.*;
import Core.Timer.*;

import javax.swing.*;

public class Application implements Runnable
{
    private RenderPanel renderPanel;
    private Window window;
    private Thread thread;
    LayerHandler layerHandler;
    private Clock clock;
    private int frames = 0;
    private double acc = 0.0;


    public Application (int width, int height)
    {
        this.layerHandler = new LayerHandler();
        this.renderPanel = new RenderPanel(width, height, this.layerHandler);
        this.window = new Window(width, height, renderPanel);
        this.clock = new Clock();

        startThread();

    }

    public void startThread ()
    {
        this.thread = new Thread(this);
        this.thread.start();
    }

    @Override
    public void run()
    {
        long lastTime = System.nanoTime(), currentTime, deltaTime;
        while (true)
        {
            currentTime = System.nanoTime();

            deltaTime = currentTime-lastTime;

            lastTime = currentTime;

            clock.onUpdate(deltaTime);

            layerHandler.updateLayers(this.clock);
            SwingUtilities.invokeLater(this.renderPanel::repaint);

            printFPS(clock);

            long sleepTime =  (long)(((1/60.0)*1000)-((System.nanoTime()-currentTime)/1_000_000.0));

            if (sleepTime > 0)
            {
                try
                {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void printFPS (Clock clock)
    {
        acc += clock.getDeltaTime()/1_000_000_000.0;

        frames++;

        if (acc > 1.0)
        {
            System.out.println("FPS: " + (int)(frames/acc));

            frames = 0;
            acc = 0.0;
        }
    }
}
