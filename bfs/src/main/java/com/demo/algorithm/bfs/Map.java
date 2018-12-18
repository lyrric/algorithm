package com.demo.algorithm.bfs;

/**
 * Created on 2018/12/18.
 *
 * @author wangxiaodong
 */
public class Map {
    /**
     * 墙
     */
    public static int WALL = 0;
    /**
     * 空
     */
    public static int EMPTY = 1;
    /**
     * 地图宽
     */
    public static final int WIDTH = 8;
    /**
     * 地图高
     */
    public static final int HEIGHT = 8;
    /**
     * 地图
     */
    private int[][] map = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0},
            {0,1,1,0,1,0,1,0,1,0},
            {0,1,0,1,0,0,1,0,1,0},
            {0,1,1,0,1,0,0,0,1,0},
            {0,1,1,1,1,1,1,0,1,0},
            {0,0,0,0,1,1,1,1,1,0},
            {0,1,1,1,1,0,1,1,1,0},
            {0,1,1,1,1,0,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0},
    };
    public int getPoint(int x, int y){
        return map[x][y];
    }
}
