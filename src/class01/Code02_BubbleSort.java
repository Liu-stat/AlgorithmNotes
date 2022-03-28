package class01;

import java.util.Arrays;

//冒泡排序及其对数器验证
public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //使用比较器验证
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    //随机生成随机长度的数组
    public static int[] generateRandomArray(int maxSize, int maxValue){
        // Math.random()   [0,1)
        // Math.random() * N  [0,N)
        // (int)(Math.random() * N)  [0, N-1]
        int[] arr = new int[(int)(Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++){
            //[-maxValue,maxValue]
            arr[i] = (int)(Math.random() * (maxValue + 1)
                    - (int)(Math.random() * maxValue));
        }
        return arr;
    }
    //复制数组
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return arr;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    //判断数组相等否
    public static boolean isEqual(int[] arr1, int[] arr2){
        if (arr1 == null && arr2 == null){
            return true;
        }
        if (arr1 == null || arr2 == null){
            return false;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    //测试结果
    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            //生成数组
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }

        }
        System.out.println(succeed?"Nice!":"No");
    }

}
