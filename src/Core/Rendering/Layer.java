package Core.Rendering;

import Core.Timer.Clock;

import java.awt.*;

public interface Layer
{
    void update (Clock clock);
    void draw (Graphics2D graphics2D);
}
