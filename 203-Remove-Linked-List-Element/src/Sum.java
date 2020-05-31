/**
 * @author: webin
 * @date: 2020/5/28 20:57
 * @description:
 * @version: 0.0.1
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr,0);
    }

    private static int sum(int[] arr, int l) {

        if (l == arr.length) {
            return 0;
        }
        int x = sum(arr, l + 1);
        int res = arr[l] + x;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(sum(nums));
    }
}
