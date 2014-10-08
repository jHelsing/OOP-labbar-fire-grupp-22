/* A class for calculating the root of a function.
 *@author Tobias Allden and Jonathan Helsing
 */
public class Secant  {
	public static double secant(Function f,double low, double high, double eps) {
		//Declare variables
		double x = (high*f.f(low) - low*f.f(high))/(f.f(low)-f.f(high));
		//Check if function is decreasing, if so, switch low and high
		if(f.f(low) > f.f(high)) {
			double tmp = high;
			high = low;
			low = tmp; 
		}  //If no roots found, throw exception.
		if(f.f(low)*f.f(high) > 0) { 
			throw new IllegalArgumentException("No roots found in interval");
		} 
		//If x is in accepted interval,return x.
		if (f.f(x) * f.f(x+eps) <= 0 || f.f(x) * f.f(x-eps) <= 0) {
			return x;
		}
		// Else change low or high, depending on x
		 else {
			if (f.f(x) < 0) {
				low = x;
			} else{
				high = x;
			}

		}
		return secant(f, low, high, eps);
	}

}

