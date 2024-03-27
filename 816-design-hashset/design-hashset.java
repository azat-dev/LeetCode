class MyHashSet {
    
    private final class InnerHashSet {
        
        final class Bucket {
            List<Integer> values;
            InnerHashSet innerSet;
            
            boolean isEmpty() {
                return (this.values == null || this.values.isEmpty()) && 
                    (this.innerSet == null || this.innerSet.isEmpty());
            }
        }
        
        private Bucket[] buckets;
        private int base;
        private int count;
        
        InnerHashSet(int base) {
            this.base = base;
            this.buckets = new Bucket[base];
        }
        
        private int calcHash(int value) {
            return value % base;
        }
        
        boolean isEmpty() {
            for (Bucket bucket : buckets) {
                if (bucket != null) {
                    return false;
                }
            }
            
            return true;
        }
        
        void add(int key) {
            
            final var hash = calcHash(key);
            final var currentBucket = buckets[hash];
            
            if (currentBucket != null) {
                
                if (currentBucket.innerSet != null) {
                    currentBucket.innerSet.add(key);
                    return;
                }
                
                if (currentBucket.values.size() < 10) {
                    if (currentBucket.values.contains(key)) {
                        return;
                    }
                    
                    currentBucket.values.add(key);
                    return;
                }
                
                final var innerSet = new InnerHashSet(base / 2);
                
                for (Integer value : currentBucket.values) {
                    innerSet.add(value);
                }
                
                currentBucket.values = null;
                currentBucket.innerSet = innerSet;
                return;
            }
            
            final var newBucket = new Bucket();
            newBucket.values = new LinkedList<>();
            newBucket.values.add(key);
            
            this.buckets[hash] = newBucket;
        }

        void remove(int key) {
            
            final var hashCode = this.calcHash(key);
            final var bucket = this.buckets[hashCode];
            
            if (bucket == null) {
                return;
            }
            
            if (bucket.innerSet != null) {
                bucket.innerSet.remove(key);
            } else {
                Integer keyValue = Integer.valueOf(key);
                bucket.values.remove(keyValue);
            }
            
            if (bucket.isEmpty()) {
                this.buckets[hashCode] = null;
            }
        }

        boolean contains(int key) {
            
            final var hashCode = this.calcHash(key);
            final var bucket = this.buckets[hashCode];
            
            if (bucket == null) {
                return false;
            }
            
            if (bucket.innerSet != null) {
                return bucket.innerSet.contains(key);
            }
            
            if (bucket.values == null) {
                return false;
            }
            
            return bucket.values.contains(key);
        }
    }
    
    private InnerHashSet innerHashSet;
    
    public MyHashSet() {
        this.innerHashSet = new InnerHashSet(10000);
    }
    
    public void add(int key) {
        this.innerHashSet.add(key);
    }
    
    public void remove(int key) {
        this.innerHashSet.remove(key);
    }
    
    public boolean contains(int key) {
        return this.innerHashSet.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */