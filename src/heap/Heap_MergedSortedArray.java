package heap;
import java.util.*;

public class Heap_MergedSortedArray {

    public static class Entry {
        public int value;
        public int arrayId;

        public Entry(int value, int arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static List<Integer> merge(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>();
        int n = sortedArrays.size();

        PriorityQueue<Entry> heap = new PriorityQueue<>(n, Comparator.comparingInt(e -> e.value));

        for (int i = 0; i < n; i++) {
            iters.add(sortedArrays.get(i).iterator());
            if (iters.get(i).hasNext()) {
                heap.add(new Entry(iters.get(i).next(), i));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!heap.isEmpty()) {
            Entry entry = heap.poll();
            result.add(entry.value);
            Iterator<Integer> iter = iters.get(entry.arrayId);
            if (iter != null && iter.hasNext()) {
                heap.add(new Entry(iter.next(), entry.arrayId));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(1, 2, 3));
        sortedLists.add(Arrays.asList(1, 4, 5));
        sortedLists.add(Arrays.asList(0));
        System.out.println(merge(sortedLists));
    }
}
