import java.util.Scanner;

class subsetSum {
static boolean isSubsetSum(int set[], int n, int sum, boolean dp[][]) {
if (sum == 0)
return true;
if (n == 0)
return false;

if (dp[n][sum])
return true;

if (set[n - 1] > sum) {
dp[n][sum] = isSubsetSum(set, n - 1, sum, dp);
return dp[n][sum];
}

dp[n][sum] = isSubsetSum(set, n - 1, sum, dp) || isSubsetSum(set, n - 1, sum - set[n - 1], dp);
return dp[n][sum];
}

public static void main(String args[]) {
Scanner scanner = new Scanner(System.in);

System.out.println("Enter the number of elements:");
int n = scanner.nextInt();

int set[] = new int[n];

System.out.println("Enter the elements:");
for (int i = 0; i < n; i++) {
set[i] = scanner.nextInt();
}

System.out.println("Enter the target sum:");
int sum = scanner.nextInt();

boolean dp[][] = new boolean[n + 1][sum + 1];

if (isSubsetSum(set, n, sum, dp)) {
System.out.println("Found a subset with the given sum");

System.out.print("Subset: ");
int i = n;
int j = sum;
while (i > 0 && j > 0) {
if (dp[i][j] != dp[i - 1][j]) {
System.out.print(set[i - 1] + " ");
j = j - set[i - 1];
}
i--;
}
} else {
System.out.println("No subset with the given sum");
}
}
}
