import java.util.Random;
public class driver {
    public static void main(String[] args){
        Random random = new Random();

        int[] test1 = new int[1000000];
        randomFill(test1);
        int[] test2 = new int[100000];
        randomFill(test2);
        int[] test3 = new int[1000];
        randomFill(test3);
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

        bubbleSort(test4);
        BruteForce brute4Sorted = new BruteForce(test4);
        startTime = System.currentTimeMillis();
        brute4Sorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute4Sorted.getNum1() + " + " +brute4Sorted.getNum2());
        System.out.println("Time for brute force method (100 sorted): " + (stopTime-startTime) + " ms");

        BruteForce brute3unsorted = new BruteForce(test3);
        randomNum = random.nextInt(max - min) + min;
        startTime = System.currentTimeMillis();
        brute3unsorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute3unsorted.getNum1() + " + " +brute3unsorted.getNum2());
        System.out.println("Time for brute force method (1,000 unsorted): " + (stopTime-startTime) + " ms");

        bubbleSort(test3);
        BruteForce brute3Sorted = new BruteForce(test3);
        startTime = System.currentTimeMillis();
        brute3Sorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute3Sorted.getNum1() + " + " +brute3Sorted.getNum2());
        System.out.println("Time for brute force method (1,000 sorted): " + (stopTime-startTime) + " ms");


        BruteForce brute2unsorted = new BruteForce(test2);
        randomNum = random.nextInt(max - min) + min;
        startTime = System.currentTimeMillis();
        brute2unsorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute2unsorted.getNum1() + " + " +brute2unsorted.getNum2());
        System.out.println("Time for brute force method (100,000 unsorted): " + (stopTime-startTime) + " ms");

        bubbleSort(test2);
        BruteForce brute2Sorted = new BruteForce(test2);
        startTime = System.currentTimeMillis();
        brute2Sorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute2Sorted.getNum1() + " + " +brute2Sorted.getNum2());
        System.out.println("Time for brute force method (100,000 sorted): " + (stopTime-startTime) + " ms");


        BruteForce brute1Unsorted = new BruteForce(test1);
        randomNum = random.nextInt(max - min) + min;
        startTime = System.currentTimeMillis();
        brute1Unsorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute1Unsorted.getNum1() + " + " + brute1Unsorted.getNum2());
        System.out.println("Time for brute force method (1,000,000 unsorted): " + (stopTime-startTime) + " ms");

        bubbleSort(test1);
        BruteForce brute1Sorted = new BruteForce(test1);
        startTime = System.currentTimeMillis();
        brute1Sorted.findSum(randomNum);
        stopTime = System.currentTimeMillis();
        System.out.println(randomNum + " = " + brute1Sorted.getNum1() + " + " +brute1Sorted.getNum2());
        System.out.println("Time for brute force method (1,000,000 sorted): " + (stopTime-startTime) + " ms");
    }
    public static void bubbleSort(int[] array){
        sort(array, array.length);
    }

    public static void sort(int[] array, int length){
        boolean switchedPlaces;
        for (int i = 0; i < length-1; i++){
            switchedPlaces = false;
            for (int j = 0; j < length-i-1; j++){
                if (array[j] > array[j+1]){
                    swap(array, j, (j+1));
                    switchedPlaces = true;
                }
            }
            if (!switchedPlaces)
                break;
        }
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
}
