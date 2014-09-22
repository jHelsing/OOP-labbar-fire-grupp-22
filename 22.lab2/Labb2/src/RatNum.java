	/* Calculate rational numbers.
 * @author Tobias Alldén
 * @author Jonathan Helsing
 */
public class RatNum {	
		private int m;
		private int n;
		
		
	public RatNum() {
		this.m = 0;
		this.n= 1;
		
	}
	
	public RatNum(int a) {
		this.m = a;
		this.n = 1;
		
	}
	
	public RatNum(int a, int b) {
		if (b == 0) {
			throw new NumberFormatException("Denominator = 0");			
		}
		else {
			if (b<0) {
				b = -b;
				a = -a;
			}
		int devideBy = gcd(a, b);
		this.m = a/devideBy;
		this.n = b/devideBy;
		}
		
	}
	
	public RatNum(RatNum r) {
		m = r.getNumerator();
		n = r.getDenominator();
	}
	
	public int getNumerator() {
		return m;
	}
	public int getDenominator() {
		return n;
	}
	
	
	
	
	public static int gcd(int m, int n) {
			
		if ( m<0 || n<0 ) {
			if (m < 0 && n < 0) {
				m = m/-1;
				n = n/-1;
			} else if(n<0) {
				n = -n;
			} else if(m < 0) {
				m = -m;
			}
			
		}
		else if ( m == 0 && n == 0) {
			throw new IllegalArgumentException();			
		} else if (n == 0) {
			return m;			
		} 
			int r;
			while (true) {
				r = m%n;
				if (r==0) {
					return n;				
				}
				else {
					m = n;
					n = r;
				}
			}
	}//end gcd	
}//end RatNum
