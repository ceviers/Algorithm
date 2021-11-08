package MaxSumOfSubList;

//查找和最大的子数组
public class MaxSubListSum {

    public static void main(String[] args) {
        int[] arr = {-1,3,-8,5,9,-4,5,6,9,-7,1,-2,5,-6};
//        long t0 = System.currentTimeMillis();
//        for (int i = 0; i < 1E7; i++) {
//            method1(arr);
//        }
//        long t1 = System.currentTimeMillis();//160ms
//        for (int i = 0; i < 1E7; i++) {
//            method2(arr);
//        }
//        long t2 = System.currentTimeMillis();//3300ms
//        System.out.println("1: " + (t1 - t0) + "ms\n2: " + (t2 - t1) + "ms");
//        System.out.println(method1(arr));
        System.out.println(method2(arr));
    }

    public static int method1(int[] arr){
        int max = arr[0];
        int subMax = 0;
        for(int a: arr){
            if(a <= 0){
                if(a > max)
                    max = a;
                subMax = subMax + a > 0 ? subMax + a : 0;
            }else{
                subMax += a;
                if(subMax > max)
                    max =subMax;
            }
        }
        return max;
    }

    public static int method2(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i; j++){
                int sum = 0;
                for(int k = j; k < arr.length - i; k++)
                    sum += arr[k];
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }
}
