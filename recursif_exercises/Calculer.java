package recursif_exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculer {
	
	
	public static void main(String[] args) {
		System.out.println("R1: " + factoriel(5));
		System.out.println("R2: " + pgcd(120,18));
		System.out.print("R3: "); imprimerNbPremier(18);
		System.out.println("R4: " + sommeSn(5));
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<10; i++)
            stack.push(i);
		System.out.println("R5:");
		System.out.println("	Original Stack: " + stack);
		reverseStack(stack);
		System.out.println("	Reversed Stack: " + stack);
		Integer[] myArrayForSomme = {3, 5, 7, 12, 13, 61};
		System.out.println("R6:");
		System.out.print("	Original Array: ");
		for(int i=0; i<myArrayForSomme.length; i++) System.out.print(myArrayForSomme[i] + " ");
		System.out.println();
		System.out.println("	Result = " + callSommeArray(myArrayForSomme));
		Integer[] myArrayForSort = {3, 15, 7, 1, 95, 61, 8, 3, 100};
		System.out.println("R7:");
		System.out.print("	Original Array: ");
		for(int i=0; i<myArrayForSort.length; i++) System.out.print(myArrayForSort[i] + " ");
		System.out.println();
		callBubbleSort(myArrayForSort);
		System.out.print("	Sorted Array: ");
		for(int i=0; i<myArrayForSort.length; i++) System.out.print(myArrayForSort[i] + " ");
		System.out.println();
		int[] arrayCountNeg = {1, 12, -6, -8, 38, 0, -100, -23};
		System.out.println("R8: " + callCountNegNumber(arrayCountNeg));
		System.out.println("R9: " + callConverteur(1011));
		System.out.println("R10: " + fibonacci(11));
		int[] subSet = {3, 34, 4, 12, 5, 2};
		int trueValue1 = 20;
		int trueValue2 = 46;
		int falseValue = 13;
		
		System.out.println("R12: " + sumSquare(6));
		System.out.println("R13: " + callReverseNumber(8162));
		System.out.println("R14: " + countDigitNumber(123456));
		System.out.println("R15: " + Txn(5, 8));
		System.out.println("R16: " + Pn(5));
		System.out.println("R17: " + squareExpression(5));
	}
	
	// Q1 Factoriel n!
	public static long factoriel(long input) {
		if (input == 0) {
			return 1;
		} else {
			return factoriel(input-1)*input;			
		}
	}
	
	// Q2 Plus Grand Commun Déviseur
	public static long pgcd(long a, long b) {
		if(a==b) {
			return a;
		} else if (a>b) {
			return pgcd(a-b,b);
		} else {
			return pgcd(a,b-a);
		}		
	}
	
	
	// Q3 Imprimer les nombres premiers
	public static void imprimerNbPremier(long n) {
		if(n==1) {
			System.out.println();
		} else {
			if (checkNbPremier(n, 2) == false) System.out.print(n + " ");
			imprimerNbPremier(n-1);	
		}			
	}
	
	public static boolean checkNbPremier(long n, long i) {
		if (i == n) {
			return false;
		}
		if (n%i == 0) {
			return true;
		}
		return checkNbPremier(n, i+1);
	}
	
	
	// Q4 Somme S(n)
	public static long sommeSn(long n) {
		if (n==1) {
			return 1;
		} else {
			return sommeSn(n-1) + factoriel(n);
		}
	}
	
	// Q5 Reverse a Stack
	public static void reverseStack(Stack st) {
		if (st.size() > 0) {
			Object out = st.peek(); 
            st.pop(); 
            reverseStack(st);   
            
            insertAtBottom(st, out);
		}
	}
	
	public static void insertAtBottom(Stack st, Object in) {
		if (st.isEmpty()) {
			st.push(in);
		} else {
			Object a = st.peek(); 
            st.pop();
            //System.out.print(a + " ");
            insertAtBottom(st, in);
            st.push(a);
		}
	}
	
	// Q6 Somme d'un Array
	public static Integer callSommeArray(Integer[] array) {		
		if(array.length == 0) {
			return 0;
		} else {
			int length = array.length - 1;			
			return sommeArray(array, length, length);
		}	
	}
	
	public static Integer sommeArray(Integer[] array, int length, int count) {
		if(count > 0) {
			count--;
			return  sommeArray(array, length, count) + array[count+1];
		} else {
			return array[count];
		}
		
	}
	
	// Q7 Bubble Sort
	public static void callBubbleSort(Integer[] array) {
		int length = array.length-1;
		bubbleSort(array, length);
	}
	
	public static void bubbleSort(Integer[] array, int length) {
		if (length > 0) {
			length--;
			smallBubbleSort(array, 0 ,length);
			bubbleSort(array, length);
		}
	}
	
	public static void smallBubbleSort(Integer[] array, int count, int length) {
		if(count < length) {
			swapNumber(array, count, count+1);
			smallBubbleSort(array, count+1, length);
		}
	}
	
	public static void swapNumber (Integer[] array, int i, int j) {
		Integer content;
		if (array[i] > array[j]) {
			content = array[i];
			array[i] = array[j];
			array[j] = content;
		}
	}
	
	// Q8 Count the number of negative numbers in an array
	public static int callCountNegNumber(int[] array) {
		int length = array.length-1;
		int count = 0;
		return countNegNumber(array, length, count);
	}
	
	public static int countNegNumber(int[] array, int length, int count) {
		if(length < 0) return count;
		else {
			if(array[length] < 0) {
				count++;
			}
			length--;
			return countNegNumber(array, length, count);
		}
	}
	
	// Q9 Convert a binary into a decimal
	public static long callConverteur(long n) {
		long base = 1;
		return convertBinaryDecimal(n, base);
	}
	
	public static long convertBinaryDecimal(long n, long base) {	
		if(n == 0) {
			return 0;
		}
		else {	
			long last_digit = n % 10;
			n = n/10;
			base *=2;
			return convertBinaryDecimal(n, base) + last_digit*base/2;
		}
	}
	
	// Q10 Fibonacci
	public static long fibonacci(long n) {
		if (n==1 || n==2) return 1;
		return fibonacci(n-1) + fibonacci(n-2);		
	}
	
	// Q11 Subset Sum Problem
	public static boolean isSubsetSum(int[] array, int compareValue) {
		return true;
	}
	
	// Q12 Sum of Square
	public static double sumSquare(double n) {
		if (n == 1) return 1;
		else {
			return sumSquare(n-1) + Math.pow(n,n);
		}
	}
	
	// Q13 Reverse an integer
	public static double callReverseNumber(int n) {
		// We store every digits of our Number in "store".
		ArrayList<Integer> store = new ArrayList<Integer>();
		// "length" represents the size of our "store".
		int length = 0;
		return storeNumberElement(n, store, length);
	}
	
	public static double storeNumberElement(int n, ArrayList<Integer> store, int length) {
		if(n > 0) {
			// Add digit numbers into "store"
			store.add(n % 10);
			n/=10;
			length++;
			return storeNumberElement(n, store, length);
		} else {
		// Recreate our number through "store" and function "recreateNumber".
		return recreateNumber(store, length, length-1);
		}
	}
	
	public static double recreateNumber(ArrayList<Integer> store, int length, int count) {
		if(count == 0) {
			// Attention : our index's store is inversed.
			return store.get(length-1);
		} else {
			count--;
			return recreateNumber(store, length, count) + store.get(length-count-2)*Math.pow(10, count+1);
		}
	}
	
	// Q14 Count the digit number of an integer
	public static int countDigitNumber(int n) {
		if(n < 10) return 1;
		n/=10;
		return countDigitNumber(n)+1;
	}
	
	// Q15 Calculate T(x,n) = x^n
	public static int Txn(int x, int n) {
		if(n == 0) return 1;
		else {
			n--;
			return Txn(x, n)*x;
		}		
	}
	
	// Q16 Calculate P(n)=1.3.5..(2n+1)
	public static long Pn(int n) {
		if(n==0) return 1;
		else {
			n--;
			return Pn(n)*(2*(n+1)+1);
		}
	}
	
	// Q17 Calculate squareExpression
	public static double squareExpression(int n) {
		if (n == 1) return 1;
		else {
			n--;
			return Math.sqrt(n+1+squareExpression(n));
		}
	}
}
