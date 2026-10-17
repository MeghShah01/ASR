package Core.Event;

public class Event
{
    private final EventType eventType;
    private boolean isHandled;


    public Event (EventType eventType)
    {
        this.eventType = eventType;
        this.isHandled = false;
    }

    public boolean isHandled ()
    {
        return this.isHandled;
    }

    public void setHandled ()
    {
        this.isHandled = true;
    }

    public EventType getEventType()
    {
        return eventType;
    }
}
