using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProjectEulerProblems
{
    /// <summary>
    /// n = discs, b = blue discs, r = red discs
    /// b/n * (b-1)/(n-1) = 1/2
    /// Turned this into a pythagorean triplet
    /// (b-1)^2 + b^2 = c^2
    /// Parametrised this to end up with
    /// p = m + sqrt(2*m*m + 1)
    /// where discs = m*m-p*p and 2*blue-1 = m*m+p*p
    /// where 
    /// </summary>
    class Problem100
    {
        static void Main()
        {
            long m = 0;
            long j = 0;
            bool found = false;
            for (long n = 1; !found; n++)
            {
                j = (long)Math.Sqrt((double)(2 * n * n + 1));
                if (j * j == (2 * n * n + 1))
                {
                    m = n + j;
                    Console.WriteLine("n={0}, blue = {1}, discs={2}", n, (m * m + n * n + 1) / 2, m * m - n * n);
                    if ((m * m - n * n) > 1000000000000)
                    {
                        Console.WriteLine("Big enough!");
                        found = true;
                    }
                }
            }
        }
    }
}
