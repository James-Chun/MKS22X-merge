public class Merge{
    /*sort the array from least to greatest value. This is a wrapper function*/
    public static void mergesort(int[]data){
        mergeHelper(data,0,data.length-1);
    }

    private static void mergeHelper(int[] data, int lo, int hi){
        if (lo>=hi){
          return;
        }
        mergeHelper(data, lo, (hi+lo)/2 );//mergesort left side
        mergeHelper(data, (hi+lo)/2+1 , hi);//mergesort right side
        merge(data,lo,hi);
    }

    private static void merge(int[] data, int lo, int hi){
      for (int i=(hi+lo)/2+1;i<hi+1 && !sorted(data,lo,hi);i++ ){
        int temp = data[i];
        for (int i2=0;i2<(hi+lo)/2+1 && !sorted(data,lo,hi);i2++){
          //System.out.println(visual(data));
          if (temp<data[i2]){
            insert(data,i2,i,temp);
          }
        }
      }
    }

    private static boolean sorted(int[] data, int start, int end){//works
      for (int i=start;i<end;i++){
        if (data[i]>data[i+1])return false;
      }
      return true;
    }


    private static void insert(int[ ]data, int start, int end, int value){//works

      for (int i=start;i<end+1;i++){
        int temp = data[i];
        data[i]=value;
        value=temp;
      }
    }

    public static String visual(int[] data){ //works
      String visual = "[";
      for (int i=0;i<data.length;i++){
        visual += data[i];
        if (i<data.length-1){
           visual += ", ";
        }
      }
      return visual +"]";
    }

    public static void main(String[] args){
      int[] data = {3,2,2,0,4,1,45,5,123,2};
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
      //insert(data,0,4,3);

      //System.out.println(visual(data));
      mergesort(data);
      System.out.println(visual(data));

    }

}
