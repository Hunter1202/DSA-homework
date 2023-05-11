package Baitap;

public class Bai1 {

    public static void testInteger(PriorityQueueInterface<Integer, Integer> pq){
        pq.insert(10, 10);
        pq.insert(5, 5);
        pq.insert(7, 7);
        pq.insert(3, 3);

        System.out.println("Remove min element: " + pq.removeMin().getValue());
        System.out.println("Min element: " + pq.min().getValue());

        System.out.println("Queue contents:");
        while (!pq.isEmpty()) {
            System.out.print(pq.removeMin().getValue() + " ");
        }
        System.out.println();

    }

    public static void testProduct(PriorityQueueInterface<Double, String> pq) {
        pq.insert(12.0, "Sweptail");
        pq.insert(8.0, "Maybach Exelero");
        pq.insert(10.0, "Chiron");
        pq.insert(6.0, "Veneno");

        System.out.println("Remove min element: " + pq.removeMin().getValue());
        System.out.println("Min element: " + pq.min().getValue());
        System.out.println("Queue contents:");
        while (!pq.isEmpty()) {
            Entry<Double, String> entry = pq.removeMin();
            System.out.print(entry.getValue() + " " + entry.getKey() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("-----------Test with integer-----------------");
        PriorityQueueInterface<Integer, Integer> pq1 = new UnsortedArrayPriorityQueue<>();
        System.out.println("\nUnsortedArrayPriorityQueue");
        testInteger(pq1);

        PriorityQueueInterface<Integer, Integer> pq2 = new SortedArrayPriorityQueue<>();
        System.out.println("\nSortedArrayPriorityQueue");
        testInteger(pq2);

        PriorityQueueInterface<Integer, Integer> pq3 = new UnsortedLinkedPriorityQueue<>();
        System.out.println("\nUnsortedLinkedPriorityQueue");
        testInteger(pq3);

        PriorityQueueInterface<Integer, Integer> pq4 = new SortedLinkedPriorityQueue<>();
        System.out.println("\nSortedLinkedPriorityQueue");
        testInteger(pq4);

        //----------------------------------------------//

        System.out.println("\n---------Test with Product objects------------");
        PriorityQueueInterface<Double, String> pq11 = new UnsortedArrayPriorityQueue<>();
        System.out.println("\nUnsortedArrayPriorityQueue");
        testProduct(pq11);

        PriorityQueueInterface<Double, String> pq22 = new SortedArrayPriorityQueue<>();
        System.out.println("\nSortedArrayPriorityQueue");
        testProduct(pq22);

        PriorityQueueInterface<Double, String> pq33 = new UnsortedLinkedPriorityQueue<>();
        System.out.println("\nUnsortedLinkedPriorityQueue");
        testProduct(pq33);

        PriorityQueueInterface<Double, String> pq44 = new SortedLinkedPriorityQueue<>();
        System.out.println("\nSortedLinkedPriorityQueue");
        testProduct(pq44);
    }
}
