package App.Scene;

import App.Main;
import Core.Event.Event;
import Core.IO.File.WAVFileHandler;
import Core.Math.Vector2f;
import Core.Rendering.Layer;
import Core.Timer.Clock;

import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MainScene implements Layer
{

    private final Graph graph;
    private final WAVFileHandler wavFileHandler;
    public MainScene ()
    {
        this.graph = new Graph(new Vector2f(0.0f,0.0f),
                new Vector2f(800.0f, 600.0f));

        Path path = Paths.get("C:\\Users\\Manish\\Documents\\JavaProjects\\ASR\\test.wav");

        this.wavFileHandler = new WAVFileHandler(path);

        this.graph.plotData(wavFileHandler);
    }


    @Override
    public void update(Clock clock)
    {
        graph.update(clock);
    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graph.draw(graphics2D);
    }

    @Override
    public void onEvent(Event event)
    {
        graph.onEvent(event);
    }

    @Override
    public Event getEvents()
    {
        return null;
    }

}
