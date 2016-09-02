package Union_Find;
import java.util.Arrays;

/**
 * Created by austin on 9/2/16.
 */
public class WeightedQuickUnion {

    private int[] id;
    private int[] size;

    public WeightedQuickUnion (int N) {
        id = new int[N];
        size = new int[N];

        Arrays.fill(size, 1);
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    public void union (int p, int q) {
        int p_root = root(p);
        int q_root = root(q);

        if (p_root == q_root)
            return;

        if (size[p_root] < size[q_root]){
            id[p_root] = q_root;
            size[q_root] += size[p_root];
        } else {
            id[q_root] = p_root;
            size[p_root] += size[q_root];
        }
    }

    private int root (int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; //point node to grandparent
            i = id[i];
        }
        return i;
    }
}