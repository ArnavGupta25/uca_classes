// package practice_problems;
// @SuppressWarnings("all") // This can help suppress some warnings

import java.util.*;
import java.util.PriorityQueue;

public class VerticalTree {
    int val;
    VerticalTree left;
    VerticalTree right;
    VerticalTree() {}
    VerticalTree(int val) { this.val = val; }
    VerticalTree(int val, VerticalTree left, VerticalTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    class TreeNodePosition {
        VerticalTree node;
        int row;
        int col;
        
        TreeNodePosition(VerticalTree node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(VerticalTree root) {
        if (root == null) {
            return new ArrayList<>();
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<TreeNodePosition> q = new LinkedList<>();
        q.offer(new TreeNodePosition(root, 0, 0));
    
        while (!q.isEmpty()) {
            TreeNodePosition curr = q.poll();
            VerticalTree node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                q.offer(new TreeNodePosition(node.left, row + 1, col - 1));
            }
            
            if (node.right != null) {
                q.offer(new TreeNodePosition(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        
        for (TreeMap<Integer, PriorityQueue<Integer>> column : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> row : column.values()) {
                while (!row.isEmpty()) {
                    colList.add(row.poll());
                }
            }
            result.add(colList);
        }
        
        return result;
    }
}