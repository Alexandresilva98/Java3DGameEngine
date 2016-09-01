package com.engine.base;

import com.engine.base.maths.vec3;
import com.engine.base.render.Mesh;
import com.engine.base.render.Vertex;

public class Game
{
	private Mesh mesh;
	
	public Game()
	{
		mesh = new Mesh();
		
		Vertex[] data = new Vertex[] { new Vertex(new vec3(-1,-1, 0)),
									   new Vertex(new vec3(-1, 1, 0)),
									   new Vertex(new vec3( 0, 1, 0))
		};
		
		mesh.addVertices(data);
		
	}
	
	public void input()
	{
		if(Input.getMouseDown(0))
			System.out.println(Input.getMousePosition().toString());
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		mesh.draw();
	}
	
}
