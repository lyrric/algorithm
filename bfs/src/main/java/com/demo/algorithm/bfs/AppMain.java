package com.demo.algorithm.bfs;

import java.awt.*;
import java.util.List;

/**
 * Created on 2018/12/18.
 *
 * @author wangxiaodong
 */
public class AppMain {
    public static void main(String[] args)  {
        List<Point> path = new App().getShortestPath();
        System.out.println();
        path.forEach(point -> {
            System.out.print("("+point.x+","+point.y+")->");
        });
    }
}
