import java.util.Scanner;


public class Size {
	public static void main(String[] args) {
		// test case: n=28, k=10, P=5 4 4 4 3 3 2 1 1 8
		Scanner inputN = new Scanner(System.in);
		Scanner inputP = new Scanner(System.in);
		
		System.out.println("Input positive integers n and k: ");
		int n = inputN.nextInt();
		int k = inputN.nextInt();
		
		System.out.println("Input partition P: ");
		int[] p = new int[k];
		
		for(int i=0; i<k; i++)
			p[i] = inputP.nextInt();
		
		printSize(n, k, p);
	}

	public static void printSize(int k, int n, int[] p) {
		int i = 0, j = 0, S = 0, T = 0;
		int[] A = new int[n];
		int[] B = new int[n];
		
		for(int l=0; l<n; l++)
			A[l] = (l < k ? p[l] : 1);
		
		while(A[i] != 1 && i+1 < n && j+1 < n) {
			if(A[i] == A[i+1])
				i++;
			else if(A[i] > A[i+1]) {
				B[j] = A[i];
				S = S + B[j]/2;
				++i;
				++j;
			} else if(A[i] < A[i+1])
				System.out.println("error");
		}

		System.out.print("B: ");
		for(int l=0; l<n; l++)
			if(B[l] != 0)
				System.out.print(B[l] + " ");
		T = T + S;
		
		System.out.println("\nS = " + S + ", T = " + T);
	}
}
