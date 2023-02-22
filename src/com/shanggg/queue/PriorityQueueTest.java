package com.shanggg.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 *
 * 优先队列 解决 取k个最小数的问题
 * 排序最好的算法是  nlogn 的时间复杂度
 * 但是优先队列能做到  nlogk 的时间复杂度
 *
 * 通过看答案 前k个高频单词，发现重点其实是 重写比较器
 *
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 9, 3, 2, 5, 11};
        int k = 3;
        /*PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int k = 3;
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (q.peek() > arr[i]) {
                q.poll();
                q.add(arr[i]);
            }
        }

        int[] res = new int[k];
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
*/

        //或者这种写法
        Queue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->o2-o1);
        for(int i = 0 ; i < arr.length ; i++) {
            /*if(queue.size() < k) {
                queue.add(arr[i]);
            } else {
                System.out.println(queue.peek());
                if(queue.peek() > arr[i]) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }*/
            queue.offer(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

}
