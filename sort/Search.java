package sort;


public class Search {
	
	static int binarySearch(int[] input, int target) {
		int left = 0;
		int right = input.length-1;
		while(left <= right) {
			int mid = (left + right + 1) / 2;
			if(input[mid] == target) return mid;
			if(input[mid] < target) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		return -1;
	}
	
}
