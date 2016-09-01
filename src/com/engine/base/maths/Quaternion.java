package com.engine.base.maths;

public class Quaternion
{
	private float x, y, z, w;
	
	public Quaternion()
	{
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	public Quaternion(float x, float y, float z, float w)
	{
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public float length()
	{
		return (float)Math.sqrt(x * x + y * y + z * z + w * w);
	}
	
	public Quaternion normalize()
	{
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		w /= length;
		
		return this;
	}
	
	public Quaternion conjugate()
	{
		return new Quaternion(-x, -y, -z, w);
	}
	
	public Quaternion multiply(Quaternion r)
	{
		float _w, _x, _y, _z;
		_w =  w * r.getW() - x * r.getX() - y * r.getY() - z * r.getZ();
		_x =  x * r.getW() + w * r.getX() + y * r.getZ() - z * r.getY();
		_y =  y * r.getW() + w * r.getY() + z * r.getX() - x * r.getZ();
		_z =  z * r.getW() + w * r.getZ() + x * r.getY() - y * r.getX();
		
		return new Quaternion(_x, _y, _z, _w);
	}
	
	public Quaternion multiply(vec3 r)
	{
		float _w, _x, _y, _z;
		_w = -x * r.getX() - y * r.getY() - z * r.getZ();
		_x =  w * r.getX() + y * r.getZ() - z * r.getY();
		_y =  w * r.getY() + z * r.getX() - x * r.getZ();
		_z =  w * r.getZ() + x * r.getY() - y * r.getX();
		
		return new Quaternion(_x, _y, _z, _w);
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

	public float getW()
	{
		return w;
	}

	public void setW(float w)
	{
		this.w = w;
	}
	
	
}
