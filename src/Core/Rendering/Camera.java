package Core.Rendering;

import Core.Math.Vector2f;

public class Camera
{
    private Vector2f position, size;
    private float zoomFactor;
    private Vector2f lookAt;

    public Camera (Vector2f position, Vector2f size)
    {
        this.position = position;
        this.size = size;
        this.zoomFactor = 1.0f;
        this.lookAt = new Vector2f(this.size.getX()/2.0f, this.size.getY()/2.0f);
    }

    public void setZoomFactor (float zoomFactor)
    {
        if (zoomFactor > 0.0f)
        {
            this.zoomFactor = zoomFactor;
        }
        else
        {
            throw new IllegalArgumentException("Can't have zoom <= 0.0f");
        }
    }

    public Vector2f translateWorldToScreen (float worldX, float worldY)
    {
        return new Vector2f((worldX - this.position.getX())*zoomFactor, (worldY - this.position.getY())*zoomFactor);
    }

    public Vector2f translateScreenToWorld (float screenX, float screenY)
    {
        return new Vector2f((screenX/zoomFactor) + this.position.getX(), (screenY/zoomFactor) + this.position.getY());
    }

    public void lookAt (Vector2f lookAt)
    {
        this.lookAt = lookAt;
    }

    public Vector2f getPosition()
    {
        return position;
    }

    public Vector2f getSize()
    {
        return size;
    }

    public float getZoomFactor()
    {
        return zoomFactor;
    }

    public Vector2f getLookAt()
    {
        return lookAt;
    }

    public void setSize(Vector2f size)
    {
        this.size = size;
    }

    public void setPosition(Vector2f position)
    {
        this.position = position;
    }

    public boolean clip (float x, float y, float width, float height)
    {
        return x >= this.position.getX() && y >= this.position.getY() && x <= (this.position.getX() + this.size.getX()) &&
                y <= (this.position.getY() + this.size.getY()) || (x + width) >= this.position.getX() && (y + height) >= this.position.getY();
    }
}
