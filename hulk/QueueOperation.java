
class Queue {
    int[] array;
    int front, rear;
    int capacity;
    int size;
    public Queue(int capacity) {
        this.capacity = capacity;
        this.array = new int[this.capacity];
        this.front = 0;
        this.rear = this.capacity - 1;
        this.size = 0;
    }

    boolean isFull(Queue queue) {
        return queue.size == queue.capacity;
    }

    boolean isEmpty(Queue queue) {
        return queue.size == 0;
    }

    void enQueue(int item) {
        if(isFull(this)) {
            return;
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            this.array[this.rear] = item;
            this.size = this.size + 1;
        }
    }

    int deQueue() {
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        } else {
            int item = array[this.front];
            this.front = (this.front + 1) % this.capacity;
            this.size = this.size - 1;
            return item;
        }
    }
    int rear() {
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.rear];
    }
    int front() {
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        return this.array[this.front];
    }
}
public class QueueOperation{
    public static void main(String[] args) {
        Queue queue = new Queue(100);
        queue.enQueue(2);
        queue.enQueue(5);
        queue.enQueue(1);
        queue.enQueue(4);
        queue.enQueue(9);
        System.out.println("front element of queue= " + queue.front());
        System.out.println("rear element of queue= " + queue.rear());
        System.out.println("Deleted elements from queue= " + queue.deQueue());
         System.out.println("front element of queue= " + queue.front());
        System.out.println("rear element of queue= " + queue.rear());
    }
}