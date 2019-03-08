import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int k = cin.nextInt();
		cin.nextLine();
		int[][] matrix = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = cin.nextLine();
			char[] chs = str.toCharArray();
			for(int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(""+chs[j]);
			}
		}
		int[][] dp = new int[n][m];
		int count = 0;
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= m - 2; j++) {
				if (matrix[i][j] == 1 && matrix[i - 1][j] == 1 && matrix[i + 1][j] == 1 && matrix[i][j - 1] == 1
						&& matrix[i][j + 1] == 1) {
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j])) + 1;
				} else
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
				if (dp[i][j] >= k)
					count++;
			}
		}
		System.out.println(count);	
	}
}