import java.util.*;

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


    private static void merge(int[] data, int lo, int hi) {
      int leftArraySize = (hi-lo)/2 + 1;
      int rightArraySize = hi - (hi+lo)/2;

      int[] leftArray = new int[leftArraySize];
      int[] rightArray = new int[rightArraySize];


      for (int i = 0; i < rightArraySize; i++) {
        rightArray[i] = data[(hi+lo)/2+i+1];
      }
      for (int i = 0; i < leftArraySize; i++) {
        leftArray[i] = data[lo + i];
      }


      int indexL = 0;
      int indexR = 0;
      int index = lo;
      /*
      while (indexL+indexR < rightArraySize + leftArraySize) {
          if (indexL < leftArraySize && leftArray[indexL] <= rightArray[indexR]) {
            data[index] = leftArray[indexL];
            indexL++;
          }
          else if (indexR < rightArraySize && rightArray[indexR] > leftArray[indexL]) {
            data[index] = rightArray[indexR];
            indexR++;
          }
          else if (indexL < leftArraySize){
            data[index] = leftArray[indexL];
            indexL++;
          }
          else if (indexR < rightArraySize){
            data[index] = rightArray[indexR];
            indexR++;
          }
          index++;
      }*/
      while (indexR < rightArraySize && indexL < leftArraySize) {
          if (leftArray[indexL] <= rightArray[indexR]) {
            data[index] = leftArray[indexL];
            indexL++;
          } else {
            data[index] = rightArray[indexR];
            indexR++;
          }
          index++;
      }
      while (indexL < leftArraySize) {
        data[index] = leftArray[indexL];
        indexL++;
        index++;
      }

      while (indexR < rightArraySize) {
        data[index] = rightArray[indexR];
        indexR++;
        index++;
      }
    }

/*
    private static void merge(int[] data, int lo, int hi){
      for (int i=(hi+lo)/2+1;i<hi+1 && !sorted(data,lo,hi);i++ ){
        boolean justinserted = false;
        int temp = data[i];
        for (int i2=lo; i2<((hi+lo)/2)+1+i && !sorted(data,lo,hi) && !justinserted;i2++){
          //System.out.println(visual(data));
          if (temp<data[i2]){
            insert(data,i2,i,temp);
            justinserted = true;
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
        int temp2 = data[i];
        data[i]=value;
        value=temp2;
      }
    }*/

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

    /*public static void main(String[] args){
      int[] data = {25, 10, 1 , -2};
      int high = data.length;
      int low = 0;

      /*System.out.println("Low:"+low);
      System.out.println("High:"+high);
      while (low!=high){
        high=((high-low)/2)-1;
        System.out.println("Low:"+low);
        System.out.println("High:"+high);
      }

      //insert(data,0,4,3);

      //System.out.println(visual(data));
      mergesort(data);
      System.out.println(visual(data));

    }*/
    public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tMerge/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
    // int[] data = new int[] {4, 23, 234, 345, 1, 3 , 54, 234, 134, 3254, 13, 999, 28};
    // mergesort(data);
    // System.out.println(Arrays.toString(data));
  }

}
