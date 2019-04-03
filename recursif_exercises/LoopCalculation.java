package recursif_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Solve problems by using Loop method
 */

public class LoopCalculation {
	
	public static void main(String[] args) {
		System.out.println("R1: " + factoriel(5));
		System.out.println("R2: " + pgcd(120,18));
		System.out.print("R3: "); printPrime(18);
		System.out.println("R4: " + sommeSn(5));
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<10; i++)
            stack.push(i);
		System.out.println("R5:");
		System.out.println("	Original Stack: " + stack);
		reverseStack(stack);
		System.out.println("	Reversed Stack: " + stack);
		Integer[] myArrayForSum = {3, 5, 7, 12, 13, 61};
		System.out.println("R6:");
		System.out.print("	Original Array: ");
		for(int i=0; i<myArrayForSum.length; i++) System.out.print(myArrayForSum[i] + " ");
		System.out.println();
		System.out.println("	Result = " + sumOfArray(myArrayForSum));
		Integer[] myArrayForSort = {3, 15, 7, 1, 95, 61, 8, 3, 100};
		System.out.println("R7:");
		System.out.print("	Original Array: ");
		for(int i=0; i<myArrayForSort.length; i++) System.out.print(myArrayForSort[i] + " ");
		System.out.println();
		bubbleSort(myArrayForSort);
		System.out.print("	Sorted Array: ");
		for(int i=0; i<myArrayForSort.length; i++) System.out.print(myArrayForSort[i] + " ");
		System.out.println();
		int[] arrayCountNeg = {1, 12, -6, -8, 38, 0, -100, -23};
		System.out.println("R8: " + countNegNumber(arrayCountNeg));
		System.out.println("R9: " + digitalDecimal(1011));
		System.out.println("R10: " + fibonacci(11));
		
		System.out.println("R12: " + sumSquare(6));
		System.out.println("R13: " + reverseNumber(8162));
		System.out.println("R14: " + countDigitNumber(123456));
		System.out.println("R15: " + Txn(5, 8));
		System.out.println("R16: " + Pn(5));
		System.out.println("R17: " + squareExpression(5));
	}
	
	// Q1 Factoriel n!
	public static int factoriel(int n) {
		int result = 1;
		if (n == 0) return result;
		for (int i=1; i<=n; i++) {
			result *= i;
		}			
		return result;
	}
	
	// Q2 Plus Grand Commun Déviseur
	public static int pgcd (int a, int b) {
		int result = 1;
		while (a!=b) {
			if(a > b) {
				a = a-b;
			} else if (a < b) {
				b = b-a;
			}
		}
		result = a;
		return result;
	}
	
	// Q3 Imprimer les nombres premiers
	public static void printPrime(int n) {
		for (int i=2; i<=n; i++) {
			if (isPrime(i)) System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static boolean isPrime(int n) {
		for (int i=2; i<=n/2; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	// Q4 Sum S(n)
	public static int sommeSn(int n) {
		int result = 0;
		for (int i=n; i>0; i--) {
			result += factoriel(i);
		}
		return result;
	}
	
	// Q5 Reverse a Stack
	public static void reverseStack(Stack st) {
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		/*
		 *  Insert st into stack 1.
		 *  Then, st will be empty meanwhile, st is reversed to st.
		 */
		insertAtBottom(stack1, st);
		insertAtBottom(stack2, stack1);
		insertAtBottom(st, stack2);
	}
	
	public static void insertAtBottom (Stack toBeInserted, Stack getFrom) {
		while (!getFrom.isEmpty()) {
			toBeInserted.push(getFrom.peek());
			getFrom.pop();
		}
	}
	
	// Q6 Sum of an Array
	public static int sumOfArray(Integer[] array) {
		int sum = 0;
		for (int i=0; i<array.length; i++) {
			sum+=array[i];
		}
		return sum;
	}
	
	// Q7 Bubble Sort
	public static void bubbleSort(Integer[] array) {
		for (int i = array.length-1; i>0; i--) {
			for(int j = 0; j<i; j++) {
				if(array[j] < array[j+1]) swap(array, j, j+1);
			}
		}
	}
	
	public static void swap(Integer[] array, int i, int j) {
		Integer mediator;
		mediator = array[i];
		array[i] = array[j];
		array[j] = mediator;
	}
	
	// Q8 Count Negative Number in an Array
	public static int countNegNumber(int[] array) {
		int count = 0;
		for (int i=0; i<array.length; i++) {
			if(array[i] < 0) count++;
		}
		return count;
	}
	
	// Q9 Convert a digital into decimal
	public static long digitalDecimal(long digit) {
		long decimal = 0;
		long temp = digit;
		int base = 1;
		while (temp > 0) {
			long lastDigit = temp % 10;
			temp/=10;
			decimal += lastDigit * base;
			base *= 2;
		}
		return decimal;		
	}
	
	// Q10 Fibonacci
	public static int fibonacci(int n) {
		int[] fibonacciList = new int[n];
		fibonacciList[0] = 0;
		if (n > 1) fibonacciList[1] = 1;
		for(int i = 2; i<n ; i++) {
			fibonacciList[i] = fibonacciList[i-1] + fibonacciList[i-2];
		}
		return fibonacciList[n-1];
	}
	
	// Q11 Subset Sum Problem
	public static boolean isSubsetSum(int array[], int value) {
		List<Integer> mediator = new ArrayList<Integer>();
		for (int element : array) {
			if (element == value) return true;
			mediator.add(element);
			for(Integer mediInteger : mediator) {
				mediator.add(mediInteger+1);
			}
		}
		return false;
	}
	
	// Q12 Sum of n Squares
	public static double sumSquare(int n) {
		double result = 0;
		for (int i=1; i<=n; i++) result += Math.pow(i, i);
		return result; 
	}
	
	// Q13 Reverse an Integer
	public static double reverseNumber(int n) {
		int count = 0;
		ArrayList<Integer> store = new ArrayList<Integer>();
		count = storeDigits(store, n);
		return  restoreNumber(store, count);		
	}
	
	public static int storeDigits(ArrayList<Integer> store, int num) {
		int count = 0;
		while (num > 0) {
			store.add(num % 10);
			num /= 10;
			count++;		
		}	
		return count;
	}
	
	public static double restoreNumber(ArrayList<Integer> store, int count) {
		double result = 0;
		for (int i=0; i< count; i++) {
			result += store.get(count-i-1)*Math.pow(10, i);
		}
		return result;
	}
	
	// Q14 Count the digit number of an integer
	public static int countDigitNumber(int n) {
		int count = 0;
		int temp = n;
		if(n < 10) return 1;
		while (temp > 0) {
			temp /= 10;
			count ++;
		}
		return count;
	}
	
	// Q15 Calculate T(x,n) = x^n
		public static int Txn(int x, int n) {
			int result = 1;
			if (n == 0) return 1;
			for (int i=1; i<=n; i++) result*=x;
			return result;
		}
		
		// Q16 Calculate P(n)=1.3.5..(2n+1)
		public static long Pn(int n) {
			int result = 1;
			for(int i=0; i<=n; i++) result *= (2*i+1);
			return result;
		}
		
		// Q17 Calculate squareExpression
		public static double squareExpression(int n) {
			double result = 0;
			for (int i=1; i<=n; i++) {
				result = Math.sqrt(i + result);
			}
			return result;
		}
}
