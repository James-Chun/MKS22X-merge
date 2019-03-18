public class Merge{
    /*sort the array from least to greatest value. This is a wrapper function*/
    public static void mergesort(int[]data){
        mergeHelper(data,0,data.length-1);
    }

    private static void mergeHelper(int[] data, int lo, int hi){
        if (lo>=hi){
          return;
        }
        mergeHelper(data, lo, lo + ( (hi-lo)/2 )-1 );//mergesort left side
        mergeHelper(data, lo + ( (hi-lo)/2 ) , hi);//mergesort right side
        int index = 0;
        while ( !sorted(data,lo,hi) ){
          int temp = data[ ( (hi-lo)/2) + index ];
          for (int i=lo; i<(hi-lo)/2;i++){
            if (temp<data[i]){
              insert(data,i, (hi-lo)/2+index , temp);
            }
          }
          index++;
        }
    }

    private static boolean sorted(int[] data, int start, int end){
      for (int i=start;i<end+1;i++){
        if (data[i]>data[i+1])return false;
      }
      return true;
    }


    private static insert(int data, int start, int end, int value){
      int temp = data[start];
      for (int i=start+1;i<end+1;i++){

      }
    }

    public static void main(String[] args){
      int[] data = {0,1,2,3,4,5,6,7};
      int high = data.length;
      int low = 0;

      /*System.out.println("Low:"+low);
      System.out.println("High:"+high);
      while (low!=high){
        high=((high-low)/2)-1;
        System.out.println("Low:"+low);
        System.out.println("High:"+high);
      }
      */
      System.out.println(3/2);
    }

}
