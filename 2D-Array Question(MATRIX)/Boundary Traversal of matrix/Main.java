import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        boundaryTraversal(m, n, matrix);
        sc.close();
    }

    public static void boundaryTraversal(int m, int n, int[][] matrix) {
        // your code here
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                System.out.print(matrix[i][0] + " ");
            }
            return;
        }
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[0][j] + " ");
            }
            return;
        }
        for (int j = 0; j < n; j++) {
            System.out.print(matrix[0][j] + " ");
        }
        for (int i = 1; i <= m - 1; i++) {
            System.out.print(matrix[i][n - 1] + " ");
        }
        for (int j = n - 2; j >= 0; j--) {
            System.out.print(matrix[m - 1][j] + " ");
        }
        for (int i = m - 2; i >= 1; i--) {
            System.out.print(matrix[i][0] + " ");
        }
    }
}