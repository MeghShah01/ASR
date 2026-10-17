package Core.Math;

public class Vector2f implements Value2f
{
    private final float x, y;

    public Vector2f(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public Vector2f()
    {
        x = y = 0.0f;
    }

    public Vector2f (Value2f value2f)
    {
        this.x = value2f.getX();
        this.y = value2f.getY();
    }

    public static Value2f add(Value2f val1, Value2f val2)
    {
        return new Vector2f(val1.getX() + val2.getX(), val1.getY() + val2.getY());
    }
    public static Value2f subtract(Value2f val1, Value2f val2)
    {
        return new Vector2f(val1.getX() - val2.getX(), val1.getY() - val2.getY());
    }

    public static Value2f scalarMultiply (Value2f val1, float alpha)
    {
        return new Vector2f(val1.getX()*alpha, val1.getY()*alpha);
    }

    public Value2f scalarMultiply (float alpha)
    {
        return new Vector2f(this.getX()*alpha, this.getY()*alpha);
    }

    public static Value2f scalarDivide (Value2f val1, float alpha)
    {
        return new Vector2f(val1.getX()/alpha, val1.getY()/alpha);
    }

    public Value2f scalarDivide (float alpha)
    {
        return new Vector2f(this.getX()/alpha, this.getY()/alpha);
    }

    public Value2f add(Value2f val)
    {
        return new Vector2f(this.x + val.getX(), this.y + val.getY());
    }

    public Value2f subtract(Value2f val)
    {
        return new Vector2f(this.x - val.getX(), this.y - val.getY());
    }

    public float getMagnitude()
    {
        return (float) Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public static float crossProduct(Vector2f val1, Vector2f val2)
    {
        return (val1.x * val2.y) - (val1.y * val2.x);
    }

    public float crossProduct(Value2f val)
    {
        return (this.x * val.getY()) - (this.y * val.getX());
    }

    public static float dotProduct(Value2f val1, Value2f val2)
    {
        return val1.getX() * val2.getX() + val1.getY() * val2.getY();
    }

    public float dotProduct(Value2f val)
    {
        return this.x * val.getX() + this.y * val.getY();
    }

    @Override
    public float getX()
    {
        return this.x;
    }

    @Override
    public float getY()
    {
        return this.y;
    }

    @Override
    public Value2f setX(float x)
    {
        return new Vector2f(x, this.y);
    }

    @Override
    public Value2f setY(float y)
    {
        return new Vector2f(this.x, y);
    }

    @Override
    public Value2f setValue2f(float x, float y)
    {
        return new Vector2f(x, y);
    }

    public String toString ()
    {
        return "<"+this.x + ", " + this.y+">";
    }
}
