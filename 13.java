import java.util.Scanner;

public class TSE {

static int n;
static int[][] dist;
static int MAX = 1000000;
static int[][] memo;

static int fun(int i, int mask) {
if (mask == ((1 << i) | 3))
return dist[1][i];
if (memo[i][mask] != 0)
return memo[i][mask];

int res = MAX;

for (int j = 1; j <= n; j++)
if ((mask & (1 << j)) != 0 && j != i && j != 1)
res = Math.min(res, fun(j, mask & (~(1 << i))) + dist[j][i]);
return memo[i][mask] = res;
}

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Enter the number of nodes: ");
n = scanner.nextInt();

dist = new int[n + 1][n + 1];
System.out.println("Enter the distance matrix:");

for (int i = 1; i <= n; i++)
for (int j = 1; j <= n; j++)
dist[i][j] = scanner.nextInt();

int startNode;
do {
System.out.print("Enter the starting node (1 to " + n + "): ");
startNode = scanner.nextInt();
} while (startNode < 1 || startNode > n);

memo = new int[n + 1][1 << (n + 1)];

int ans = MAX;
for (int i = 1; i <= n; i++)
ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1) + dist[i][startNode]);

System.out.println("The cost of the most efficient tour = " + ans);

scanner.close();
}
}
