package Core.Rendering;

import Core.Event.Event;
import Core.Event.EventType;
import Core.Timer.Clock;

import java.awt.*;
import java.util.*;
import java.util.List;

public class LayerHandler
{
    private final List<List<Layer>> layers;
    private Queue <Event> eventQueue;

    public LayerHandler()
    {
        this.layers = new ArrayList<>();
        this.eventQueue = new ArrayDeque<>();
    }

    public void addLayerToLevel(Layer layerScene, int level)
    {
        validateLayerLevel(level);
        this.layers.get(level).add(layerScene);
    }

    public void add (Layer layerScene)
    {
        List<Layer> layer = new ArrayList<>();

        layer.add(layerScene);

        this.layers.add(layer);
    }

    public Layer getLayer (int level, int position)
    {
        validateLayerLevelAndPosition(level, position);

        return this.layers.get(level).get(position);
    }

    public void replaceLayer (Layer layerScene, int level, int position)
    {
        validateLayerLevelAndPosition(level, position);
        List<Layer> list = this.layers.get(level);
        list.set(position, layerScene);

    }

    private void validateLayerLevel (int level)
    {
        if (level >= layers.size() || level < 0)
        {
            throw new IllegalArgumentException(level + " is either a negative number" +
                    " or is larger then existing number of layers in the current stack!\n");
        }
    }

    private void validateLayerLevelAndPosition (int level, int position)
    {
        validateLayerLevel(level);

        if (position >= this.layers.get(level).size() || position < 0)
        {
            throw new IllegalArgumentException(position + " is either a negative number" +
                    " or is larger then existing number of scenes in current layer!\n");
        }
    }


    public void transitionLayers (int level, int position)
    {
        validateLayerLevelAndPosition(level, position);
        List<Layer> list = this.layers.get(level);
        int firstLayer = 0;
        Collections.swap(list, firstLayer, position);

    }

    public void drawLayers (Graphics2D graphics2D)
    {
        for (List<Layer> layer : this.layers)
        {
            layer.getFirst().draw(graphics2D);
        }
    }

    public void updateLayers (Clock clock)
    {
        for (List<Layer> layer : this.layers)
        {
            layer.getFirst().update(clock);
        }
    }

    public void collectEvents ()
    {
        for (List<Layer> layers : this.layers)
        {
            Event event = layers.getFirst().getEvents();

            if (event != null)
            {
                this.eventQueue.add(event);
            }
        }
    }

    public void enqueueEvent (Event event)
    {
        this.eventQueue.add(event);
    }


    public void notifyEventListeners ()
    {
        Queue<Event> tempQueue = this.eventQueue;

        this.eventQueue = new ArrayDeque<>();

        while (!tempQueue.isEmpty())
        {
            Event event = tempQueue.poll();

            for (int i = this.layers.size()-1; i >= 0; i --)
            {
                this.layers.get(i).getFirst().onEvent(event);

                if (event.isHandled())
                {
                    break;
                }
            }
        }
    }

}
