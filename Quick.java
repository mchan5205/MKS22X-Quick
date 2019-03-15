import java.util.*;

public class Quick{
  public static int partition(int[] data, int start, int end){
    System.out.println(Arrays.toString(data));
    if (start >= end){
      return start;
    }
    int begin = start;
    int last = end;
    Random r = new Random();
    int pivot = r.nextInt((end - start) + 1) + start;
    int pivotnum = data[pivot];
    System.out.println("  " + "start " + start + "  " + "end " + end + " pivotn " + pivotnum);
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
    System.out.println(Arrays.toString(data));
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
      System.out.println(Arrays.toString(data));

      if (end < data.length && data[end] < pivotnum){
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
        start += 1;
      }
      else{
        end -= 1;
      }
      System.out.println(Arrays.toString(data));
    }
    int beg = begin;
    while (beg + 1<= last && data[beg + 1] < pivotnum){
      beg += 1;
    }
    if (beg > last){
      beg = last;
    }
    int temp = data[beg];
    data[beg] = pivotnum;
    data[begin] = temp;
    System.out.println(Arrays.toString(data));
    System.out.print(end + " ");
    return beg;
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
  }

  public static void main(String[]args){
    int[] data = new int[10];
    Random r = new Random();
    for (int i = 0; i < 10; i++){
      data[i] = r.nextInt(100);
    }
    quicksort(data);
    System.out.println(Arrays.toString(data));
  }
}
