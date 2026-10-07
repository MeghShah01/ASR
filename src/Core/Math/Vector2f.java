package Core.Math;

public class Vector2f
{
    private final float x, y;

    public Vector2f (float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2f ()
    {
        x = y = 0.0f;
    }

    public static Vector2f add (Vector2f vec1, Vector2f vec2)
    {
        return new Vector2f(vec1.x + vec2.x, vec1.y + vec2.y);
    }

    public static Vector2f subtract (Vector2f vec1, Vector2f vec2)
    {
        return new Vector2f(vec1.x - vec2.x, vec1.y - vec2.y);
    }

    public Vector2f add (Vector2f vec)
    {
        return new Vector2f(this.x + vec.x, this.y + vec.y);
    }

    public Vector2f subtract (Vector2f vec)
    {
        return new Vector2f(this.x - vec.x, this.y - vec.y);
    }

    public float getMagnitude ()
    {
        return (float) Math.sqrt((this.x*this.x) + (this.y*this.y));
    }

    public static float crossProduct (Vector2f vec1, Vector2f vec2)
    {
        return (vec1.x*vec2.y)-(vec1.y*vec2.x);
    }

    public float crossProduct (Vector2f vec)
    {
        return (this.x*vec.y)-(this.y*vec.x);
    }

    public static float dotProduct (Vector2f vec1, Vector2f vec2)
    {
        return vec1.x* vec2.x + vec1.y*vec2.y;
    }

    public float dotProduct (Vector2f vec)
    {
        return this.x*vec.x + this.y*vec.y;
    }

    public float getX()
    {
        return this.x;
    }

    public float getY()
    {
        return this.y;
    }

    public String toString ()
    {
        return "<"+this.x + ", " + this.y+">";
    }
}
