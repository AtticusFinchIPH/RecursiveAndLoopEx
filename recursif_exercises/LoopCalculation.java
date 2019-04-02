package recursif_exercises;

import java.util.Stack;

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
	
	// Q4 Somme S(n)
	public static int sommeSn(int n) {
		int result = 0;
		for (int i=n; i>0; i--) {
			result += factoriel(i);
		}
		return result;
	}
	
	// Q5 Reverse a Stack
	public static void reverseStack(Stack st) {
		
	}

}
