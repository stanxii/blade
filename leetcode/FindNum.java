/*
    给定一个数，找到数组中相加等于给定数值的两个数，java实现。
*/

import java.util.HashMap;
// public class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] rst = {0,0};
//         int length = nums.length;
//         if(nums.length <= 0){
//             return rst;
//         }

//         for(int i = 0; i < length; ++i){
//             /*
//             if(target < nums[i]){
//                 continue;
//             }
//             */
//             //获取还需要的另一个 数
//             int temp = target - nums[i];
//             int j = 0;
//             for(j = i + 1; j < length; ++j){
//                 if(temp == nums[j]){
//                     break;
//                 }
//             }
//             //如果在后面的数字中找到了符合要求的
//             if(j < length){
//                 rst[0] = i;
//                 rst[1] = j;
//             }
//         }
//         return rst;
//     }

// }

public class FindNum {
    public static int[] findTwoNum(int[] a, int target) {
        int[] res = { -1, -1 };
        if (a == null || a.length < 2)
            return res;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            hm.put(a[i], i);
        }
        for (int i = 0; i < a.length; i++) {
            if (hm.containsKey(target - a[i]) && target != 2 * a[i]) {
                res[0] = i;
                res[1] = hm.get(target - a[i]);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 4, 7, 8, 9 };
        int[] r = findTwoNum(a, 16);
        System.out.printf("a:%d,b:%d", a[r[0]], a[r[1]]);
    }
}
