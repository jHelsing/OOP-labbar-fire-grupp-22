
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.annotation.processing.FilerException;
import javax.swing.*;

/**
 *  A class for cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 */

public class Memory extends JFrame {
	private ArrayList<Player> players = new ArrayList<Player>();
	private int rows = 0;
	private int cols = 0;
	private GamePanel gamePanel;
	File bildmapp = new File("bildmapp");
	File[] bilder = this.bildmapp.listFiles();

	public Memory() {
		startValues();
		ButtonPanel btnPanel = new ButtonPanel();
		PlayersPanel playersPanel = new PlayersPanel(players);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Memory");
		add(btnPanel,BorderLayout.SOUTH);;
		add(playersPanel,BorderLayout.WEST);
		nyttSpel();
		add(gamePanel,BorderLayout.CENTER);
		
		pack();
		setVisible(true);

	}


	private class ButtonPanel extends JPanel implements ActionListener {
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

		public ButtonPanel() {
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
			//setLayout(new BoxLayout(this,));
		}
	}

	private class GamePanel extends JPanel implements ActionListener {
		
		public GamePanel() {
			setLayout(new GridLayout(cols,rows));
			setBackground(Color.blue);
			nyttSpel();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hi!");
			
		}
	}
	
	private void nyttSpel() { // initierar spel med kort.
		this.gamePanel = new GamePanel();
		//Kort[] cards = new Kort[rows*cols];
		ArrayList<Kort> cards = new ArrayList<Kort>();
		System.out.println(bilder[0].getPath());
	for(int i = 0;i<bilder.length;i++) {
			String path = bilder[i].getPath();
			cards.add(new Kort(new ImageIcon(path)));
			cards.setIcon(new ImageIcon(path));
		}
		this.gamePanel.add(cards);
	}
	
	private void startValues() { // Kolla input om korrekt, samt s�tt startv�rden
		boolean valuesSet = false;
		while (valuesSet == false) {
			try {
				this.cols = Integer.parseInt(JOptionPane.showInputDialog("How many columns?"));				 
				this.rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows?"));
				valuesSet = true;				
				if((this.cols*this.rows)/2> bilder.length) {
					throw new FilerException("F�r stor spelplan f�r antalet kort");
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










	public static void main(String[] args) {
		Memory game = new Memory();

	}
}

