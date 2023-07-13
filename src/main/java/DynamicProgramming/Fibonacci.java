package DynamicProgramming;

public class Fibonacci {

	public static void main(String[] args) {
		int res = fib(6);
		System.out.println(res);
	}

	private static int fib(Integer n) {
		if (n<=1) return n;
		int[] dp = new int[n+1];
		dp[0]= 0;
		dp[1] = 1;

		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
}
