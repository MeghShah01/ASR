package App;

import java.nio.file.Path;
import java.nio.file.Paths;

import App.Scene.Graph;
import Core.IO.*;
import Core.Math.Vector2f;


public class Main
{
    public static void main (String [] args)
    {
        Path path = Paths.get("C:\\Users\\Manish\\Documents\\JavaProjects\\ASR\\test.wav");

        WAVFileHandler wavFileHandler = new WAVFileHandler(path);

        Application application = new Application(800, 600);

        Graph graph = new Graph(new Vector2f(0.0f, 0.0f), new Vector2f(8000.f, 600.0f));

        graph.plotData(wavFileHandler);

        application.layerHandler.add(graph);


    }
}
