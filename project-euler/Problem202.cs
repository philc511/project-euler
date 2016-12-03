using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProjectEulerProblems
{
    /// <summary>
    /// Laserbeams
    /// </summary>
    class Problem202 : ProjectEulerProblem
    {

        public long GetSolution()
        {
            //long numSides = 11;
            //long numSides = 1000001;
            long numSides = 12017639147;

            long count = 0;
            long numCorners = (numSides + 1) / 4;
            long distFromOrig = (numSides + 3) / 2;

            long[] factors = new long[512];
            int size = 0;
            long maxFactor = (long)Math.Sqrt(distFromOrig);
            for (long i = 2; i <= maxFactor; i++)
            {
                if ((distFromOrig % i) == 0)
                {
                    factors[size] = i;
                    size++;
                }
            }

            int offset;
            if ((numSides + 1) % 4 == 0)
            {
                offset = 1;
            }
            else
            {
                offset = 2;
            }
            for (long i = 0; i < numCorners; i++)
            {
                if (i % 3 == offset) //ie a C corner
                {
                    long distFromEdge = numCorners - i;
                    if (!isFactor(i, factors, size))
                    {
                        count++;
                    }
                }
            }
            return 2 * count;
        }

        public static bool isFactor(long a, long[] factors, int size)
        {
            for (int i = 0; i < size; i++)
            {
                if ((a % factors[i]) == 0)
                {
                    return true;
                }
            }
            return false;
        }
    }
}
