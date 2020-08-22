package com.wz.time2.a26;

import java.util.Deque;
import java.util.LinkedList;

public class MinesweeperGame {
    /**
     * 扫雷游戏
     *
     * 让我们一起来玩扫雷游戏！
     *
     * 给定一个代表游戏板的二维字符矩阵。'M'代表一个未挖出的地雷，'E'代表一个未挖出的空方块，'B'代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X'则表示一个已挖出的地雷。
     *
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     *
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *
     *
     * 示例 1：
     *
     * 输入:
     *
     * [['E', 'E', 'E', 'E', 'E'],
     *  ['E', 'E', 'M', 'E', 'E'],
     *  ['E', 'E', 'E', 'E', 'E'],
     *  ['E', 'E', 'E', 'E', 'E']]
     *
     * Click : [3,0]
     *
     * 输出:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'M', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     *
     * 解释:
     *
     * 示例 2：
     *
     * 输入:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'M', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     *
     * Click : [1,2]
     *
     * 输出:
     *
     * [['B', '1', 'E', '1', 'B'],
     *  ['B', '1', 'X', '1', 'B'],
     *  ['B', '1', '1', '1', 'B'],
     *  ['B', 'B', 'B', 'B', 'B']]
     */

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        updateBoard(board, new int[]{3,0});
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                System.out.print(board[i][i1] + ", ");
            }
            System.out.println();
        }
    }

    static int[] xTe = {0, 0, 1, 1, -1, -1, -1, 1};

    static int[] yTe = {1, -1, 0, -1, 0, 1, -1, 1};

    /**
     * dfs如何实现
     * dfs的代码看上取就是简单很多，让人看着舒服，相对于bfs来说
     * 时间复杂度和空间复杂度都是 O(nm)  每个坐标点都只访问一次
     */
    public static char[][] updateBoard(char[][] board, int[] click) {
        int xLength = board.length;
        if (xLength == 0) {
            return board;
        }
        int yLength = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(xLength, yLength, board, click[0], click[1]);
        return board;
    }

    private static void dfs(int xLength, int yLength, char[][] board, int x, int y) {
        int num = 0;
        for (int i = 0; i < 8; i++) {
            int tempX = x + xTe[i];
            int tempY = y + yTe[i];
            if (tempX >= 0 && tempY >= 0 && tempX < xLength && tempY < yLength && board[tempX][tempY] == 'M') {
                num ++;
            }
        }
        if (num > 0) {
            board[x][y] = (char)(num + 48);
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tempX = x + xTe[i];
                int tempY = y + yTe[i];
                if (tempX >= 0 && tempY >= 0 && tempX < xLength && tempY < yLength && board[tempX][tempY] == 'E') {
                    dfs(xLength, yLength, board, tempX, tempY);
                }
            }
        }
    }

    /**
     * 先使用bfs做出来，再考虑dfs把
     * 时间复杂度和空间复杂度都是 O(nm)
     */
    /*public static char[][] updateBoard(char[][] board, int[] click) {
        Deque<int[]> deque = new LinkedList<>();
        int xLength = board.length;
        if (xLength == 0) {
            return board;
        }
        int yLength = board[0].length;
        boolean[][] visited = new boolean[xLength][yLength];
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        bfs(board, click,xLength, yLength, visited, deque);
        return board;
    }

    private static void bfs(char[][] board, int[] click, int xLength, int yLength, boolean[][] visited, Deque<int[]> deque) {
        deque.add(click);
        while (!deque.isEmpty()) {
            int dequeSize = deque.size();
            for (int i = 0; i < dequeSize; i++) {
                int[] poll = deque.poll();
                int x = poll[0];
                int y = poll[1];
                int num = 0;
                for (int i1 = 0; i1 < 8; i1++) {
                    int tempX = x + xTe[i1];
                    int tempY = y + yTe[i1];
                    if (tempX >= 0 && tempY >= 0 && tempX < xLength && tempY < yLength && board[tempX][tempY] == 'M') {
                        num ++;
                    }
                }
                if (num > 0) {
                    board[x][y] = (char)(num + 48);
                } else {
                    board[x][y] = 'B';
                    for (int i1 = 0; i1 < 8; i1++) {
                        int tempX = x + xTe[i1];
                        int tempY = y + yTe[i1];
                        if (tempX >= 0 && tempY >= 0 && tempX < xLength && tempY < yLength && board[tempX][tempY] == 'E' &&!visited[tempX][tempY]) {
                            deque.add(new int[]{tempX, tempY});
                            visited[tempX][tempY] = true;
                        }
                    }
                }
            }

        }
    }*/

}

