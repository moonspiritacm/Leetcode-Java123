import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = cin.nextInt();
		
		int x = n - m; // 同桌数
		int y = 2 * m - n; // 单桌数
		Arrays.sort(a);
		int left = 0;
		int right = n - y - 1;
		int max = 0;
		while(left < right) {
			int tmp = a[left] + a[right];
			if(tmp > max)
				max = tmp;
			left++;
			right--;
		}
		System.out.println(max);
	}
}