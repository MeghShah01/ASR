package Core.Rendering;


import Core.Event.Event;
import Core.Timer.Clock;
import java.awt.*;
import java.util.*;
import java.util.List;

public interface Layer
{
    void update (Clock clock);
    void draw (Graphics2D graphics2D);
    void onEvent (Event event);
    Event getEvents ();
}
