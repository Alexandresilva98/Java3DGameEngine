package com.engine.base.maths;

public class vec2
{
	private float x;
	private float y;
	
	public vec2()
	{
		this.x = 0;
		this.y = 0;
	}

	public vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x * x + y * y);
	}
	
	public float dot(vec2 r)
	{
		return x * r.getX() + y * r.getY();
	}
	
	public vec2 normalize()
	{
		float length = length();
		
		x /= length;
		y /= length;
		
		return this;
	}
	
	public vec2 rotate(float angle)
	{
		double rad = Math.toRadians(angle);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		return new vec2((float)(x * cos - y * sin), (float)(x * sin + y * cos));
	}
	
	public vec2 add(vec2 r)
	{
		return new vec2(x + r.getX(), y + r.getY());
	}
	
	public vec2 add(float r)
	{
		return new vec2(x + r, y + r);
	}
	
	public vec2 subtract(vec2 r)
	{
		return new vec2(x - r.getX(), y - r.getY());
	}
	
	public vec2 subtract(float r)
	{
		return new vec2(x - r, y - r);
	}
	
	public vec2 multiply(vec2 r)
	{
		return new vec2(x * r.getX(), y * r.getY());
	}
	
	public vec2 multiply(float r)
	{
		return new vec2(x * r, y * r);
	}
	
	public vec2 divide(vec2 r)
	{
		return new vec2(x * r.getX(), y * r.getY());
	}
	
	public vec2 divide(float r)
	{
		return new vec2(x / r, y / r);
	}
	
	public boolean equals(vec2 r)
	{
		return (x == r.getX() && y == r.getY());
	}
	
	public String toString()
	{
		return "(" + x + " " + y + ")";
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
}
