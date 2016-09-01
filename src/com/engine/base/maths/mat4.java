package com.engine.base.maths;

public class mat4
{
	private float[][] m;
	
	public static mat4 identity = new mat4().identity();
	
	public mat4()
	{
		
		m = new float[4][4];
	}
	
	public mat4 multiply(mat4 r)
	{
		mat4 res = new mat4();
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				res.set(i, j, m[i][0] * r.get(0, j) +
							  m[i][1] * r.get(1, j) +
							  m[i][2] * r.get(2, j) +
							  m[i][3] * r.get(3, j));
			}
		}
		
		return res;
	}
	
	public mat4 identity()
	{
		for(int x = 0; x < 4; x++)
		{
			for(int y = 0; y < 4; y++)
			{
				m[x][y] = 0;
			}
		}
		for(int i = 0; i < 4; i++)
		{
			m[i][i] = 1;
		}
		return this;
	}
	
	public float[][] getMat4()
	{
		return m;
	}
	
	public float get(int x, int y)
	{
		return m[x][y];
	}
	
	public void setMat4(float[][] m)
	{
		this.m = m;
	}
	
	public void set(int x, int y, float value)
	{
		m[x][y] = value;
	}
}
