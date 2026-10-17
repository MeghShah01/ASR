package Core.IO.User;

import Core.Event.Event;
import Core.Event.EventPublisher;
import Core.Event.EventType;
import Core.Rendering.LayerHandler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener, EventPublisher
{
    private final LayerHandler layerHandler;

    public  MouseHandler (LayerHandler layerHandler)
    {
        this.layerHandler = layerHandler;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int mouseButton = e.getButton();

        if (mouseButton == 1)
        {
            publishEvent(new Event(EventType.LEFT_MOUSE_CLICK));
        }
        else if (mouseButton == 2)
        {
            publishEvent(new Event(EventType.MIDDLE_MOUSE_CLICK));
        }
        else if (mouseButton == 3)
        {
            publishEvent(new Event(EventType.RIGHT_MOUSE_CLICK));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        publishEvent(new Event(EventType.MOUSE_DRAGGED));
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    @Override
    public void publishEvent(Event event)
    {
        this.layerHandler.enqueueEvent(event);
    }
}
