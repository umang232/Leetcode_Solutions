class AllOne {
    HashMap<String, Integer> countMap;
    HashMap<Integer, LinkedHashSet<String>> freqMap;
    int minFreq;
    int maxFreq;

    public AllOne() {
        countMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = Integer.MAX_VALUE;
        maxFreq = Integer.MIN_VALUE;
    }

    public void inc(String key) {
        int freq = countMap.getOrDefault(key, 0);
        countMap.put(key, freq + 1);

        if (freq > 0) {
            freqMap.get(freq).remove(key);
            if (freqMap.get(freq).isEmpty()) {
                freqMap.remove(freq);
                if (freq == minFreq) minFreq++;
                if (freq == maxFreq) maxFreq = freq + 1;
            }
        }

        freqMap.computeIfAbsent(freq + 1, x -> new LinkedHashSet<>()).add(key);
        minFreq = Math.min(minFreq, freq + 1);
        maxFreq = Math.max(maxFreq, freq + 1);
    }

    public void dec(String key) {
        if (!countMap.containsKey(key)) return;

        int freq = countMap.get(key);
        freqMap.get(freq).remove(key);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (freq == minFreq) {
                // Recalculate minFreq
                minFreq = Integer.MAX_VALUE;
                for (int f : freqMap.keySet()) {
                    minFreq = Math.min(minFreq, f);
                }
                if (freqMap.isEmpty()) {
                    minFreq = Integer.MAX_VALUE;
                    maxFreq = Integer.MIN_VALUE;
                }
            }
            if (freq == maxFreq) {
                maxFreq--;
            }
        }

        if (freq == 1) {
            countMap.remove(key);
        } else {
            countMap.put(key, freq - 1);
            freqMap.computeIfAbsent(freq - 1, x -> new LinkedHashSet<>()).add(key);
            minFreq = Math.min(minFreq, freq - 1);  // <== key fix
        }
    }

    public String getMaxKey() {
        if (maxFreq == Integer.MIN_VALUE || !freqMap.containsKey(maxFreq) || freqMap.get(maxFreq).isEmpty()) return "";
        return freqMap.get(maxFreq).iterator().next();
    }

    public String getMinKey() {
        if (minFreq == Integer.MAX_VALUE || !freqMap.containsKey(minFreq) || freqMap.get(minFreq).isEmpty()) return "";
        return freqMap.get(minFreq).iterator().next();
    }
}
