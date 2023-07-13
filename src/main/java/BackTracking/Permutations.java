package BackTracking;

import java.util.ArrayList;
import java.util.List;

//leetcode 47
public class Permutations {
	public static void main(String[] args) {
		 int[] nums = {1, 2,3};
		 List<List<Integer>> res = permute(nums);

		for(List<Integer> list: res) {
			 list.forEach(System.out::print);
			 System.out.println();
		}
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res= new ArrayList<> ();
		backtrack(nums, new ArrayList<>(), res);
		return res;
	}
	private static void backtrack(int[] nums, List<Integer> permutation, List<List<Integer>> res) {
		  if (permutation.size() == nums.length) {
			  res.add(new ArrayList<>(permutation));
		  } else {
			   for(int num:nums) {
				    if (permutation.contains(num)) continue;
					permutation.add(num);
					backtrack(nums, permutation, res);
					permutation.remove(permutation.size()-1);
			   }
		  }
	}
}
