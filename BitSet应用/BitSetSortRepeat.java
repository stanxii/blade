// 使用BitSet实现O(n)排序算法, 数组包含重复数值

import java.util.BitSet;
public class BitSetSortRepeat{
    public static void main(String[] args) {
        sort();
    }
    public static void sort(){
        int[] arr = new int[]{2,1,7,6,2,3,5,2,6};
        Map<Integer,Integer> count = new ConcurrentHashMap<Integer,Integer>(arr.length);    //增加一个Map对象存储
        int max = max(arr);
        System.out.println(max);
        BitSet bitSet = new BitSet(max);
        //初始化bitSet,默认为false，可以不设置
        for(int i=0;i<bitSet.length();i++){
             bitSet.set(i,false);
        }
        for(int j=0;j<arr.length;j++){
             bitSet.set(arr[j],true);
      
             if (count.containsKey(arr[j])){
                 count.put(arr[j],count.get(arr[j])+1);
            }else{
                 count.put(arr[j],1);
            }
       }
        Set<Map.Entry<Integer,Integer>> sets = count.entrySet(); 
        for(Map.Entry<Integer,Integer> entry:sets){
          if(entry.getValue() == 1){
           count.remove(entry.getKey());    //遍历Map，将只出现一次的删除掉
          }
        }  
       int i=0;
        for(int k=0;k<bitSet.length();k++){
          if(bitSet.get(k)){
              if(!sets.isEmpty()){
                  if (count.containsKey(k)){   //若Map集合包含有出现1次以上的数值，则按出现的次数进行操作
                     int cc = count.get(k);
                      for(int j=0;j<cc;j++){
                         arr[i++] = k;
                      }
                     count.remove(k);    //将已经处理过的移除
                  }else{
                        arr[i++] = k;
                  }
              }else{
                 arr[i++] = k;
              }
          }
        }
      System.out.println(Arrays.toString(arr));
     }
      
     private static int max(int[] arr){
      int max = 0;
      for(int item:arr){
        if(item>max){
          max = item;
        }
      }
      return max;
     }
}