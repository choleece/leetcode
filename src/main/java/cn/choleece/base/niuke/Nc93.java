package cn.choleece.base.niuke;

import java.util.*;

/**
 * @author choleece
 * @Description: 设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * [要求]
 * set和get方法的时间复杂度为O(1)
 * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
 * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 * 对于每个操作2，输出一个答案
 * @Date 2020-10-28 21:44
 **/
public class Nc93 {

    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public static int[] LRU (int[][] operators, int k) {
        // write code here
        List<Integer> result = new ArrayList<Integer>();

        if (operators == null || operators.length == 0) {
            return new int[] {};
        }
        LRUCache cache = new LRUCache(k);
        for(int i = 0; i < operators.length; i++) {
            int keyLen = operators[i].length;
            if (keyLen == 3) {
                cache.set(operators[i][1], operators[i][2]);
            }
            if (keyLen == 2) {
                Integer val = cache.get(operators[i][1]);
                if (val != null) {
                    result.add(val);
                }
            }
        }

        if (result.size() == 0) {
            return new int[] {};
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }



    static class LRUCacheSelf {
        private HashMap<Integer, Integer> map = new HashMap();
        private LinkedList<Integer> list = new LinkedList();
        private int size;

        public LRUCacheSelf(int size) {
            this.size = size;
        }

        public int get(Integer key) {
            updateKeyIdx(key);
            return map.getOrDefault(key, -1);
        }

        public void set(Integer key, Integer val) {
            if (map.size() < size || map.containsKey(key)) {
                updateKeyIdx(key);
            } else {
                // 个数达到上限
                Integer last = updateKeyIdx(key);
                if (last != null) {
                    map.remove(last);
                }
            }
            map.put(key, val);
        }

        public Integer updateKeyIdx(Integer key) {
            Integer fist = list.peekFirst();
            // 如果第一是自己，则不用操作
            if (fist != null && fist.equals(key)) {
                return null;
            }
            Integer last = null;
            // 先将自身删除
            list.remove(key);
            if (list.size() == size) {
                // 需要将最后一个删除
                last = list.removeLast();
            }
            list.addFirst(key);
            return last;
        }
    }

    /**
     * 利用linked hash map来实现
     */
    static class LRUCache extends LinkedHashMap<Integer,Integer>  {
        private int capacity;

        public LRUCache(int capacity) {
            // access order 顺序保证最近操作到移动到最后
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void set(int key, int value) {
            super.put(key,value);
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
            return size() > capacity;
        }
    }

    public static void main(String[] args) {
        int[][] operators = {
                {1,1,1},
                {1,2,2},
                {1,3,2},
                {2,1},
                {1,4,4},
                {2,2}
        };

        int[] arr = LRU(operators, 4);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

}
