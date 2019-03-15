import java.util.*;

public class Quick{
  public static int partition(int[] data, int start, int end){
    if (start == end){
      return start;
    }
    int begin = start;
    int last = end;
    Random r = new Random();
    int pivot = r.nextInt((end - start) + 1) + start;
    int pivotnum = data[pivot];
    data[pivot] = data[0];
    data[start] = pivotnum;
    start += 1;
//    for (int k = 0; k < data.length; k++){
//      System.out.print(data[k] + " ");
  //  }
//    System.out.println();
    while(start < end){
      if (data[start] > pivotnum){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end -= 1;
      }
      else{
        start += 1;
      }
  //    for (int p = 0; p < data.length; p++){
  //      System.out.print(data[p] + " ");
  //    }
  //    System.out.println();
      if (start < end){
        if (data[end] < pivotnum){
          int temp = data[end];
          data[end] = data[start];
          data[start] = temp;
          start += 1;
        }
        else{
          end -= 1;
        }
      }
//      for (int o = 0; o < data.length; o++){
//        System.out.print(data[o] + " ");
  //    }
  //    System.out.println();
    }
  //  System.out.print(" "+ pivotnum + " ");
    if (start == begin){
      return start;
    }
    if (data[start] < pivotnum){
      int temp = data[start];
      data[start] = pivotnum;
      data[begin] = temp;
      return start;
    }
    else{
      int temp = data[start - 1];
      data[start - 1] = pivotnum;
      data[begin] = temp;
      return start - 1;
    }
  }
  public static void quicksort(int[] data){
    quicksorth(data, 0, data.length - 1);
  }
  private static void quicksorth(int[] data, int low, int high){
    if (low >= high){
  //    int temp = data[data.length - 1];
  //    data[data.length - 1] = data[data.length - 2];
    //  data[data.length - 2] = temp;
      return;
    }
    int pivot = partition(data, low, high);
  //  System.out.println(Arrays.toString(data));
    quicksorth(data, low, pivot - 1);
  //  System.out.println(Arrays.toString(data));
    quicksorth(data, pivot + 1, high);
  //  System.out.println(Arrays.toString(data));
  }
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {100,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 10; size < 2000001; size*=2){
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
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
    //    System.out.println(Arrays.toString(data1));
        System.out.println(Arrays.toString(data2));
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
  }
}
