// Priority queue use cases
// utility data structure 
// A* search
// Graph theory
// computing system

// not implemented as a tree
// just tree helps in visualisation
// it is a balanced binary tree

public class PriorityQueue {
    private Integer[] pq;
    private int n; //by default value of integers is 0 in java

    public PriorityQueue(int capacity) {
        this.pq = new Integer[capacity+1];
    }

    public void insert(int m) {
        this.pq[++n] = m;
        this.swim(this.n);
    }

    public Integer maxDel() {
        Integer maxP = this.pq[1];
        this.pq[1] = this.pq[n--];
        this.pq[n+1] = null; // loitering
        this.sink(1);
        return maxP;    
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public Integer size() {
        return this.n;
    }

    private void exch(int i, int j) {
        int temp = this.pq[i];
        this.pq[i] = this.pq[j];
        this.pq[j] = temp;
    }

    private void swim(int k) {
        while(k > 1 && pq[k/2] < pq[k]) {
            this.exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while(2*k <= this.n) {
            int j = 2*k;
            if(j < this.n && this.pq[j] < this.pq[j+1]) j++;
            if(this.pq[k] >= this.pq[j]) break;
            this.exch(k ,j);
            k = j;
        }
    }

    public static void main(String args[]) {
        PriorityQueue pQueue = new PriorityQueue(10);

        pQueue.insert(10);
        pQueue.insert(9);
        pQueue.insert(7);
        pQueue.insert(11);

        assert pQueue.maxDel() == 11;
        assert pQueue.size() == 3;

        pQueue.insert(15);
        pQueue.insert(16);
        pQueue.insert(1);

        assert pQueue.maxDel() == 16;
    }
}
