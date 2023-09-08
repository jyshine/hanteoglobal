package task2;


import java.util.Arrays;

public class TaskRun2 {
    static int solution(int sum, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        // case 1
        int sum = 4;
        int[] coins = {1,2,3};
        System.out.println(solution(sum, coins));

        // case 2
        int sum2 = 10;
        int[] coins2 = {2, 5, 3, 6};
        System.out.println(solution(sum2, coins2));

    }
}
