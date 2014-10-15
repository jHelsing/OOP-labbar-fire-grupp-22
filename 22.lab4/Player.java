/* A class for Players to  be used in Memory.
 * @author Tobias Allden and Jonathan Helsing 
 * 
 */
public class Player{
	
	private int score;
	private String name;
	
	
	public Player(String name) {
		this.score = 0;
		this.name = name;
	}
	
	public int getScore() {
		return this.score;
	}
	public void setScore() {
		this.score = this.score+1;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	
	
	 	
	
	
}
