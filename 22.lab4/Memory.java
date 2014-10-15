
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 *  A class for cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 */

public class Memory extends JFrame {
	
	public Memory() {
		setSize(new Dimension(300,400));
		buttonPanel btnPanel = new buttonPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Memory");
		JMenu menu = new JMenu();
		JMenuItem newGame = new JMenuItem("Nytt spel");
		menu.add(newGame);
		add(btnPanel,BorderLayout.SOUTH);
		add(menu);
		pack();
		setVisible(true);
		
	}
	
	
	private class buttonPanel extends JPanel implements ActionListener {
		private JButton newButton = new JButton("New Game");
		private JButton exitButton = new JButton("Exit");
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().getClass().getName() == "New Game") {
				
			}
			else {
				
				System.exit(0);
			}
			
		}
		
		public buttonPanel() {
			setBackground(Color.yellow);
			setLayout(new BorderLayout(2,2));
			newButton.addActionListener(this);
			exitButton.addActionListener(this);
			add(newButton,BorderLayout.WEST);
			add(exitButton,BorderLayout.EAST);
		}
	}
	

	
	
	
	public static void main(String[] args) {		
		//String nbrOfCol = JOptionPane.showInputDialog("Ange antelet kolumner.");
		//String nbrOfRow = JOptionPane.showInputDialog("Ange antalet rader.");
		//int row = Integer.parseInt(nbrOfRow);
		//int col = Integer.parseInt(nbrOfCol);
		int nbrOfCards = 0;
		int nbrOfPlayers = 0;
		int nbrOfRows = 0;
		startValues(nbrOfCards,nbrOfPlayers, nbrOfRows);
		Memory game = new Memory();
		
	}
	
	
	 static void startValues(int Cards, int Players, int rows) {
		 boolean valuesSet = false;
		 while (valuesSet == false) {
			 try{
				Cards =  Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
				Players =  Integer.parseInt(JOptionPane.showInputDialog("How many columns?"));
				rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows?"));
				
				
				
				valuesSet = true;
				 
			 }
			 catch(NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Skriv ett riktigt nummer", "fel", JOptionPane.ERROR_MESSAGE);
			 }
			 
		 }
		}
	
	

}
