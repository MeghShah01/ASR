package Core.IO.User;

import Core.Event.Event;
import Core.Event.EventPublisher;
import Core.Event.EventType;
import Core.Rendering.LayerHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener, EventPublisher
{
    private boolean [] keys;
    private final LayerHandler layerHandler;

    public KeyHandler (LayerHandler layerHandler)
     {
         this.keys = new boolean[128];
         this.layerHandler = layerHandler;
     }

    @Override
    public void keyTyped(KeyEvent e)
    {
        //Nothing
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
        publishEvent(new Event(EventType.KEY_PRESSED));
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
        publishEvent(new Event(EventType.KEY_RELEASED));
    }

    public boolean isKeyPressed (int keyCode)
    {
        return this.keys[keyCode];
    }

    @Override
    public void publishEvent(Event event)
    {
        this.layerHandler.enqueueEvent(event);
    }
}
