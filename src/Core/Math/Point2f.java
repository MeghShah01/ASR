package Core.Math;

public class Point2f implements Value2f
{
    float x, y;

    public Point2f (float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Point2f (Value2f value2f)
    {
        this.x = value2f.getX();
        this.y = value2f.getY();
    }

    public Point2f ()
    {
        this.x = this.y = 0.0f;
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
    public Value2f setValue2f(float x, float y)
    {
        return new Point2f(x, y);
    }

    @Override
    public Value2f setX(float x)
    {
        return new Point2f(x, this.y);
    }

    @Override
    public Value2f setY(float y)
    {
        return new Point2f(this.x, y);
    }
}
