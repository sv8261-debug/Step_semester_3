
package array.assignmentproblems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int product = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}