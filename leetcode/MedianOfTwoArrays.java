import java.util.Arrays;

public class MedianOfTwoArrays {

	public static void main(String[] args) {
		System.out.println("Sujeet");
		int[] arr1 = {1,2};
		int[] arr2 = {3,4};
		System.out.println(getMedian(arr1,arr2));
	}
	public static double getMedian(int[] nums1,int[] nums2) {
		int[] result = new int[nums1.length + nums2.length];
		int k = 0;
		int i = 0;
		int j = 0;
		while(i < nums1.length && j < nums2.length) {
			if(nums1[i] < nums2[j]) {
				result[k] = nums1[i];
				i++;
				k++;
			}else {
				result[k] = nums2[j];
				j++;
				k++;
			}
		}
		while(i < nums1.length) {
			result[k++] = nums1[i++];
		}
		while(j < nums2.length) {
			result[k++] = nums2[j++];
		}
		Arrays.stream(result).forEachOrdered(System.out::println);
		if(result.length % 2 != 0) {
			return (double)result[result.length / 2];
		}else {
			return (double)(result[(result.length)/2 - 1] + result[(result.length)/2])/2;
		}
	}

}
