import java.util.HashMap;
import java.util.Scanner;

public class Problem04_SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum = currentSum + num;

            if (prefixSumCount.containsKey(currentSum - k)) {
                count = count + prefixSumCount.get(currentSum - k);
            }

            prefixSumCount.put(
                    currentSum,
                    prefixSumCount.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of Subarrays: " + subarraySum(nums, k));

        sc.close();
    }
}