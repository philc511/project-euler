using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{

    class Program
    {
        int count = 0;
        static void Main(string[] args)
        {
            //long numSides = 1000001;
            //long numSides = 12017639147;
            long numSides = 1000001;
            if ((numSides % 2) == 0)
            {
                System.Console.WriteLine("Even number of sides not allowed");
                System.Console.ReadLine(); return;
            }
            long count = 0;
            long numCorners = (numSides + 1) / 4;
            long distFromOrig = (numSides + 3) / 2;
            int offset;
            if ((numSides+1) % 4 == 0)
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
                    if (isCoPrime(distFromOrig, distFromEdge))
                    {
                        count++;
                    }
                }
            }
            System.Console.WriteLine(2*count);
            System.Console.ReadLine();
        }

        public static bool isCoPrime(long a, long b)
        {
            if (a == 1 || b == 1)
            {
                return true;
            }
            if (a == b || (a % b) == 0 || (b % a) == 0)
            {
                return false;
            }
            long maxFactor = 1 + Math.Min(a, b)/2;
            for (long i = 2; i < maxFactor; i++)
            {
                if ((a % i) == 0 && (b % i) == 0)
                {       
                    return false;
                }
            }
            return true;
        }

    }
}
