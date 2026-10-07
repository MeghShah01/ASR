package App.Scene;

import Core.Math.Vector2f;
import Core.Rendering.*;
import Core.IO.*;
import Core.Timer.*;



import java.awt.*;

public class Graph implements Layer
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


    @Override
    public void update(Clock clock)
    {

    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        plotter.draw(graphics2D);
    }
}
