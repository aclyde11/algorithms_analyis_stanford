package Union_Find;

/**
 * Created by austin on 9/2/16.
 */
public class UFTester {

    public static void main (String args[]) {

        //test quick find, union, weighted union
        WeightedQuickUnion qu = new WeightedQuickUnion(10);
        qu.union(1, 2);
        qu.union(2, 3);
        System.out.println(qu.connected(1, 3));


        //benchmark the three



        //Peroclation
        Percolation p = new Percolation(2);
        System.out.println(p.percolates());
        p.open(1, 1);
        System.out.println(p.percolates());
        p.open(1, 2);
        System.out.println(p.percolates());
        System.out.println(p.getLoc(1, 1) + " " + p.getLoc(1, 2));

        //check monte carlo accuracy
        PercolationStats s = new PercolationStats(200, 2000);
        System.out.println(s.mean() + "  {" + s.confidenceLo() + ", " + s.confidenceHi() + "}");






    }
}
