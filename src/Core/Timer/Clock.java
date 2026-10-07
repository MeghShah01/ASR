package Core.Timer;

public class Clock
{
    private long timeNanoSeconds;
    private double transform;
    private boolean isPaused;
    private final long STEP = 1_000_000_000/60;
    private long deltaTime;
    public Clock ()
    {
        this.timeNanoSeconds = 0;
        this.transform = 1.0f;
        this.isPaused = false;
    }

    public boolean isPaused ()
    {
        return isPaused;
    }

    public void setPaused (boolean paused)
    {
        isPaused = paused;
    }

    public double getTransform()
    {
        return transform;
    }

    public void setTransform (double value)
    {
        this.transform = value;
    }

    public long getTimeNanoSeconds()
    {
        return timeNanoSeconds;
    }

    public long getDeltaTime ()
    {
        return this.deltaTime;
    }

    public void onUpdate (long deltaTime)
    {
        this.deltaTime = deltaTime;
        if (!isPaused)
        {
            double scaledDeltaTime = deltaTime*transform;

            timeNanoSeconds += (long) scaledDeltaTime;
        }
    }

    public void incrementTimeStep ()
    {
        if (isPaused)
        {
            timeNanoSeconds += (long) (STEP * transform);
        }
        else
        {
            throw new RuntimeException("Error! Can't increment time when simulation is not paused!");
        }
    }

    public long getTimeSeconds ()
    {
        return timeNanoSeconds/1_000_000_000;
    }

    public String toString ()
    {
        return "Time (Seconds): " + (timeNanoSeconds/1_000_000_000) + "\n"
                + "isPaused: " + isPaused;
    }

}
