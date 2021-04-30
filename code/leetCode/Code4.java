package cn.longq.code;

/**
 * @description:
 * @author: Liu Hualong
 * @created: 2021/04/28 13:29
 */
public class Code4 {

    public static void main(String[] args) {
        int[] a = {-1,0};
        int[] b = {};
        double medianSortedArrays = findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int var1 = nums1.length;
        int var2 = nums2.length;
        int sum = var1 + var2;
        int z1 =0, z2 = 0,v1 = 0,v2 = 0,i = 0,v=0;
        if (var1 == 0 && var2 == 0 ){
            return 0.0d;
        } else if (var1 == 0){
            return var2 % 2 == 0 ? (nums2[var2 / 2] +nums2[(var2 - 2) / 2])/2.0d : nums2[(var2 - 1)/2] * 1.0d;
        }else if (var2 == 0){
            return var1 % 2 == 0 ? (nums1[var1 / 2] + nums1[(var1 - 2) / 2])/2.0d : nums1[(var1 - 1)/2] * 1.0d;
        }
        boolean result = sum % 2 == 0;
        while (i< sum){
            if (var1 > z1 && var2 > z2){
                if (nums1[z1] < nums2[z2]){
                    v = nums1[z1]; z1++;
                }else {
                   v = nums2[z2];z2++;
                }
            }else if (var1 > z1 && var2 <= z2){
                v = nums1[z1];z1 ++;
            }else if (var2 > z2 && var2 > z2){
                v = nums2[z2];z2++;
            }
            if (i%2==0) {
                v1 = v;
            }else {
                v2 = v;
            }
            if (sum / 2 == i){
                return result ? (v1 + v2) / 2.0d : v * 1.0d;
            }
            i ++;
        }
        return 0.0d;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int var1 = nums1.length;
        int var2 = nums2.length;
        int sum = var1 + var2;
        int z1 =0, z2 = 0,v1 = 0,v2 = 0,var = 0;
        if (sum == 1){
            var =  var1 == 0 ? nums1[0] : nums2[0];
            return var * 1.0d;
        }
        int i = 0,x;
        boolean result = sum % 2 == 0;
        x = result ? sum /2 :(sum +1) /2;

        while (i < sum){
            if (var1-1 > z1 && var2-1 > z2){
                if (nums1[z1] > nums2[z2]) z1++;else z2++;
            }else if (var1-1 > z1 && var2-1 < z2){
                z1 ++;
            }else if (var1-1 < z1 && var2-1 > z2){
                z2 ++;
            }
            if (result){
                v1  =  x == z1 + z2 ? nums1[z1] + nums2[z2] : v1;
                v2  =  x + 1 == z1 + z2 ? nums1[z1] + nums2[z2] : v2;
            }else {
                v2 = x == z1 +z2 ? nums1[z1] + nums2[z2] : v2;
            }
            if (v2 != 0 ){
                return result ? (v1 + v2) / 2.0d : v2 * 1.0d;
            }
            i ++ ;
        }
        return 0.0d;
    }

}
