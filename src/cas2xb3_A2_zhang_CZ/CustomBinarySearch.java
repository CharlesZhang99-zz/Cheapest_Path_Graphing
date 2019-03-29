package cas2xb3_A2_zhang_CZ;


//modified version of sedgewick pg 8
public class CustomBinarySearch {
	public static int start(float key, float[][] twoArr) {
		key = (float) (key - 0.5);
		float[] arr = new float[twoArr.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (twoArr[i][0]);
		}
		
        int lo = 0, hi = arr.length - 1; 
        int mid = 0;
        while (lo <= hi) { 
            mid = lo + (hi - lo) / 2; 
            if(key < arr[mid]) {
            	hi = mid- 1;
            }
            else if (key > arr[mid]) {
            	lo = mid + 1;
            }
            else return mid-1; 
        }
        return mid;
	}
}
