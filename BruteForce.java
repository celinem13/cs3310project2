public class BruteForce {
    private int[] array;
    private int[] sumArray;
    int num1, num2;
    public BruteForce(int[] a){
        array = a;
        sumArray = new int[2];
    }

    public void findSum(int sum){
        for (int i = 1; i <= array.length-1; i++){
            for (int j = 1; j <= array.length - 1; j++) {
                if (array[i] + array[j] == sum) {
                    num2 = array[j];
                    num1 = array[i];
                }
            }
        }
        sumArray[1] = num2;
        sumArray[0] = num1;
    }

    public int getNum1(){
        return sumArray[0];
    }

    public int getNum2(){
        return sumArray[1];
    }
}
