package projectEuler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * 
 * @author <img src="https://avatars2.githubusercontent.com/u/3778188?v=2&s=30" width="30" height="30" /> <a href="https://github.com/DRA2840" target="_blank"> Diego Azevedo (DRA2840) </a>
 *
 */
public class P009 {
	
	public static void main(String[] args) {
		System.out.println(calculateAnswer());
	}
	
	/**
	 * Calculates answer
	 * @return answer
	 */
	public static String calculateAnswer(){
		return String.valueOf(findAndMultiplyPytagoreanTriplet(1000,1,1));
	}
	
	/*
	 * This is based on Euclid's formula:
	 * a = m^2 - n^2; b = 2mn; c = m^2 + n^2
	 * You can multiply all elements with a constant K
	 * */
	/**
	 * Finds a Pythagorean Triplet with a given sum and multiply it's elements
	 * @param sum sum
	 * @param m Don't worry about this. Starts with 0
	 * @param n Don't worry about this. Starts with 0
	 * @return a*b*c in a pythagoran triplet with the given sum, if exists. 0 otherwise.
	 */
	private static long findAndMultiplyPytagoreanTriplet(int sum, int m, int n){
		if(m <= n){
			// m should be always bigger than n
			return findAndMultiplyPytagoreanTriplet(sum, m+1, n);
		}
		if (m > sum){
			// if you searched this much, there is no such tripplet.
			return 0;
		}
		if((2*m)*(m+n) > sum){
			// if you passed, increments the smallest, resets the biggest and try again
			return findAndMultiplyPytagoreanTriplet(sum, n+2, n+1); 
		}
		
		if (sum % ((2*m)*(m+n)) == 0){
			// if you found it, multiply all elements and multiply again by K^3
			return P000.cube((sum / ((2*m)*(m+n))))*(m*m-n*n)*(2*m*n)*(m*m+n*n);
		}
		
		// if you didn't find, increments the biggest and keep going
		return findAndMultiplyPytagoreanTriplet(sum, m+1, n);
	}

}