package pjc.projecteuler.problems1to50;

import pjc.projecteuler.util.SieveOfEratosthenes;

import java.util.Date;
import java.util.List;

public class Problem047 {
	

	public static void main(String[] args) {
		Date startTime = new Date();
		List<Integer> primes = SieveOfEratosthenes.getPrimesAsList(1000);
		
		int counter = 0;
		for (int i = 0; i < 1000; i++) {
			if (!primes.contains(i) && countFactors(i, primes) == 3) {
				counter++;
			} else {
				counter = 0;
			}
			if (counter == 3) {
				System.out.println(i);
				break;
			}
		}

		System.out.printf("%d ms", (new Date()).getTime() - startTime.getTime());		
	}
	private static int countFactors(int i, List<Integer> primes) {
		int factors = 0;
		for (int j = 0; primes.get(j) < i; j++) {
			if (i % primes.get(j) == 0) {
				factors++;				
			}
		}
		return factors;
	}
	
}
