class MyCircularQueue {

    private ArrayList<Integer> values;
    private int startPointer;
    private int maxNumberOfValues;
    private int size;
    
    public MyCircularQueue(int k) {
        this.values = new ArrayList<Integer>(k);
        this.startPointer = 0;
        this.size = 0;
        this.maxNumberOfValues = k;
    }
    
    public boolean enQueue(int value) {
        
        if (this.isFull()) {
            return false;
        }
        
        if (this.values.size() < this.maxNumberOfValues) {
        
            this.values.add(value);
            this.size++;
            return true;
        }
        
        final var index = (this.startPointer + this.size) % this.maxNumberOfValues;
        this.values.set(index, value);
        this.size++;
        
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        
        this.startPointer++;
        this.startPointer %= this.maxNumberOfValues;
        this.size--;
        
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        
        return this.values.get(this.startPointer);
    }
    
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        
        final var endIndex = (this.startPointer + this.size - 1) % this.maxNumberOfValues;
        return this.values.get(endIndex);
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean isFull() {
        return this.size == this.maxNumberOfValues;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */