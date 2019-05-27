package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private XOButton[][] buttons = new XOButton[3][3];
	
	public TicTacToe() {
		panel = new JPanel(new GridLayout(3,3));
		setTitle("Tic Tac Toe");
		setSize(600,600);
		setResizable(false);
		
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < 3; i++) {
				panel.add(buttons[j][i] = new XOButton(j,i));
			}
		}
		
		panel.setBackground(Color.white);
		this.add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void resetBoard() {
		for(int j = 0; j < 3; j++) {
			for(int i = 0; i < 3; i++) {
				buttons[j][i].resetButton();
			}
		}
		XOButton.resetStatics();
	}
	
	
}
