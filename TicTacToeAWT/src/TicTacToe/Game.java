package TicTacToe;

import java.awt.*;
import java.awt.event.*;

class Game extends Window implements ActionListener{
	private boolean playerOneTurn, gameOver = false;
	private String winner = "";
	
	Game(){
		ButtonColors();
		PerformActionOnClick();
		ItemMenuSetup();
		playerOneTurn = true;
		
		while(!gameOver) {
			gameOver = CheckWin();
		}
		
		ShowWinner(winner);
	}
	
	// Prepare buttons (color)
	private void ButtonColors() {
		for(int i = 0; i < baseButtons.length; i++) {
			baseButtons[i].setBackground(Color.WHITE);
			add(baseButtons[i]);
		}
	}
	
	// Button Actions
	private void PerformActionOnClick() {
		for(int i = 0; i < baseButtons.length; i++) {
			baseButtons[i].addActionListener(this);
		}
	}
	
	// Action events
	public void actionPerformed(ActionEvent e) {
		Button b = (Button)e.getSource();
		if(playerOneTurn && b.getBackground() == Color.WHITE) {
			b.setBackground(Color.GREEN);
			playerOneTurn = false;
		}
		else if(!playerOneTurn && b.getBackground() == Color.WHITE) {
			b.setBackground(Color.RED);
			playerOneTurn = true;
		}
	}
	
	// Menu item setup
	private void ItemMenuSetup() {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ButtonColors();
				playerOneTurn = true;
			}
		});
	}
	
	// Check winner
	private boolean CheckWin() {
		boolean draw = true;
		Color bg;
		
		// Draw
		for(int i = 0; i < baseButtons.length; i++) {
			if(baseButtons[i].getBackground() == Color.WHITE) {
				draw = false;
				break;
			}
		}
		
		if(draw) {
			winner = "DRAW";
			return true;
		}
		
		// Rows
		for(int i = 0; i < baseButtons.length; i+=3) {
			bg = baseButtons[i].getBackground();
			if(bg != Color.WHITE) {
				if(baseButtons[i+1].getBackground() == bg && baseButtons[i+2].getBackground() == bg) {
					winner = (bg == Color.GREEN) ? "Player One" : "Player two";
					return true;
				}
			}
			
		}
		// Columns
		for(int i = 0; i < baseButtons.length/3; i++) {
			bg = baseButtons[i].getBackground();
			if(bg != Color.WHITE) {
				if(baseButtons[i+3].getBackground() == bg && baseButtons[i+6].getBackground() == bg) {
					winner = (bg == Color.GREEN) ? "Player One" : "Player two";
					return true;
				}
			}
		}
		// Diagonally for 3x3 board
		if(baseButtons[0].getBackground() != Color.WHITE) {
			if(baseButtons[0].getBackground() == baseButtons[4].getBackground() && baseButtons[4].getBackground() == baseButtons[8].getBackground()) {
				winner = (baseButtons[0].getBackground() == Color.GREEN) ? "Player One" : "Player two";
				return true;
			}
		}
		if(baseButtons[2].getBackground() != Color.WHITE) {
			if(baseButtons[2].getBackground() == baseButtons[4].getBackground() && baseButtons[4].getBackground() == baseButtons[6].getBackground()) {
				winner = (baseButtons[2].getBackground() == Color.GREEN) ? "Player One" : "Player two";
				return true;
			}
		}
		
		return false;
	}
}