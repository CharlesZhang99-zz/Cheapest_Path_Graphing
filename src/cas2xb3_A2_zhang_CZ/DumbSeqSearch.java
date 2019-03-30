package cas2xb3_A2_zhang_CZ;

//just a sequential search I wrote to from the first index after the key.
public class DumbSeqSearch {
	public static int find(float key, float[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] >= key) {
				return i;
			}
		}
		return -1;
	}
}
