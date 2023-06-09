import java.util.*;

public class Main {
    public static int[] findTheWay(int[][] matrix) {
        // Write code here
        int m = matrix.length;
        int n = matrix[0].length;
        int ans[] = new int[2];
        int i = 0;
        int j = 0;
        int dir = 0;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            ans[0] = i;
            ans[1] = j;
            if (matrix[i][j] == 0) {
                if (dir == 0) {
                    j++;
                } else if (dir == 1) {
                    i++;
                } else if (dir == 2) {
                    j--;
                } else {
                    i--;
                }
            } else {
                matrix[i][j] = 0;
                if (dir == 0) {
                    dir = 1;
                    i++;
                } else if (dir == 1) {
                    dir = 2;
                    j--;
                } else if (dir == 2) {
                    dir = 3;
                    i--;
                } else {
                    dir = 0;
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }
        int result[] = findTheWay(matrix);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}