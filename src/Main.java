import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        /* minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5); */

       int[] list = {3, 5, 7, 2, 1};
       SolveProblemsWithHeap.sortInAscendingOrder(list);

       System.out.println(Arrays.toString(list));

       int[] list2 = {3, 5, 7, 2, 1};
       SolveProblemsWithHeap.sortInDescendingOrder(list);

       System.out.println("\n" + Arrays.toString(list));

       PriorityQueueUsingHeap priorityQueue = new PriorityQueueUsingHeap();

       priorityQueue.add(3);
       priorityQueue.add(2);
       priorityQueue.add(1);
       priorityQueue.add(1);

       for (int i = 0; i < 4; i++){
           System.out.println(priorityQueue.remove());
       }

       int[] list3 = {1 , 2 ,3 ,4 ,5 ,6};
       SolveProblemsWithHeap.heapify(list3);

       System.out.println("\n\n\n" + Arrays.toString(list3));


        System.out.println("\n\n" + SolveProblemsWithHeap.kthLargestItem(list3, 6));

    }

}

