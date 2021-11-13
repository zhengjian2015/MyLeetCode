package com.myleetcode.no00347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 使用优先队列 能达到 O(nlog(k)的时间复杂度
 *
 * PriorityQueue是优先队列，作用是保证每次取出的元素都是队列中权值最小的，
 * 这里涉及到了大小关系，元素大小的评判可以通过元素自身的自然顺序（使用默认的比较器），
 * 也可以通过构造时传入的比较器。
 *
 * 技巧是要记得 queue里只保持着 k 个元素
 *
 * Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 */
public class Solution2 {

    private  class Pair implements Comparable<Pair> {

        private int num,freq;

        public Pair(int num,int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair another) {
            return this.freq - another.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int x : nums) {
            map.put(x, map.get(x) == null ? 0 : map.get(x) + 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for(int key : map.keySet()) {
            int numFlag = map.get(key);
            if(queue.size() == k && numFlag > queue.peek().freq)
                queue.poll();
            if(queue.size() < k) {
                queue.add(new Pair(key,numFlag));
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(!queue.isEmpty()) {
            res[i++] = (queue.poll().num);
        }
        return res;
    }
}
