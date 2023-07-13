package TopK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


//Leet Code 347
public class FindKMostFrequent {

	 public static void main(String[] args ) {
		 Integer[] res = topKMostFrequentElements(new int[] {1,1,1,2,2,3}, 2);

		  for(Integer num: res) {
			  System.out.println(num);
		  }
	 }

	 private static  Integer[] topKMostFrequentElements(int[] nums, int k) {

		 Map<Integer,Integer> frequencyMap = new HashMap<>();
		 for(int num: nums) {
			 frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		 }

		 PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));

		 for(int num : frequencyMap.keySet()) {
			 heap.offer(num);
			 if (heap.size()>k) {
				  heap.poll();
			 }
		 }

		 return  heap.toArray(new Integer[heap.size()]);

	 }

}
