public class SortAnalysis {
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        double bubble = 0;
        double selection = 0;
        double insertion = 0;
        double merge = 0;
        double quick = 0;
        int[] arr;
        String[] arrayNames = {"Random", "Nearly Sorted", "Reversed", "Few Unique Values"};

        for (int n = 0; n < 4; n++) {
            System.out.println("\n" + arrayNames[n] + " Array:\n");
            for (int s = 1; s < 6; s++) {
                double size = Math.pow(10, s);
                for (int i = 0; i < 11; i++) {

                    arr = getArrayOfType(n, (int) size);
                    sw.start();
                    Sorts.bubbleSort(arr);
                    sw.stop();
                    if (i > 0) bubble += sw.getElapsedTime();

                    arr = getArrayOfType(n, (int) size);
                    sw.start();
                    Sorts.selectSort(arr);
                    sw.stop();
                    if (i > 0) selection += sw.getElapsedTime();

                    arr = getArrayOfType(n, (int) size);
                    sw.start();
                    Sorts.insertSort(arr);
                    sw.stop();
                    if (i > 0) insertion += sw.getElapsedTime();

                    arr = getArrayOfType(n, (int) size);
                    sw.start();
                    Sorts.mergeSort(arr);
                    sw.stop();
                    if (i > 0) merge += sw.getElapsedTime();

                    arr = getArrayOfType(n, (int) size);
                    sw.start();
                    Sorts.quickSort(arr);
                    sw.stop();
                    if (i > 0) quick += sw.getElapsedTime();
                }
                System.out.printf("Size of %.0f%n", size);
                System.out.printf("Bubble: %.1f   Selection: %.1f   Insertion: %.1f   Merge: %.1f   Quick: %.1f%n", bubble / 10.0, selection / 10.0, insertion / 10.0, merge / 10.0, quick / 10.0);
                bubble = 0;
                selection = 0;
                insertion = 0;
                merge = 0;
                quick = 0;
            }
        }
    }


    public static int[] getArrayOfType(int i, int size) {
        switch (i) {
            case 0:
                return ArrayGen.randomizedArray(size);
            case 1:
                return ArrayGen.nearlySortedArray(size);
            case 2:
                return ArrayGen.reversedArray(size);
            case 3:
                return ArrayGen.fewUniqueArray(size);
            default:
                return null;
        }
    }
}
