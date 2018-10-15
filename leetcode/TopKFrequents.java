public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, 1);
            else
                map.put(num, (int) (map.get(num)) + 1);
        }
        int len = map.size();
        Entry<Integer, Integer>[] entrys = new Entry[len + 1];
        Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
        for (int i = 1; i <= len; i++)
            entrys[i] = (Entry<Integer, Integer>) it.next();

        for (int i = len / 2; i >= 1; i--) {
            adjust(entrys, len, i);
        }
        for (int i = 1; i <= k; i++) {
            res.add((Integer) entrys[1].getKey());
            entrys[1] = entrys[len];
            len--;
            adjust(entrys, len, 1);
        }
        return res;
    }

    public void adjust(Entry<Integer, Integer>[] entrys, int len, int i) {
        int k;
        entrys[0] = entrys[i];
        for (k = i * 2; k <= len; k *= 2) {
            if (k + 1 <= len && entrys[k].getValue() < entrys[k + 1].getValue())
                k = k + 1;
            if (entrys[0].getValue() < entrys[k].getValue()) {
                entrys[i] = entrys[k];
                i = k;
            } else
                break;
        }
        entrys[i] = entrys[0];
    }
}