import java.util.*;

public class Quick{
  public static int partition(int[] data, int start, int end){
  //  System.out.println(Arrays.toString(data));
    if (start >= end){
      return start;
    }
    int begin = start;
    int last = end;
    Random r = new Random();
    int pivot = (end + start) / 2;
    int pivotnum = data[pivot];
//    System.out.println("  " + "start " + start + "  " + "end " + end + " pivotn " + pivotnum);
    data[pivot] = data[start];
    data[start] = pivotnum;
    start += 1;
    if (start == end){
      if (data[begin] > data[end]){
        int temp = data[begin];
        data[begin] = data[start];
        data[start] = temp;
        return begin;
      }
    }
  //  System.out.println(Arrays.toString(data));
    while(start < end){
      if (data[start] > pivotnum){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end -= 1;
      }
      else if(data[start] == pivotnum && r.nextBoolean()){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        end -= 1;
      }
      else{
        start += 1;
      }
  //    System.out.println(Arrays.toString(data));

      if (end < data.length && data[end] < pivotnum){
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
        start += 1;
      }
      else if(data[end] == pivotnum && r.nextBoolean()){
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
        start += 1;
      }
      else{
        end -= 1;
      }
//      System.out.println(Arrays.toString(data));
    }
    int beg = begin;
    while (beg + 1<= last && data[beg + 1] <= pivotnum){
      beg += 1;
    }
    if (beg > last){
      beg = last;
    }
    int temp = data[beg];
    data[beg] = pivotnum;
    data[begin] = temp;
//    System.out.println(Arrays.toString(data));
//    System.out.print(end + " ");
    return beg;
  }
  public static int quickselect(int[] data,int k){
    int part = partition(data, 0, data.length - 1);
    while(part != k){
      if (part > k){
        part = partition(data, 0, part);
      }
      else{
        part = partition(data, part, data.length - 1);
      }
    }
    return data[part];
  }
  public static void quicksort(int[] data){
    quicksorth(data, 0, data.length - 1);
  }
  private static void quicksorth(int[] data, int low, int high){
    if (low >= high){
      return;
    }
    int pivot = partition(data, low, high);
    quicksorth(data, low, pivot - 1);
    quicksorth(data, pivot + 1, high);
  }/*
  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
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
        Quick.quicksort(data2);
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
}*/

  public static void main(String[]args){
    int[] data = new int[10];
    Random r = new Random();
    for (int i = 0; i < 10; i++){
      data[i] = r.nextInt(100);
    }
    int[] datat = new int[10];
    for(int t = 0; t < data.length;t++){
      datat[t] = data[t];
    }
    System.out.println(quickselect(data, 4));
    Arrays.sort(datat);
    quicksort(data);
    System.out.println(Arrays.toString(data));
    System.out.println(Arrays.equals(data, datat));
  }
}
