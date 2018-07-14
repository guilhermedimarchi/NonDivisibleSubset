package NonDivisibleSubset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Guilherme Dimarchi
 *
 */
public class NonDivisibleSubset {

	/**
	 * Given a set 's' of 'n' distinct integers, returns the size of a maximal
	 * subset of 's' where the sum of any 2 numbers is not evenly divisble by k
	 * @param Integer k
	 * @param List<Integer> s
	 * @return int
	 */
	public int findNonDivisibleSubset(Integer k, List<Integer> s) {
		Map<Integer, Integer> mapCounterLeftover = new HashMap<>();
		int result = 0;
		
		/* 
		 * Creates a map for each leftover possible, counting how many numbers have the same leftover.
		 */
		for (int i = 0; i < s.size(); i++) {
			int leftover = s.get(i) % k;
			Integer currentCounter = mapCounterLeftover.containsKey(leftover) ? mapCounterLeftover.get(leftover) + 1 : 1;
			mapCounterLeftover.put(leftover, currentCounter);
		}
		
		/*
		 * There may be more than one value that is evenly divisible by k. When this happens we can consider only one of these numbers in our subset.
		 * Otherwise, adding two numbers that are divisible k results in another divisible number.
		 */
		if(mapCounterLeftover.containsKey(0)) {
			result += 1;
		}
		
		/*
		 * Iterates half of K, going through the value and its complement. And we count only the one with the bigger counter.
		 * We can't count both value and complement because adding them would result in a number that is divisible by k.
		 */
		for (int i = 1; i <= (k / 2) ; i++) {
			if (i != k - i) {
				Integer value = mapCounterLeftover.containsKey(i) ? mapCounterLeftover.get(i) : 0;
				Integer complement = mapCounterLeftover.containsKey(k - i) ? mapCounterLeftover.get(k - i) : 0;
				result += Math.max(value, complement);
			}
		}
		
		/*
		 * If k is even, the loop above will skip the central index. 
		 * So for even numbers the central index will have a combination of same number. So we count only one.
		 */
		if (k % 2 == 0) {
			if(mapCounterLeftover.containsKey(k/2)) {
				if(mapCounterLeftover.get(k/2) > 0)
					result += 1;
			}
		}
		return result;
	}
}
