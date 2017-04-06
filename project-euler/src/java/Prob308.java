public class Prob308 {
	private static long[] primes = new long[] {2,  3,  5,  7, 11, 13, 17, 19, 23, 29};
	
	private static long[][] instructions = new long[][] {
		// 17/91 = 17/7/13
		{0,0,0,-1,0,-1,1,0,0,0},
		// 78/85 = 2*3*13/17/5
		{1,1,-1,0,0,1,-1,0,0,0},
		// 19/51 = 19/3/17
		{0,-1,0,0,0,0,-1,1,0,0},
		// 23/38 = 23/2/19
		{-1,0,0,0,0,0,0,-1,1,0},
		// 29/33 = 29/3/11
		{0,-1,0,0,-1,0,0,0,0,1},
		// 77/29 = 7*11/29
		{0,0,0,1,1,0,0,0,0,-1},
		// 95/23 = 19*5/23
		{0,0,1,0,0,0,0,1,-1,0},
		// 77/19 = 7*11/19
		{0,0,0,1,1,0,0,-1,0,0},
		// 1/17 = 1/17
		{0,0,0,0,0,0,-1,0,0,0},
		// 11/13
		{0,0,0,0,1,-1,0,0,0,0},
		// 13/11
		{0,0,0,0,-1,1,0,0,0,0},
		// 15/2 = 3*5/2
		{-1,1,1,0,0,0,0,0,0,0},
		// 1/7
		{0,0,0,-1,0,0,0,0,0,0},
		// 55
		{0,0,1,0,1,0,0,0,0,0}};

	public static void main(String[] args) {
		long[] a = new long[] {1,0,0,0,0,0,0,0,0,0};
		long count = 0; 
		int powerOfTwo = 1;
		while(powerOfTwo < 1000) {
			for (int i = 0; i < instructions.length; i++) {
				long[] tmp = add(a,instructions[i]);
				if (isZeroOrMore(tmp)) {
					a = tmp;
					//System.out.println("zeroOrMore: " + toString(instructions[i]));
					break;
				}
			}
			//System.out.println(evaluate(a));
			count++;
			if (isPowerOfTwo(a)) {
			    System.out.println(toString(a) + " is power of 2, count is " + count);
				powerOfTwo++;
			}
		}
	}
	public static boolean isZeroOrMore(long[] a) {
		for (int i = 0; i < 10; i++) {
		    if (a[i] < 0) {
				return false;
			}
		}
		return true;
	}
	public static boolean isPowerOfTwo(long[] a) {
		for (int i = 1; i < 10; i++) {
		    if (a[i] != 0) {
				return false;
			}
		}
		return true;
	}
	public static long[] add(long[] a, long[] b) {
		long[] c = new long[10];
		for (int i = 0; i < 10; i++) {
		    c[i] = a[i] + b[i];
		}
		return c;
	}
	public static long evaluate(long[] a) {
		long val = 1;
		for (int i = 0; i < a.length; i++) {
		    if (a[i] < 0) {
			    System.out.println("Invalid at index "  + i);
			} else if (a[i] > 0) {
			    for (int j = 0; j < a[i]; j++) {
					val = val * primes[i];
				}
			}
		}
		return val;
	}
	public static String toString(long[] a) {
	    StringBuilder s = new StringBuilder();
	    for (int i = 0; i < a.length; i++) {
		    s.append(a[i]).append(", ");
		}
		return s.toString();
	}
}