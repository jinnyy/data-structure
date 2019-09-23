package sort;

public class Sort {
	
	public static int[] selectionSort(int[] input) {
		int N = input.length;
		int[] sorted = input.clone();
		
		for(int loc=0; loc<N-1; loc++) {
			// find minimum value
			int min = sorted[loc];
			int minIdx = loc;
			for(int j=loc+1; j<N; j++) {
				if(sorted[j] < min) {
					min = sorted[j];
					minIdx = j;
				}
			}
			// swap
			swap(sorted, loc, minIdx);
		}
		return sorted;
	}
	
	public static int[] bubbleSort(int[] input) {
		int[] sorted = input.clone();
		int N = input.length;
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				if(sorted[j] > sorted[j+1]) {
					swap(sorted, j, j+1);
				}
			}
		}
		return sorted;
	}
	
	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
