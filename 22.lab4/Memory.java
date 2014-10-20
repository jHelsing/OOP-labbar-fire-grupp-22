
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

public class Memory extends JFrame implements ActionListener{
	private Player[] players;
	private int rows = 0,cols = 0;
	private GamePanel gamePanel;
	private ButtonPanel btnPanel;
	private PlayersPanel playerPanel;
	private Kort[] cards, gameCards;
	private File bildmapp = new File("bildmapp");
	private File[] images = this.bildmapp.listFiles();
	private Kort chosenCard1,chosenCard2;
	

	public Memory() { //Creates the Memory window, and calls for all methods to initialize the game.
		startValues();
		this.gameCards = new Kort[rows*cols];
		this.gamePanel = new GamePanel();
		this.cards = new Kort[images.length];
		for (int i = 0; i<images.length; i++) {
			this.cards[i] = new Kort(new ImageIcon(images[i].getPath()),Kort.Status.DOLT);
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
	
	
		
	
	
	

	private class GamePanel extends JPanel {
		
		public GamePanel() {
			setLayout(new GridLayout(rows,cols));
		}
	}

	
	private void startValues() { //Check if valid input and create startvalues
		boolean valuesSet = false;
		while (valuesSet == false) {
			try {
				this.cols = Integer.parseInt(JOptionPane.showInputDialog("How many columns?"));				 
				this.rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows?"));				
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
		this.gamePanel.removeAll();
		if (this.players == null) {
			int num = 0;
			while(num == 0) {
				String inputPlayers = JOptionPane.showInputDialog("How many players");
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
		for(int i = 0; i<this.gameCards.length;i++) {//add actionlisteners
			gameCards[i].addActionListener(this);
		}
		System.out.println("Antal kort:" + gameCards.length);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof Kort && (((Kort) e.getSource()).getStatus() != Kort.Status.SAKNAS)) {
		if(chosenCard1 == null) {
			chosenCard1 = (Kort) e.getSource();
			chosenCard1.setStatus(Kort.Status.SYNLIGT);
		}
		else if(chosenCard2 == null && (Kort) e.getSource() != chosenCard1) {
			chosenCard2 = (Kort) e.getSource();
			chosenCard2.setStatus(Kort.Status.SYNLIGT);
		}
		else if((Kort) e.getSource() == chosenCard1 || (Kort) e.getSource() == chosenCard2) {
			//do nothing
		}
		else if(chosenCard1 != null && chosenCard2 !=null){
			if(chosenCard1.sammaBild(chosenCard2)) {
				chosenCard1.setStatus(Kort.Status.SAKNAS);
				chosenCard2.setStatus(Kort.Status.SAKNAS);
				chosenCard1 = null;
				chosenCard2 = null;
				//currentPlayer.add
			}
			else {
				chosenCard1.setStatus(Kort.Status.DOLT);
				chosenCard2.setStatus(Kort.Status.DOLT);
				chosenCard1 = null;
				chosenCard2 = null;
			}
		}
		
	}else {
		
	}
}
}

