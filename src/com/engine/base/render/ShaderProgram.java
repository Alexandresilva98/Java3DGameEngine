package com.engine.base.render;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;

public class ShaderProgram
{
	private int m_program;
	
	public ShaderProgram()
	{
		m_program = glCreateProgram();
		if(m_program == 0)
		{
			System.err.println("Shader program creation failed.");
			System.exit(1);
		}
	}
	
	public void bind()
	{
		glUseProgram(m_program);
	}
	
	public void addVertexShader(String text)
	{
		addToProgram(text, GL_VERTEX_SHADER);
	}
	
	public void addGeometryShader(String text)
	{
		addToProgram(text, GL_GEOMETRY_SHADER);
	}
	
	public void addFragmentShader(String text)
	{
		addToProgram(text, GL_FRAGMENT_SHADER);
	}
	
	public void compileShaderProgram()
	{
		glLinkProgram(m_program);
		
		if(glGetShaderi(m_program, GL_LINK_STATUS) == 0)
		{
			System.err.println(glGetShaderInfoLog(m_program, 1024));
			System.exit(-1);
		}
		
		glValidateProgram(m_program);
		
		if(glGetShaderi(m_program, GL_VALIDATE_STATUS) == 0)
		{
			System.err.println(glGetShaderInfoLog(m_program, 1024));
			System.exit(-1);
		}
	}
	
	private void addToProgram(String text, int type)
	{
		int shader = glCreateShader(type);
		if(shader == 0)
		{
			System.err.println("Shader creation failed.");
			System.exit(-1);
		}
		
		glShaderSource(shader, text);
		glCompileShader(shader);
		
		if(glGetShaderi(shader, GL_COMPILE_STATUS) == 0)
		{
			System.err.println(glGetShaderInfoLog(shader, 1024));
			System.exit(-1);
		}
		
		glAttachShader(shader, m_program);
	}
}
