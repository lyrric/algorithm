package com.demo.algorithm.bfs;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static com.demo.algorithm.bfs.Map.*;

/**
 * Created on 2018/12/18.
 *
 * @author wangxiaodong
 */
public class App {

    /**
     * 地图上各点到起点的距离
     */
    private int[][] dis = new int[WIDTH+2][HEIGHT+2];
    /**
     * 起点
     */
    private Point startP = new Point(1,1);
    /**
     * 终点
     */
    private Point endP = new Point(6,7);
    /**
     * 4个方向移动的向量
     */
    private int[] dx={1,0,-1,0};
    private int[] dy={0,1,0,-1};

    /**
     * 输出最短路径
     */
    public List<Point> getShortestPath(){
        if(findPath()){
            List<Point> path = new ArrayList<>(dis[endP.x][endP.y]);
            //加入终点
            path.add(endP);
            Point p = endP;
            for(int i = 0;i<dis[endP.x][endP.y];i++){
                for(int j = 0;j<4;j++){
                    if(dis[p.x+dx[j]][p.y+dy[j]] == dis[p.x][p.y]-1){
                        p = new Point(p.x+dx[j],p.y+dy[j]);
                        path.add(p);
                        break;
                    }
                }
            }
            Collections.reverse(path);
            return path;

        }
        return null;
    }
    /**
     * bfs寻路
     * @return 是否寻路成功
     */
    private boolean findPath() {
        Map map = new Map();
        boolean flag = false;
        Queue<Point> queue = new LinkedBlockingQueue<>();
        //将起点放入队列
        queue.add(startP);
        //循环遍历
        while(queue.size() != 0){
            //取出头
            Point p = queue.remove();
            if(p.equals(endP)){
                flag = true;
                break;
            }
            //向四个方向探寻
            for(int i=0; i<4;i++){
                Point nextP = new Point(p.x+dx[i], p.y+dy[i]);
                //下一个坐标是否可以移动
                if(map.getPoint(nextP.x, nextP.y) == EMPTY && dis[nextP.x][nextP.y] == 0 && !nextP.equals(startP)){
                    queue.add(nextP);
                    dis[nextP.x][nextP.y] = dis[p.x][p.y]+1;
                }
            }
        }
        System.out.println("    地图到起点距离图");
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(String.format("% 4d", dis[i][j]));
            }
            System.out.println();
        }
        return flag;
    }

}
