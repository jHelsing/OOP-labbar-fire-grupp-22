
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

/**
 *  A class for cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 */

public class Memory extends JFrame {
	private ArrayList<Player> players = new ArrayList<Player>();
	
	public Memory(int nbrOfCols,int nbrOfRows) {
		setSize(new Dimension(300,400));
		buttonPanel btnPanel = new buttonPanel();
		PlayersPanel playersPanel = new PlayersPanel(players);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Memory");
		JMenu menu = new JMenu();
		JMenuItem newGame = new JMenuItem("Nytt spel");
		menu.add(newGame);
		add(btnPanel,BorderLayout.SOUTH);
		//Add newGame
		add(playersPanel,BorderLayout.WEST);
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
			setLayout(new FlowLayout());
			newButton.addActionListener(this);
			exitButton.addActionListener(this);
			add(newButton);
			add(exitButton);
		}
	}
	private class PlayersPanel extends JPanel{
		
		
		public	PlayersPanel(ArrayList<Player> players) {
			
			setBackground(Color.RED);
			setLayout(new BoxLayout(this,));
		}
	}
	
	

	
	
	
	public static void main(String[] args) {		
		//String nbrOfCol = JOptionPane.showInputDialog("Ange antelet kolumner.");
		//String nbrOfRow = JOptionPane.showInputDialog("Ange antalet rader.");
		//int row = Integer.parseInt(nbrOfRow);
		//int col = Integer.parseInt(nbrOfCol);
		int nbrOfCols = 0;
		int nbrOfPlayers = 0;
		int nbrOfRows = 0;
		startValues(nbrOfCols,nbrOfRows);
		Memory game = new Memory(nbrOfCols,nbrOfRows );
		
	}
	
	
	 static void startValues(int Cols, int Rows) { // Kolla input om korrekt, samt sätt startvärden
		 boolean valuesSet = false;
		 while (valuesSet == false) {
			 try {
				 Cols = Integer.parseInt(JOptionPane.showInputDialog("How many columns?"));				 
				 Rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows?"));
				 valuesSet = true;		 
				 
			 }
			 catch(NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Skriv ett riktigt nummer", "fel", JOptionPane.ERROR_MESSAGE);
			 }
			 
		 }
		}
	
	

}
