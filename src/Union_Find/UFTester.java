package Union_Find;

/**
 * Created by austin on 9/2/16.
 */
public class UFTester {

    public static void main (String args[]) {

        //test quick find, union, weighted union

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
        PercolationStats s = new PercolationStats(20, 200);
        System.out.println(s.mean() + "  {" + s.confidenceLo() + ", " + s.confidenceHi() + "}");






    }
}
