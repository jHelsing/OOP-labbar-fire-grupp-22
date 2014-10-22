import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;

import org.omg.PortableInterceptor.INACTIVE;

/* A class for Players to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 * 
 */
public class Player extends JColorfulButton{
	
	private int score;
	private String name;
	private Status status;
	JLabel lName;
	JLabel lScore;
	public enum Status {
		ACTIVE,INACTIVE
	}
	
	public void setStatus(Status s) { 
		switch (s) {
		case ACTIVE:
			this.status = (Status.ACTIVE);
			this.setBackground(Color.yellow);
			break;
		
		case INACTIVE:
			this.status = (Status.INACTIVE);
			this.setBackground(Color.white);
			break;
		
		
		default:
			break;
		}	
			
	}
	
	
	public Player(String name) {
		this.score = 0;
		this.name = name;
		this.status = Status.INACTIVE;
		this.setLayout(new BorderLayout());
		this.lName = new JLabel(this.name);
		this.lScore = new JLabel(Integer.toString(this.score));
		add(lName,BorderLayout.CENTER);
		add(lScore,BorderLayout.SOUTH);
		
	}
	
	public int getScore() {
		return this.score;
	}
	public void incScore() {
		this.score = this.score+1;
		this.lScore.setText(Integer.toString(this.score));
	}
	public void resetScore() {
		this.score = 0;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	
	
	 	
	
	
}
