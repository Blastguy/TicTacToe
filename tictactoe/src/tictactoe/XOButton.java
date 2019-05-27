package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class XOButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	ImageIcon X;
	ImageIcon O;
	private static int[][] board = new int[3][3];
	private static int player1Score = 0;
	private static int player2Score = 0;
	private boolean clicked = false;
	private int posX = 0;
	private int posY = 0;
	private static int turn = 0;
	private static boolean finished = false;
	
	
	
	public XOButton(int p, int q) {
		X = new ImageIcon(this.getClass().getResource("/X.png"));
		O = new ImageIcon(this.getClass().getResource("/O.png"));
		posX = p;
		posY = q;
		
		setOpaque(false);
		setContentAreaFilled(false);
		addActionListener(this);
		setVisible(true);
		
	}
	
	private void markSpot(int c) {
		board[posX][posY] = c;
	}
	
	public static int getP1() {
		return player1Score;
	}
	
	public static int getP2() {
		return player2Score;
	}
	
	
	@SuppressWarnings("unused")
	private void winCheck() {
		for(int j = 0; j < 3; j++) {
			if(board[j][0] == 1 && board[j][1] == 1 && board[j][2] == 1 || board[0][j] == 1 && board[1][j] == 1 && board[2][j] == 1) {
				player1Score++;
				GameEnd end = new GameEnd("X wins this round!");
				finished = true;
				break;
			}
			else if(board[j][0] == 2 && board[j][1] == 2 && board[j][2] == 2 || board[0][j] == 2 && board[1][j] == 2 && board[2][j] == 2) {
				player2Score++;
				GameEnd end = new GameEnd("O wins this round!");
				finished = true;
				break;
			}
		}
		
		if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1 || board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
			player1Score++;
			GameEnd end = new GameEnd("X wins this round!");
			finished = true;
		}
		else if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2 || board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
			player2Score++;
			GameEnd end = new GameEnd("O wins this round!");
			finished = true;
		}
		if(turn == 9 && !finished) {
			GameEnd end = new GameEnd("This round is a Draw");
			finished = true;
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!clicked && !finished) {
			turn++;
			if(turn % 2 == 0) {
				this.setIcon(O);
				markSpot(2);
				clicked = true;
			}
			else {
				this.setIcon(X);
				markSpot(1);
				clicked = true;
			}
			
			winCheck();
		}
		
	}

	public void resetButton() {
		this.setIcon(null);
		markSpot(0);
		this.clicked = false;
	}
	
	public static void resetStatics() {
		turn = 0;
		finished = false;
	}

}
