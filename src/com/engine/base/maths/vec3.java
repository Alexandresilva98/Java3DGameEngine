package com.engine.base.maths;

public class vec3
{
	private float x, y, z;
	
	public vec3()
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}

	public vec3(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float length()
	{
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public float dot(vec3 r)
	{
		return x * r.getX() + y * r.getY() + z * r.getZ();
	}

	public vec3 cross(vec3 r)
	{
		float _x = y * r.getZ() - z * r.getY();
		float _y = z * r.getX() - x * r.getZ();
		float _z = x * r.getY() - y * r.getX();
		
		return new vec3(_x, _y, _z);
	}
	
	public vec3 normalize()
	{
		float length = length();

		x /= length;
		y /= length;
		z /= length;

		return this;
	}

	public vec3 rotate()
	{
		return null;
	}

	public vec3 add(vec3 r)
	{
		return new vec3(x + r.getX(), y + r.getY(), z + r.getZ());
	}

	public vec3 add(float r)
	{
		return new vec3(x + r, y + r, z + r);
	}

	public vec3 subtract(vec3 r)
	{
		return new vec3(x - r.getX(), y - r.getY(), z - r.getZ());
	}

	public vec3 subtract(float r)
	{
		return new vec3(x - r, y - r, z - r);
	}

	public vec3 multiply(vec3 r)
	{
		return new vec3(x * r.getX(), y * r.getY(), z * r.getZ());
	}

	public vec3 multiply(float r)
	{
		return new vec3(x * r, y * r, z * r);
	}

	public vec3 divide(vec3 r)
	{
		return new vec3(x * r.getX(), y * r.getY(), z / r.getZ());
	}

	public vec3 divide(float r)
	{
		return new vec3(x / r, y / r, z / r);
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

	public float getZ()
	{
		return z;
	}

	public void setZ(float z)
	{
		this.z = z;
	}

}
