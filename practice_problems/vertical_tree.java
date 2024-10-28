package practice_problems;
// @SuppressWarnings("all") // This can help suppress some warnings

import java.util.*;

public class vertical_tree {
    int val;
    vertical_tree left;
    vertical_tree right;
    vertical_tree() {}
    vertical_tree(int val) { this.val = val; }
    vertical_tree(int val, vertical_tree left, vertical_tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    class Pair {
        vertical_tree node;
        int row;
        int col;
        
        Pair(vertical_tree node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(vertical_tree root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
    
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            vertical_tree node = curr.node;
            int row = curr.row;
            int col = curr.col;

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, row + 1, col - 1));
            }
            
            if (node.right != null) {
                q.offer(new Pair(node.right, row + 1, col + 1));
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