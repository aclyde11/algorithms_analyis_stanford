package Union_Find;

/**
 * Created by austin on 9/2/16.
 */
public class PercolationStats {

    private double[] thres;
    private int n;

    public PercolationStats(int N, int num_trials) {
        thres = new double[num_trials];
        n = N;

        run_trials();
    }

    private void run_trials () {
        for (int i = 0; i < thres.length; i++) {
            Percolation p = new Percolation(n);
            int open  = 0;
            while (!p.percolates()) {
                int randx = (int) (n * Math.random() + 1);
                int randy = (int) (n * Math.random() + 1);
                if (!p.isOpen(randx, randy)) {
                    p.open(randx, randy);
                    open++;
                }
            }
            System.out.println(open);
            thres[i] = ((double) open) / (n * n);
        }
    }

    public double mean () {
        double sum = 0;
        for (int i = 0; i < thres.length; i++) {
            sum += thres[i];
        }
        return sum / thres.length;
    }

    public double stddev () {
        double sum = 0;
        double avg = mean();
        for (int i = 0; i < thres.length; i++) {
            sum += Math.pow(thres[i] - avg, 2);
        }
        return Math.sqrt(sum / (thres.length-1));
    }

    public double confidenceLo () {
        return mean() - (1.69*stddev())/Math.sqrt(thres.length);
    }

    public double confidenceHi () {
        return mean() + (1.69*stddev())/Math.sqrt(thres.length);
    }
}
