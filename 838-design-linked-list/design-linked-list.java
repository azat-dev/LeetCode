// Doubly Linked List Version
class MyLinkedList {
    
    private class Node {
        int val;
        Node next;
        Node prev;
    }
    
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
    }
    
    private Node getNodeAt(int index) {

        if (index < 0 || index >= this.size) {
            return null;
        }
        
        if (index == this.size - 1) {
            return this.tail;
        }
        
        Node currentNode = head;

        if (this.size - index < index) {

            currentNode = tail;

            for (
                int i = size - 1; 
                currentNode != null && i != index; 
                i--, currentNode = currentNode.prev
            ) {}

            return currentNode;
        }
        

        for (
            int i = 0; 
            currentNode != null && i < index; 
            i++, currentNode = currentNode.next
        ) {}
        
        return currentNode;
    }
    
    public int get(int index) {
        
        final var node = this.getNodeAt(index);
        return node == null ? -1 : node.val;
    }
    
    public void addAtHead(int val) {
        
        final var newNode = new Node();
        newNode.val = val;
        newNode.next = this.head;

        if (this.head != null) {
            this.head.prev = newNode;
        }

        this.head = newNode;
        
        if (this.tail == null) {
            this.tail = this.head;
        }
        
        this.size++;
    }
    
    public void addAtTail(int val) {
        
        if (this.size == 0) {
            this.addAtHead(val);
            return;
        }
        
        final var newNode = new Node();
        newNode.val = val;
        newNode.prev = this.tail;
        
        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        
        if (index >= this.size + 1) {
            return;
        }
        
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        
        if (index == this.size) {
            this.addAtTail(val);
            return;
        }
        
        final var newNode = new Node();
        newNode.val = val;
        
        final var prevNode = getNodeAt(index - 1);
        newNode.next = null;
        newNode.prev = prevNode;

        if (prevNode != null) {

            newNode.next = prevNode.next;
            prevNode.next = newNode;

            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }

        this.size++;
    }
    
    private void deleteHead() {
        
        if (this.head == null) {
            return;
        }

        final var oldHead = this.head;
        this.head = this.head.next;
        
        if (oldHead.next != null) {
            oldHead.next.prev = null;
        }

        oldHead.next = null;
        this.size--;

        if (this.size == 0) {
            this.tail = null;
        }
        
        if (this.size == 1) {
            this.tail = this.head;
        }
    }
    
    private void deleteTail() {

        if (this.size == 0) {
            return;
        }
        
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        final var prevNode = this.tail.prev;
        if (prevNode == null) {
            return;
        }

        prevNode.next = null;
        this.tail = prevNode;
        this.size--;
    }
    
    
    public void deleteAtIndex(int index) {
        
        if (index >= this.size) {
            return;
        }
        
        if (index == 0) {
            this.deleteHead();
            return;
        }
        
        if (index == this.size - 1) {
            this.deleteTail();
            return;
        }
        
        final var prevNode = this.getNodeAt(index - 1);
        if (prevNode == null) {
            return;
        }
        
        final var currentNode = prevNode.next;
        if (currentNode == null) {
            return;
        }

        if (currentNode.next != null) {
            currentNode.next.prev = prevNode;
        }
        
        prevNode.next = currentNode.next;
        currentNode.next = null;
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */