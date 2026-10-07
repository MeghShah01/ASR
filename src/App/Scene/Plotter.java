package App.Scene;

import Core.Math.Vector2f;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;


public class Plotter
{
    private Vector2f [] plots;

    float pointSize = 2.0f;

    byte [] data;

    int dataSize, samplesPerSec;


    public Plotter (float pointSize)
    {
        this.pointSize = pointSize;
        plotData();
    }


    public Plotter (byte [] data, int dataSize, int samplesPerSec, float pointSize)
    {
        this.plots = new Vector2f[dataSize];
        this.pointSize = pointSize;
        this.data = data;
        this.dataSize = dataSize;
        this.samplesPerSec = samplesPerSec;
        plotData();
    }

    private void plotData ()
    {
        for (int i = 0; i < this.dataSize; i++)
        {
            this.plots[i] = new Vector2f((float)i /samplesPerSec*1000, data[i]+300);
        }
    }

    public void setSize (float pointSize)
    {
        if (pointSize > 0.0f)
        {
            this.pointSize = pointSize;
        }
        else
        {
            System.out.println("Size can't <= 0!");
        }
    }

    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setColor(new Color(220, 42, 42));

        for (Vector2f vector2f : this.plots)
        {
            graphics2D.fill(new Ellipse2D.Float(vector2f.getX() - (this.pointSize/2), vector2f.getY() - (this.pointSize/2), this.pointSize, this.pointSize));
        }
    }

}
