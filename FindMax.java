public class FindMax {
    public static int findMax(int[] arr) {
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    public static void Sort(int[] arr) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count1++;
            }
            if (arr[i] == 2) {
                count2++;
            } else
                count3++;
        }

        for (int i = 0; i < count1; i++) {
            arr[i] = 1;
        }
        for (int i = count1; i < count1 + count2; i++) {
            arr[i] = 2;
        }
        for (int i = count1 + count2; i < count2 + count3; i++) {
            arr[i] = 3;
        }
    }
    
    public static int maxsum(int[] arr) {
        int currentmax = arr[0];
        int lastmax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentmax = Math.max(arr[i], currentmax + arr[i]);
            lastmax = Math.max(currentmax, lastmax);
        }

        return lastmax;
    }
    
    public static void main(String[] args) {
        int[] arr = { 2, -1, 3, 4, -6, 7, -9, 8 };
        System.out.println(findMax(arr));
        // Sort(arr);

        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }
        
        // System.out.println("");

       System.out.println(maxsum(arr)); 


    }
}