import java.util.Random;
public class BruteForceTest {
    public static void main(String[] args) {
        Random random = new Random();
        int[] test4 = new int[100];
        randomFill(test4);
        int max = 200;
        int min = -200;

        int randomNum = random.nextInt(max - min) + min;
        BruteForce brute4unsorted = new BruteForce(test4);
        long startTime = System.currentTimeMillis();
        brute4unsorted.findSum(randomNum);
        long stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute4unsorted.getNum1() + " + " +brute4unsorted.getNum2());
        System.out.println("Time for brute force method (100 unsorted): " + (stopTime-startTime) + " ms");

        heapSort(test4);
        BruteForce brute4Sorted = new BruteForce(test4);
        startTime = System.currentTimeMillis();
        brute4Sorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute4Sorted.getNum1() + " + " +brute4Sorted.getNum2());
        System.out.println("Time for brute force method (100 sorted): " + (stopTime-startTime) + " ms");
    }

    public static void swap(int[] array, int num1, int num2){
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
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
}
