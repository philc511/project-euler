using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApplication1
{
    class Problem12
    {
        static void Main()
        {
            // locate upper bound
            long i = 67108863;
            long triNum = 0;
            int nf = 0;
            do 
            {
                i++;
                triNum = i * (i + 1) / 2;
                nf = NumFactors(triNum);
                Console.WriteLine("{0}, {1}, {2}", i, triNum, nf);
            } while (nf <= 500);
            
        }
        static int NumFactors(long n)
        {
            long m = (long)Math.Sqrt((double)n);
            int factors = 2; // 1 and n
            for (long j = 2; j < m+1; j++)
            {
                if (n % j == 0)
                {
                    factors+=2; // j and n/j
                }
            }
            if ((m * m) == n)
            {
                factors--;
            }
            return factors;
        }

    }
}
