
import java.awt.*;

import javax.swing.*;

/**
 *  A class for cards to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 */

public class Memory extends JFrame {
	
	public Memory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Memory");
		JMenu menu = new JMenu();
		JMenuItem newGame = new JMenuItem("Nytt spel");
		menu.add(newGame);
		add(menu);
		pack();
		setVisible(true);
		
	}

	
	
	
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("Ange antalet spelare");
		//String nbrOfCol = JOptionPane.showInputDialog("Ange antelet kolumner.");
		//String nbrOfRow = JOptionPane.showInputDialog("Ange antalet rader.");
		//int row = Integer.parseInt(nbrOfRow);
		//int col = Integer.parseInt(nbrOfCol);
		String nbrOfCards = JOptionPane.showInputDialog("Ange antal kort");
		int numberOfPlayers = Integer.parseInt(s);
		int numberOfCards = Integer.parseInt(nbrOfCards);
		Memory game = new Memory();
		
	}
	
	

}
