package Union_Find;

/**
 * Created by austin on 9/2/16.
 */
public class Percolation {

    private WeightedQuickUnion uf;
    private boolean[] site;
    private int n;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Must be greater than zero");
        }
        n = N;
        site = new boolean[N * N + 2];
        uf = new WeightedQuickUnion(N * N + 2);

        //open top and bottom node
        site[0] = true;
        site[site.length - 1] = true;
    }


    public void open(int x, int y) {
        int loc = getLoc(x, y);
        site[loc] = true;

        //connect adj open sites
        if (y == 1) {
            uf.union(0, loc); //cpnnect to top
        } else if (site[loc - n]) {
            uf.union(loc, loc - n);
        }

        if (y == n) {
            uf.union(n + 1, loc); //connect to bottom
        } else if (site[loc + n]) {
            uf.union(loc, loc + n);
        }

        if (x != 1 && site[loc - 1]) {
            uf.union(loc, loc - 1);
        }

        if (x != n && site[loc + 1]) {
            uf.union(loc, loc + 1);
        }
    }

    public boolean isOpen(int x, int y) {
        return site[getLoc(x, y)];
    }

    public boolean isFull(int x, int y) {
        return uf.connected(0, getLoc(x, y));
    }

    public boolean percolates() {
        return uf.connected(0, n + 1);
    }

    public int getLoc(int x, int y) {
        if (x < 1 || y < 1 || x > n || y > n) {
            throw new IndexOutOfBoundsException("Grid is between 1 and " + n);
        }
        return (y-1) * n + x;
    }
}
