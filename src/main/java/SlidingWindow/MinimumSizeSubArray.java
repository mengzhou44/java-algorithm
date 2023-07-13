package SlidingWindow;

//leetcode 209
public class MinimumSizeSubArray {

	public static void main(String[] args) {
           Integer target = 7;
		   int[] nums = {2, 3, 1, 2,4,3};
		   int res = minSubArrayLen(target, nums);

		   System.out.println(res);
	}

	private static int minSubArrayLen(Integer target, int[] nums) {
		 int res = Integer.MAX_VALUE;
         int left = 0;
		 int sum = 0;

		 for(int right=0; right<nums.length; right++) {
			 sum+= nums[right];

			 while(sum>=target) {
				 res = Math.min(res, right - left + 1);
				 sum -= nums[left];
				 left++;
			 }
		 }

	     if (res == Integer.MAX_VALUE)  {return 0; }  else return res;
	}

}
