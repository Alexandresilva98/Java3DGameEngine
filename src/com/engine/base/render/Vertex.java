package com.engine.base.render;

import com.engine.base.maths.vec3;

public class Vertex
{
	public static final int SIZE = 3;
	
	private vec3 m_pos;
	
	public Vertex(vec3 pos)
	{
		m_pos = pos;
	}
	
	public vec3 getPos()
	{
		return m_pos;
	}
	
	public void setPos(vec3 pos)
	{
		m_pos = pos;
	}
}
