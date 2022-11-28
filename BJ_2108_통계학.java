import java.util.Arrays;
import java.util.Scanner;

public class BJ_2108_≈Î∞Ë«– {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		mean(nums);
		median(nums);
		mode(nums);
		range(nums);
	}
	
	public static void mean(int[] nums) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		System.out.println(Math.round(sum/nums.length));
	}
	
	public static void median(int[] nums) {
		System.out.println(nums[nums.length/2]);
	}
	
	public static void mode(int[] nums) {
		int[] cnts = new int[nums.length];
		int first = nums[0];
		for (int i = 0; i < cnts.length; i++) {
			cnts[i] = 1;
		}
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == first) {
				cnts[i] = cnts[i-1] + 1;
				if (cnts[i] > max) {
					max = cnts[i];
				}
			}
			first = nums[i];
		}
		boolean flag = false;
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cnts[i] == max) {
				ans = nums[i];
				if (flag) {
					break;
				}
				flag = true;
			}
		}
		System.out.println(ans);
	}
	public static void range(int[] nums) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}
		System.out.println(max - min);
	}
}
