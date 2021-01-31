package com.alexdev.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {
	
	public String [] options = {"new game","load game","exit"};
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up, down, enter;
	
	public boolean pause = false;
	
	
	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}
		if(enter) {
			Sound.music.loop();
			enter = false;
			if(options[currentOption] == "new game" || options[currentOption] == "continue") {
				Game.gameState = "NORMAL";
				pause = false;
				
			}else if (options[currentOption] == "exit" ) {
				System.exit(1);
			}
		}
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g2.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);
		g.setColor(Color.RED);
		g.setFont(new Font("Showcard Gothic", Font.BOLD,40));
		g.drawString("MASTER OF DESTRUCTION",(Game.WIDTH * Game.SCALE) /2 -260, (Game.HEIGHT * Game.SCALE) / 2 -100);
		
		//Opcoes de menu
		g.setColor(Color.WHITE);
		g.setFont(new Font("Showcard Gothic", Font.BOLD,20));
		if(pause == false)
			g.drawString("New Game",(Game.WIDTH * Game.SCALE) /2 - 45, 200);
		else
			g.drawString("Resume",(Game.WIDTH * Game.SCALE) /2 - 40, 200);	
		g.drawString("Load Game",(Game.WIDTH * Game.SCALE) /2 - 50, 240);
		g.drawString("Exit",(Game.WIDTH * Game.SCALE) /2 - 20, 280);
		
		
		if(options[currentOption] == "new game") {
			g.drawString(">",(Game.WIDTH * Game.SCALE) /2 - 70, 200);
			
		}else if(options[currentOption] == "load game") {
			g.drawString(">",(Game.WIDTH * Game.SCALE) /2 - 75, 240);
			
		}else if(options[currentOption] == "exit") {
			g.drawString(">",(Game.WIDTH * Game.SCALE) /2 - 45, 280);
		
		}
			
	
	}
	
}
