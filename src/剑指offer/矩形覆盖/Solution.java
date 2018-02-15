package 剑指offer.矩形覆盖;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Administrator on 2018/2/15.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.RectCover(4));
    }

    public int RectCover(int target) {
        if(target<=0){
            return 0;
        } else if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }else{
          return RectCover(target-1)+RectCover(target-2);
        }
    }
}
