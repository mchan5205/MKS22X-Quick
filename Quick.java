import java.util.*;

public class Quick{
  public int partition(int[] data, int start, int end){
    int begin = start;
    int last = end;
    Random r = new Random();
    int pivot = r.nextInt((end - start) + 1) + start;
    int pivotnum = data[pivot];
    data[pivot] = data[0];
    data[start] = pivotnum;
    start += 1;
    while(start != end){
      if (data[start] > pivotnum){
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
        start += 1;
      }
      if (data[end] < pivotnum){
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
        end -= 1;
      }
    }
    int temp = data[start - 1];
    data[start - 1] = pivotnum;
    data[begin] = temp;
    return start - 1;
  }
}
