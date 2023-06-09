import java.util.*;

class Main {

    static void removePrimes(int arr[], int len) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (isprime(arr[i])) {
                ans.add(arr[i]);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    static boolean isprime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        removePrimes(arr, n);
    }
}
