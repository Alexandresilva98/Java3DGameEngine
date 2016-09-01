package com.engine.base;

import com.engine.base.maths.Quaternion;
import com.engine.base.render.RenderUtil;

public class MainComponent {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "ENGINE";
	public static final double FRAME_CAP = 5000.0;

	private boolean m_isRunning;
	private Game m_game;
	
	public MainComponent()
	{
		System.out.println(RenderUtil.getOpenGLVersion());
		RenderUtil.initGraphics(new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
		m_isRunning = false;
		m_game = new Game();
	}
	
	public void start()
	{
		if(m_isRunning)
			return;
		run();
	}
	
	public void stop()
	{
		if(!m_isRunning)
			return;
		
		m_isRunning = false;
	}
	
	private void run()
	{
		m_isRunning = true;
		
		int frames = 0;
		long frameCounter = 0;

		final double frameTime = 1.0 / FRAME_CAP;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		
		while(m_isRunning)
		{
			boolean render = false;
			
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)Time.SECOND;
			frameCounter += passedTime;
			
			while(unprocessedTime > frameTime)
			{
				render = true;
				unprocessedTime -= frameTime;
				
				if(Window.isCloseRequested())	stop();
				
				Time.setDelta(frameTime);
				
				//TODO: Update Game
				m_game.input();
				Input.update();
				
				m_game.update();
				
				if(frameCounter >= Time.SECOND)
				{
					System.out.println(frames);
					frames = 0;
					frameCounter = 0;
				}
			}
			if(render)
			{
				render();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}
	
	private void render()
	{
		RenderUtil.clearScreen();
		m_game.render();
		Window.render();
	}
	
	private void cleanUp()
	{
		Window.dispose();
	}
	
	public static void main(String[] args) {
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		
		MainComponent game = new MainComponent();
		game.start();
	}

}
