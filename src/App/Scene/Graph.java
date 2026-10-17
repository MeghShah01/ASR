package App.Scene;

import Core.Event.Event;
import Core.Event.EventListener;
import Core.Event.EventType;
import Core.IO.File.FileHandler;
import Core.Math.Vector2f;
import Core.Timer.*;



import java.awt.*;

public class Graph implements EventListener
{
    private Plotter plotter;

    private Vector2f xAxisPosition, yAxisPosition;

    private float axisWeight, minorGridLineWeight, majorGridLineWeight;

    private int numberOfMinorGridLine;

    public Graph (Vector2f position, Vector2f size)
    {
       this.plotter = new Plotter(2.0f);
    }

    public void plotData (FileHandler fileHandler)
    {
        byte [] data = fileHandler.getData();
        int dataSize = fileHandler.getHeader().getDataSize();
        int samplesPerSec = fileHandler.getHeader().getSampleRate();

        this.plotter = new Plotter(data, dataSize, samplesPerSec, 2.0f);
    }

    public void update(Clock clock)
    {

    }

    public void draw(Graphics2D graphics2D)
    {
        plotter.draw(graphics2D);
    }

    @Override
    public void onEvent(Event event)
    {
        if (event.getEventType() == EventType.KEY_PRESSED)
        {
            System.out.println("Key Pressed!");
            event.setHandled();
        }
        else if (event.getEventType() == EventType.LEFT_MOUSE_CLICK)
        {
            System.out.println("Left Mouse Clicked!");
            event.setHandled();
        }
    }
}
