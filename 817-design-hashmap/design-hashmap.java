class MyHashMap {
    
    private final class InnerHashMap {
        
        final class Entry {
            int key;
            int value;
        }
        
        final class Bucket {
            List<Entry> entries;
            InnerHashMap innerMap;
            
            boolean isEmpty() {
                return (this.entries == null || this.entries.isEmpty()) && 
                    (this.innerMap == null || this.innerMap.isEmpty());
            }
        }
        
        private Bucket[] buckets;
        private int base;
        
        InnerHashMap(int base) {
            this.base = base;
            this.buckets = new Bucket[base];
        }
        
        private int calcHash(int key) {
            return key % base;
        }
        
        boolean isEmpty() {
            for (Bucket bucket : buckets) {
                if (bucket != null) {
                    return false;
                }
            }
            
            return true;
        }
        
        void put(int key, int value) {
            
            final var hash = calcHash(key);
            final var currentBucket = buckets[hash];
            
            if (currentBucket != null) {
                
                if (currentBucket.innerMap != null) {
                    currentBucket.innerMap.put(key, value);
                    return;
                }
                
                if (currentBucket.entries.size() < 10) {
                    
                    for (Entry entry : currentBucket.entries) {
                        if (entry.key != key) {
                            continue;
                        }
                            
                        entry.value = value;
                        return;
                    }
                    
                    final var newEntry = new Entry();
                    newEntry.key = key;
                    newEntry.value = value;
                    
                    currentBucket.entries.add(newEntry);
                    return;
                }
                
                final var innerMap = new InnerHashMap(base / 2);
                
                for (Entry entry : currentBucket.entries) {
                    innerMap.put(entry.key, entry.value);
                }
                
                currentBucket.entries = null;
                currentBucket.innerMap = innerMap;
                return;
            }
            
            final var newBucket = new Bucket();
            newBucket.entries = new LinkedList<>();
            
            final var newEntry = new Entry();
            newEntry.key = key;
            newEntry.value = value;
            
            newBucket.entries.add(newEntry);
            this.buckets[hash] = newBucket;
        }

        void remove(int key) {
            
            final var hashCode = this.calcHash(key);
            final var bucket = this.buckets[hashCode];
            
            if (bucket == null) {
                return;
            }
            
            if (bucket.innerMap != null) {
                bucket.innerMap.remove(key);
            } else {
                
                final var iterator = bucket.entries.iterator();
                
                while (iterator.hasNext()) {
                    final var entry = iterator.next();
                    if (entry.key != key) {
                        continue;    
                    }
                    
                    iterator.remove();
                    return;
                }
            }
            
            if (bucket.isEmpty()) {
                this.buckets[hashCode] = null;
            }
        }

        int get(int key) {
            
            final var hashCode = this.calcHash(key);
            final var bucket = this.buckets[hashCode];
            
            if (bucket == null) {
                return -1;
            }
            
            if (bucket.innerMap != null) {
                return bucket.innerMap.get(key);
            }
            
            if (bucket.entries == null) {
                return -1;
            }
            
            for (var entry : bucket.entries) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
            
            return -1;
        }
    }
    
    private InnerHashMap innerHashMap;
    
    public MyHashMap() {
        this.innerHashMap = new InnerHashMap(10000);
    }
    
    public void add(int key) {
    }
    
    public void remove(int key) {
        this.innerHashMap.remove(key);
    }
    

    public void put(int key, int value) {
        this.innerHashMap.put(key, value);
    }
    
    public int get(int key) {
        return this.innerHashMap.get(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */