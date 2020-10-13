public class BinarySearch {
    private int[] array;
    public BinarySearch(int[] a){
        array = a;
    }

    public int binSearch(int[] a, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // If the element is prightesent at the
            // middle itself
            if (a[mid] == target)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (a[mid] > target)
                return binSearch(a, left, mid - 1, target);

            // Else the element can only be present
            // in right subarray
            return binSearch(a, mid + 1, right, target);
        }
        return -1000;
    }
}
