import java.util.Random;

public class BinarySearchTest {
    public static void main(String[] args){
        Random random = new Random();
        int[] test = new int[100];
        randomFill(test);
        int max = 200;
        int min = -200;
        long startTime;
        long stopTime;
        int randomNum;

        BinarySearch search = new BinarySearch(test);
        randomNum = random.nextInt(max - min) + min;
        startTime = System.currentTimeMillis();
        findSum(test, search, randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println("Time for binary search method (100 unsorted): " + (stopTime-startTime) + " ms");

        heapSort(test);
        BinarySearch searchSort = new BinarySearch(test);
        randomNum = random.nextInt(max - min) + min;
        startTime = System.currentTimeMillis();
        findSum(test, searchSort, randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println("Time for binary search method (100 sorted): " + (stopTime-startTime) + " ms");
    }
    public static void randomFill(int[] array){
        Random random = new Random();
        int randomNum;
        for (int i = 0; i < array.length; i++){
            randomNum = random.nextInt(100);
            if (i%2==0)
                array[i] = randomNum;
            else
                array[i] = -randomNum;
        }
    }

    public static void heapSort(int[] array){
        int length = array.length;
        for (int i = (length/2) - 1; i >= 0; i--)
            heapify(array, length, i);
        for (int i = length - 1; i > 0; i--){
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int length, int root) {
        int biggest = root;
        int left = 2*root + 1;
        int right = 2*root + 2;

        if (left < length && array[left] > array[biggest])
            biggest = left;

        if (right < length && array[right] > array[biggest])
            biggest = right;

        if(biggest != root){
            swap(array, root, biggest);
            heapify(array, root, biggest);
        }
    }

    public static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    public static void findSum(int[] a, BinarySearch search, int randomNum){
        int num1, num2 = 0;
        int left = 0;
        int right = a.length;
        int temp;
        for (int j : a) {
            num1 = j;
            temp = randomNum - num1;
            num2 = search.binSearch(a, left, right - 1, temp);
            if (num2 != -1000) {
                System.out.println(randomNum + " = " + a[num2] + " + " + num1);
                break;
            }
        }
        if (num2 == -1000)
            System.out.println("Element not present");
    }
}
