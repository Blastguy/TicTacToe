package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class GameEnd extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel content;
	JPanel top;
	JPanel middle;
	JPanel bottom;
	JPanel left;
	JPanel right;
	
	JLabel header;
	JLabel leftScore;
	JLabel rightScore;
	JLabel image;
	JButton exit;
	JButton retry;
	
	Box box1;
	Box box2;
	Box p1Box;
	Box p2Box;
	
	
	public GameEnd(String text) {
		header = new JLabel();
		leftScore = new JLabel();
		rightScore = new JLabel();
		image = new JLabel();
		exit = new JButton("Exit");
		retry = new JButton("Restart");
		exit.addActionListener(this);
		retry.addActionListener(this);
		top = new JPanel();
		middle = new JPanel();
		left = new JPanel();
		right = new JPanel();
		bottom = new JPanel(new GridLayout(2,1));
		
		box1 = Box.createHorizontalBox();
		box2 = Box.createHorizontalBox();
		p1Box = Box.createHorizontalBox();
		p2Box = Box.createHorizontalBox();
		
		bottom.add(retry);
		bottom.add(exit);
		bottom.add(box2);
		
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.content = (JPanel) getContentPane();
		this.content.setLayout(new BorderLayout());
		setSize(600,400);
		
		header.setFont(new java.awt.Font("Arial", Font.BOLD, 60));
		String result = text;
		header.setText(result);
		box1.add(header);
		top.add(box1);
		
		leftScore.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
		rightScore.setFont(new java.awt.Font("Arial", Font.PLAIN, 20));
		String p1 = "P1 Score: " + XOButton.getP1();
		String p2 = "P2 Score: " + XOButton.getP2();
		leftScore.setText(p1);
		rightScore.setText(p2);
		p1Box.add(leftScore);
		p2Box.add(rightScore);
		left.add(p1Box);
		right.add(p2Box);
		
		ImageIcon gameOver = new ImageIcon(this.getClass().getResource("/gameover.png"));
		image.setIcon(gameOver);
		middle.add(image);
		this.content.add(top, java.awt.BorderLayout.NORTH);
		this.content.add(middle, java.awt.BorderLayout.CENTER);
		this.content.add(left, java.awt.BorderLayout.WEST);
		this.content.add(right, java.awt.BorderLayout.EAST);
		this.content.add(bottom, java.awt.BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		}
		else if(e.getSource() == retry) {
			Frame[] allF = JFrame.getFrames();
			((TicTacToe) allF[0]).resetBoard();
			this.setVisible(false);
		}

	}

}
