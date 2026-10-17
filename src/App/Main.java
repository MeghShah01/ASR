package App;

import java.nio.file.Path;
import java.nio.file.Paths;

import App.Scene.Graph;
import App.Scene.MainScene;
import Core.IO.File.WAVFileHandler;
import Core.Math.Vector2f;


public class Main
{
    public static void main (String [] args)
    {
        Application application = new Application(800, 600);

        application.layerHandler.add(new MainScene());

    }
}
