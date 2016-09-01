package com.engine.base.render;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import com.engine.Util;

public class Mesh
{
	private int m_vbo;
	private int m_size;
	
	public Mesh()
	{
		m_vbo = glGenBuffers();
		m_size = 0;
	}
	
	public void addVertices(Vertex[] vertices)
	{
		m_size = vertices.length;
		
		glBindBuffer(GL_ARRAY_BUFFER, m_vbo);
		glBufferData(GL_ARRAY_BUFFER, Util.createFlippedBuffer(vertices), GL_STATIC_DRAW);
	}
	
	public void draw()
	{
		glEnableVertexAttribArray(0);
		
		glBindBuffer(GL_ARRAY_BUFFER, m_vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0);
		
		glDrawArrays(GL_TRIANGLES, 0, m_size);
		
		glDisableVertexAttribArray(0);
	}
}
