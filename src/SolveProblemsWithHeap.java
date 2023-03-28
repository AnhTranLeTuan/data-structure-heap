public class SolveProblemsWithHeap {

    public static void sortInAscendingOrder(int[] list){
        MinHeap minHeap = new MinHeap(list.length);

        for (var item : list)
            minHeap.insert(item);

        for (int i = 0; i < list.length; i++)
            list[i] = minHeap.remove();
    }

    public static void sortInDescendingOrder(int[] list){
        MaxHeap maxHeap = new MaxHeap(list.length);

        for (var item : list)
            maxHeap.insert(item);

        for (int i = 0; i < list.length; i++)
            list[i] = maxHeap.remove();
    }

    // Convert array into heap in place (in this case, max heap)
    public static void heapify(int[] list){
        int parentIndex;

        for (int i = list.length - 1; i > 0; i--){
            parentIndex = calculateParentIndex(i);

            if (list[i] > list[parentIndex])
                bubbleUp(i, parentIndex, list);
        }
    }

    public static int kthLargestItem(int[] list, int kthItem){
        MaxHeap maxHeap = new MaxHeap(list.length);
        int result = 0;

        for (int i = 0; i < list.length; i++)
            maxHeap.insert(list[i]);

        for (int i = 1; i <= kthItem; i++)
            result = maxHeap.remove();

        return result;
    }

    private static int calculateParentIndex(int itemIndex){
        return (itemIndex - 1) / 2;
    }

    private static void bubbleUp(int itemIndex, int parentIndex, int[] list){
        int temp = list[itemIndex];
        list[itemIndex] = list[parentIndex];
        list[parentIndex] = temp;
    }


}
