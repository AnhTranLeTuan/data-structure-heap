public class PriorityQueueUsingHeap{

    private MinHeap minHeap = new MinHeap();

    PriorityQueueUsingHeap(){}

    PriorityQueueUsingHeap(int size){
        minHeap = new MinHeap(size);
    }

    public void add(int item){
        minHeap.insert(item);
    }

    public int remove(){
        return minHeap.remove();
    }

}
