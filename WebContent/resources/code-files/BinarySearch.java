package BinarySearch;

public class BinarySearch {
	
	public static int binarySearch(int[] aList, int item) {
		int p = 0;
		int r = aList.length-1;
		
		while (p <= r) {
			int q = (p + r)/2;
			if (aList[q] == item) {
				return q;
			} else if (aList[q] > item) {
				r = q - 1;
			} else {
				p = q + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] aList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int item = 6;
		
		System.out.println(binarySearch(aList, item));
	}

}