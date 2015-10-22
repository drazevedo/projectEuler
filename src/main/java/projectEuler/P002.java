package projectEuler;
/**
 * <p>Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
 * By starting with 1 and 2, the first 10 terms will be:</p>
 * 
 * <center>1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...</center>
 * 
 * <p>By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
 * find the sum of the even-valued terms.</p>
 * 
 * 
 * @author <img src="https://avatars2.githubusercontent.com/u/3778188?v=2&s=30" width="30" height="30" alt="Gravatar"> <a href="https://github.com/DRA2840" target="_blank"> Diego Azevedo (DRA2840) </a>
 */
public class P002 {
	
	private static final int MAX = 4000000;
	
	public static void main(String[] args) {
		
		System.out.println( calculateAnswer() );
		
	}
	
	/**
	 * Calculates answer
	 * @return answer
	 */
	public static String calculateAnswer(){
		return String.valueOf(sumOfEvenFibonacciNumbers(0, 1));
	}
	
	/**
	 * Sums all even Fibonacci numbers below the constant MAX (included)
	 * @param last the last fibonacci number calculated
	 * @param actual the actual fibonacci number
	 * @return The sum of all even Fibonacci numbers until MAX (four million)
	 */
	private static int sumOfEvenFibonacciNumbers (int last, int actual){
		if(actual > MAX){
			return 0;
		}
		return (isEven(actual)? actual : 0) + sumOfEvenFibonacciNumbers( actual, actual + last );
	}
	
	/**
	 * Is number even
	 * @param a number
	 * @return false, if number is odd =)
	 */
	private static boolean isEven(int a){
		return  a%2 == 0 ;
	}

}
