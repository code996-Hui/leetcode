package leetcode.editor.cn;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 
//
// 注意： 
//
// 
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。
// 请根据这个假设，如果反转后整数溢出那么就返回 0。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2448 👎 0

public class 整数反转 {
    public static void main(String[] args) {
        Solution solution = new 整数反转().new Solution();
        int res = solution.reverse(-2147483648);
        System.out.println(res);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
      if (x<-Integer.MIN_VALUE||x>Integer.MAX_VALUE-1){
          return 0;
      }
        String str = Integer.toString(x);
            if (str.length() == 1) {
                return x;
            }
            char[] arr = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            if (arr[0] == '-') {
                sb.append('-');
                for (int i = (arr.length - 1); i > 0; i--) {
                    if (arr[i] == '0'&&sb.length()==1) continue;
                    sb.append(arr[i]);
                }
                double doubleNum = Double.parseDouble(sb.toString());

                if (doubleNum>Integer.MAX_VALUE||doubleNum<Integer.MIN_VALUE){
                    return 0;
                }
                return (int) doubleNum;
            }
            for (int i = (arr.length - 1); i >= 0; i--) {
                if (arr[i] == '0'&&sb.length()==0) continue;
                sb.append(arr[i]);
            }
            double doubleNum = Double.parseDouble(sb.toString());

            if (doubleNum>Integer.MAX_VALUE||doubleNum<Integer.MIN_VALUE){
                return 0;
            }
            return (int) doubleNum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}