package Union_Find;

/**
 * Created by austin on 9/2/16.
 */
public class QuickUnion {

    private int[] id;

    public QuickUnion (int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void union (int p, int q) {
        int p_root = root(p);
        int q_root = root(q);

        if (p_root == q_root)
            return;

        id[p_root] = q_root;
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    protected int root (int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
}