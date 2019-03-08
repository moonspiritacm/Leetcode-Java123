import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[][] a = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = i; j < n; j++)
				a[i][j] = cin.nextInt();
		
		if(n == 1) {
			System.out.println(a[0][0]);
		}
		
		int res = 0;
		for(int j = 0; j < n; j++) {
			int min = 100000;
			for(int i = 0; i < n; i++) {
				if(min > a[i][j] && a[i][j] != 0)
					min = a[i][j];
			}
			res += min;
		}
		System.out.println(res);
	}
}