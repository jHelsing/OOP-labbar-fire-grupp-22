
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.annotation.processing.FilerException;
import javax.swing.*;


/**
 *  A class for cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 */

public class Memory extends JFrame {
	private Player[] players;
	private int rows = 0;
	private int cols = 0;
	private GamePanel gamePanel;
	private ButtonPanel btnPanel;
	private PlayersPanel playerPanel;
	Kort[] cards;
	Kort[] gameCards;
	File bildmapp = new File("bildmapp");
	File[] images = this.bildmapp.listFiles();

	public Memory() { //Creates the Memory window, and calls for all methods to initialize the game.
		startValues();
		this.gameCards = new Kort[rows*cols];
		this.cards = new Kort[images.length];
		for (int i = 0; i<images.length-1; i++) {
			this.cards[i] = new Kort(new ImageIcon(images[i].getPath()),Kort.Status.SYNLIGT);
		}
		this.btnPanel = new ButtonPanel();
		add(this.btnPanel,BorderLayout.SOUTH);
		setPreferredSize(new Dimension(400,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Memory");
		nyttSpel();
		setVisible(true);
	}


	 class ButtonPanel extends JPanel implements ActionListener {//Creates a Panel with two buttons, newGame and Exit
		private JButton newButton = new JButton("New Game");
		private JButton exitButton = new JButton("Exit");
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == newButton) {
				nyttSpel();
			}
			else {

				System.exit(0);
			}

		}

		public ButtonPanel() {
			setBackground(Color.yellow);
			setLayout(new FlowLayout());
			newButton.addActionListener(this);
			exitButton.addActionListener(this);
			add(newButton);
			add(exitButton);
		}
	}
	
	 private class PlayersPanel extends JPanel{// Creates the panel for Players
		
		public	PlayersPanel() {
			setLayout(new GridLayout(players.length,1));
			setBackground(Color.RED);
			setPreferredSize(new Dimension(150,150*players.length));
		}
	}
	
	
		
	
	
	

	private class GamePanel extends JPanel implements ActionListener {
		Kort tmpKort1 = null;
		Kort tmpKort2 = null; 
		
		public GamePanel() {
			setLayout(new GridLayout(rows,cols));
		}

			
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	
	private void startValues() { //Check if valid input and create startvalues
		boolean valuesSet = false;
		while (valuesSet == false) {
			try {
				this.cols = Integer.parseInt(JOptionPane.showInputDialog("How many columns?"));				 
				this.rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows?"));
				valuesSet = true;				
				if((this.cols*this.rows)/2> images.length) {
					throw new FilerException("För stor spelplan för antalet kort");
				}
				valuesSet = true;
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Skriv ett riktigt nummer", "fel", JOptionPane.ERROR_MESSAGE);
				}
				catch(FilerException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"Fel", JOptionPane.ERROR_MESSAGE);
				}
			}

			}

	private void nyttSpel() {
		if (this.players == null) {
			int num = 0;
			while(num == 0) {
				String inputPlayers = JOptionPane.showInputDialog("how many players");
				try {
					num = Integer.parseInt(inputPlayers);
					this.players = new Player[num];
					for(int i= 0; i<players.length;i++) {
						players[i] = new Player(Integer.toString(i));						
					}
					this.playerPanel = new PlayersPanel();
					for(int i = 0; i<players.length;i++) {
						this.playerPanel.add(players[i]);
					}
					add(this.playerPanel,BorderLayout.WEST);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Ange ett nummer","Fel", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		else{
			for(int i = 0; i<this.players.length;i++) {
				this.players[i].resetScore();
			}
				
		}
		
		Verktyg.slumpOrdning(cards);
		for(int i = 0; i<this.gameCards.length/2;i++) {
			this.gameCards[i] = cards[i];
			System.out.println("Antal kort:" + gameCards.length);
			this.gameCards[i+(this.gameCards.length/2)] = this.gameCards[i].copy(); 
		}
		Verktyg.slumpOrdning(this.gameCards);
		System.out.println("Antal kort:" + gameCards.length);
		this.gamePanel = new GamePanel();
		for(int i = 0; i<gameCards.length;i++) {
			gamePanel.add(this.gameCards[i]);
		}
		add(gamePanel,BorderLayout.CENTER);
		pack();
		invalidate();
		validate();
		
		
		
	}
	public static void main(String[] args) {
		Memory game = new Memory();
	}
}

