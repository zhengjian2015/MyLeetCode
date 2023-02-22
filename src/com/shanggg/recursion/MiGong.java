package com.shanggg.recursion;

/**
 * 创建迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }

        //输出地图
        System.out.println("地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     *  使用递归回溯给小球找路
     *  说明
     *  1. map表示地图
     *  2. i,j 表示从地图的哪个位置开始出发 (1,1)
     *  3. 如果小球能到 map[6][5] 位置，说明道路能找到
     *  4. 约定 当map[i][j]   为0表示该点没有走过 当为1表示墙， 2表示道路可以走通，  3表示该点已经走过，但是走不通
     *  5. 在走迷宫时定一个策略， 下->右->上->左   如果该点走不通，再回溯
     *
     */
     public static boolean setWay(int[][] map,int i,int j) {
         if (map[6][5] == 2) {
             return true;
         } else {
             if(map[i][j]==0) {

             }
         }
     }

}
