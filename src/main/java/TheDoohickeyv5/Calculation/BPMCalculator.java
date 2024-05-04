package TheDoohickeyv5.Calculation;

import TheDoohickeyv5.Objects.Distance;

import java.util.*;

public class BPMCalculator extends Calculator<Distance> {
    Map<Integer, Integer> mappedMs = new HashMap<>();
    final double bpmThreshold = 0.1;

    public BPMCalculator(Collection<Distance> data) {
        super(data);
    }

    private void setUpBpmValues(Map<Integer, Integer> mappedMs){
        for (Distance d : data) {
            int ms = d.getMs();
            if (!d.isLongJump()) {
                ms *= 2;
            }
            if (mappedMs.containsKey(ms)) {
                mappedMs.put(ms, mappedMs.get(ms) + 1);
            }
            else
                mappedMs.put(ms, 1);
        }
    }

    @Override
    public double calculate() {
        setUpBpmValues(mappedMs);
        List<Integer> bpmList = getBpmCandidates();
        return 30000.0/average(bpmList);
    }

    private List<Integer> getBpmCandidates() {
        List<Integer> bpmReferences = new ArrayList<>();
        int maximum = Integer.MIN_VALUE;
        while (true) {
            int nextValue = getMaxValue();
            if (maximum == Integer.MIN_VALUE || isInRange(nextValue, maximum, bpmThreshold)) {
                bpmReferences.add(nextValue);
                maximum = nextValue;
            }
            else
                break;
            mappedMs.remove(nextValue);
        }
        return bpmReferences;
    }

    private int getMaxValue() {
        int maxValue = -1;
        int maxKey = -1;
        for (Map.Entry<Integer, Integer> entry : mappedMs.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    private boolean isInRange(int value, int reference, double threshold){
        return value > reference * (1 - threshold) && value < reference * (1 + threshold);
    }

    private double average(List<Integer> integerList){
        if (integerList.isEmpty())
            return 0;

        double sum = 0;
        for (int i : integerList) {
            sum += i;
        }
        return sum/integerList.size();
    }
}
