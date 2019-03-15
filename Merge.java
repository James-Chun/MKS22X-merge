public class Merge{
    /*sort the array from least to greatest value. This is a wrapper function*/
    public static void mergesort(int[]data){
        mergesort(data,0,data.length-1);
    }

    private static void mergeHelper(int[] data, int lo, int hi){
        if (lo>=hi){
          return;
        }

        //mergesort left side
        //mergesort right side
        //merge
    }
}
