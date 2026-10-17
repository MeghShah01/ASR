package Core.Math;

public final class MathUtils
{
    public static float lerp (float startValue, float endValue, long dt)
    {
        return startValue + (endValue - startValue)*dt;
    }

    public static float cubic ()
    {
        return 0.0f;
    }

    public static float clamp (float x, float min, float max)
    {
        if (x >= max)
        {
            return max;
        }
        else if (x <= min)
        {
            return min;
        }
        return x;
    }
}
