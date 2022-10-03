package TicTacToe;

import java.awt.*;
import java.awt.event.*;

class Window extends Frame{
	private final int WIDTH = 100;
	private final int HEIGHT = 100;
	protected Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
	protected Button[] baseButtons;
	private static Dialog winDialog;
	MenuBar mb;
	MenuItem item;
	
	Window(){
		WindowClose();
		SetupMenu();
		baseButtons = SetupButtons();
		
		setMenuBar(mb);
		setSize(400, 400);
		setTitle("Tic Tac Toe");
		setLayout(null);
		setVisible(true);
	}
	
	// Setup buttons
	private Button[] SetupButtons() {
		
		Button[] buttons = {b1 = new Button(), b2 = new Button(), b3 = new Button(), 
				b4 = new Button(), b5 = new Button(), b6 = new Button(),
				b7 = new Button(), b8 = new Button(), b9 = new Button()};
		
		b1.setBounds(40, 60, WIDTH, HEIGHT);
		b2.setBounds(150, 60, WIDTH, HEIGHT);
		b3.setBounds(260, 60, WIDTH, HEIGHT);
		b4.setBounds(40, 165, WIDTH, HEIGHT);
		b5.setBounds(150, 165, WIDTH, HEIGHT);
		b6.setBounds(260, 165, WIDTH, HEIGHT);
		b7.setBounds(40, 270, WIDTH, HEIGHT);
		b8.setBounds(150, 270, WIDTH, HEIGHT);
		b9.setBounds(260, 270, WIDTH, HEIGHT);
		
		return buttons;
	}
    
    // Window events
	private void WindowClose() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}
	
	// Menu
	private void SetupMenu() {
		mb = new MenuBar();
		Menu menu = new Menu("Menu");
		item = new MenuItem("Restart");
		menu.add(item);
		mb.add(menu);
	}
	
	// Dialog window
	public void ShowWinner(String winner) {
		winDialog = new Dialog(this, "Congratulations", true);
		winDialog.setLayout(new GridBagLayout());
		winDialog.add(new Label("Winner is: " + winner));
		Button b = new Button("OK");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				winDialog.setVisible(false);
				dispose();
			}
		});
		winDialog.add(b);
		winDialog.setSize(300, 300);
		winDialog.setVisible(true);
	}
}