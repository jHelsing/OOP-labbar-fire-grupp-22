import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

	/* Calculate rational numbers.
 * @author Tobias Alldén
 * @author Jonathan Helsing
 */
public class RatNum {	
		private int m;
		private int n ;
		
		
	public RatNum() {
		this.m = 0;
		this.n= 1;
		
	}
	
	public RatNum(int a) {
		this.m = a;
		this.n = 1;
		
	}
	
	public RatNum (String s) {		
		RatNum r = parse(s);
			this.m = r.m;
			this.n = r.n;
		
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
	}//end getNumerator
	public int getDenominator() {
		return n;
	}//end getDenomenator
	
	
	public String toString() {
		int modulo = m%n;
		int d = m/n;
		String s = d + " " + modulo + "/" + this.n;
		return s; 
		
	}//end toString
	
	public double toDouble() {
		double dM = (double) this.m;
		double dN = (double) this.n;
		return dM/dN;
		
	}//end toDouble

	public static RatNum parse(String s) {
		System.out.println("String : " + s);
		int m = 0;
		int n = 0;
		boolean tryParse;
		String numberOne;
		String numberTwo;
		if (!s.contains("/")) {
			int space = s.indexOf(" ");
			numberOne = s.substring(0,s.length());
			
			try {
				m = Integer.parseInt(numberOne);
				tryParse = true;
			}
			catch(NumberFormatException e) {
				tryParse = false;
			}
			
			if (tryParse) {
				return new RatNum(m);
			}
			else {
				throw new NumberFormatException();
			}
			
		}
		else {
			int slash = s.indexOf("/");
			numberOne = s.substring(0,slash);
			numberTwo = s.substring(slash+1,s.length());		
		
			try {
				m = Integer.parseInt(numberOne);
				n = Integer.parseInt(numberTwo);
				tryParse = true;
			}
			catch(NumberFormatException e) {
				tryParse = false;
			}
		
			if(tryParse) {
				return new RatNum(m,n);
			}
			else {
				throw new NumberFormatException();
			}
		}
	}
	public boolean equals(Object r) {
		if(r == null) {
			return false;			
		}
		else if(r instanceof RatNum) {
			RatNum tempRat = ((RatNum) r);
			int tempRatCommonFactor = gcd(tempRat.m, tempRat.n);			
			int thisCommonFactor = gcd(this.m, this.n);
			if(tempRat.m/tempRatCommonFactor == this.m/thisCommonFactor
					&& tempRat.n/tempRatCommonFactor == this.n/thisCommonFactor) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
	}//end equals
	public boolean lessThan(RatNum r) {
		if (this.m*r.n < r.m*this.n) {
			return true;
		}
		else {
			return false;
		}//end lessThan
		
		
	}
	
	public RatNum add(RatNum r) {
		int tempNumerator = this.m*r.n + r.m*this.n;
		int tempDenomenator = this.n*r.n;
		int commonFactor = gcd(tempNumerator, tempDenomenator);
		return new RatNum((tempNumerator/commonFactor), (tempDenomenator/commonFactor));	
	} // end add

	public RatNum sub(RatNum r) {
		int tempNumerator = (this.m * r.n) - (r.m * this.n);
		int tempDenomenator = this.n*r.n;
		int commonFactor = gcd(tempNumerator, tempDenomenator);
		return new RatNum(tempNumerator/commonFactor, tempDenomenator/commonFactor);
		
	}// end sub
	
	public RatNum mul(RatNum r) {
		int tempNumerator = this.m * r.m;
		int tempDenomenator = this.n * r.n;
		int commonFactor = gcd(tempNumerator, tempDenomenator);
		return new RatNum(tempNumerator/commonFactor, tempDenomenator/commonFactor);		
	}// end mul
	
	public RatNum div(RatNum r) {
		int tempNumerator = this.m * r.n;
		int tempDenomenator = this.n * r.m;
		int commonFactor = gcd(tempNumerator, tempDenomenator);
		return new RatNum(tempNumerator/commonFactor, tempDenomenator/commonFactor);
		
	}//end div
	
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
