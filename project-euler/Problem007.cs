using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApplication1
{
    class Problem7
    {
        static void Main(string[] args)
        {
            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();
            int n = 10001;
            int i = 0;
            int j = 0;
            while (i < n)
            {
                j++;
                if (IsPrime(j))
                {
                    i++;
                }
            }
            sw.Stop();
            System.Console.WriteLine(j);
            Console.WriteLine("Elapsed = {0}", sw.Elapsed.ToString());
        }
        static bool IsPrime(int n)
        {
            if (n == 1)
            {
                return false;
            }
            if (n == 2)
            {
                return true;
            }
            if (n % 2 == 0)
            {
                return false;
            }
            int max = (int)Math.Sqrt(n);
            for (int i = 3; i <= max; i += 2)
            {
                if ((n % i) == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
