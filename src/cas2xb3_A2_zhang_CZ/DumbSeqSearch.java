package cas2xb3_A2_zhang_CZ;

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
