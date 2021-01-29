package greedy;

import java.util.*;

/**
 * Sort engineer by efficiency desc and iterate through
 * This is because as we iterate we know that current engineer has lwest efficiency
 * at the same time, maintain the top k in terms of speed using priority queue
 */
public class MinPerformanceTeam {
    public class Engineer {
        public int speed;
        public int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public String toString() {
            return "s=" + speed + ",e=" + efficiency;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> sortedByEfficiencyDesc = new ArrayList<>();

        int mod = (int) Math.pow(10,9) + 7;

        for (int i = 0; i < speed.length; i++) {
            sortedByEfficiencyDesc.add(new Engineer(speed[i], efficiency[i]));
        }

        Collections.sort(sortedByEfficiencyDesc, (x, y) -> Integer.compare(y.efficiency, x.efficiency));

        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>(k, Comparator.comparingInt(x -> x.speed));

        long teamSpeed = 0;
        long result = 0;

        for (Engineer engineer: sortedByEfficiencyDesc) { // s 1, e 9
            if (currentTeam.size() == k) {
                Engineer slowest = currentTeam.poll();
                teamSpeed -= slowest.speed;
            }
            currentTeam.add(engineer);
            teamSpeed += engineer.speed;

            //we know that new engineer has the lowest efficiency
            long performanceWithNewGuy = teamSpeed * (long) engineer.efficiency; // NEED TO CAST TO LONG HERE
            result = Math.max(result, performanceWithNewGuy);
        }
        //NEED TO CAST (result % mod) to int.
        // DON'T WRITE (int) result % mod as it will cast result to int
        return (int) (result % mod);
    }
}
