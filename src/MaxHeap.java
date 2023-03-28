import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> collection= new ArrayList<>(10);
    private int counter;

    public MaxHeap(){}

    public MaxHeap(int listSize){
        collection= new ArrayList<>(listSize);
    }

    public void insert (Integer item){
        collection.add(item);
        counter++;

        int itemIndex = counter - 1;

        if (itemIndex == 0)
            return;

        int parentIndex = calculateParentIndex(itemIndex);

        while (collection.get(itemIndex) > collection.get(parentIndex)) {
            bubbleUp(itemIndex, parentIndex);

            itemIndex = parentIndex;

            if (itemIndex == 0)
                return;

            parentIndex = calculateParentIndex(itemIndex);
        }
    }

    /* Remove the first element (or the largest element because it is the max heap), so we
    need to bubble down values to follow the heap's rules  */
    public Integer remove(){
        Integer value = collection.get(0);
        collection.set(0, collection.get(--counter));
        collection.remove(counter);

        int itemIndex = 0;

        int largerChildIndex = indexOfTheLargerChild(leftNodeChildIndex(itemIndex), rightNodeChildIndex(itemIndex));

        if (largerChildIndex == -1)
            return value;

        while (collection.get(itemIndex) < collection.get(largerChildIndex)){
            bubbleDown(itemIndex, largerChildIndex);

            itemIndex = largerChildIndex;

            largerChildIndex = indexOfTheLargerChild(leftNodeChildIndex(itemIndex), rightNodeChildIndex(itemIndex));

            if (largerChildIndex == -1)
                break;
        }

        return value;
    }

    private int calculateParentIndex(int itemIndex){
        return (itemIndex - 1) / 2;
    }

    private void bubbleUp(int itemIndex, int parentIndex){
        Integer temp = collection.get(parentIndex);

        collection.set(parentIndex, collection.get(itemIndex));
        collection.set(itemIndex, temp);
    }

    private void bubbleDown(int itemIndex, int childIndex){
        Integer temp = collection.get(childIndex);

        collection.set(childIndex, collection.get(itemIndex));
        collection.set(itemIndex, temp);
    }

    private int leftNodeChildIndex(int parentIndex){
        int index = parentIndex * 2 + 1;
        if (index < counter)
            return index;

        return -1;
    }

    private int rightNodeChildIndex(int parentIndex){
        int index = parentIndex * 2 + 2;
        if (index < counter)
            return index;

        return -1;
    }

    private int indexOfTheLargerChild(int leftNodeChildIndex, int rightNodeChildIndex){
        if (leftNodeChildIndex < 0 && rightNodeChildIndex < 0)
            return -1;
        else if (leftNodeChildIndex > 0 && rightNodeChildIndex > 0)
             return collection.get(leftNodeChildIndex) > collection.get(rightNodeChildIndex) ? leftNodeChildIndex : rightNodeChildIndex;
        else if (leftNodeChildIndex == -1)
            return rightNodeChildIndex;
        else
            return leftNodeChildIndex;
    }

}
