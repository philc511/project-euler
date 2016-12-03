using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApplication1
{
    class Problem9
    {
        static void Main(string[] args)
        {
            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();
            for (int b = 1; b < 999; b++)
            {
                for (int a = 1; a < b; a++)
                {
                    int c = 1000 - a - b;
                    if (a * a + b * b == c * c)
                    {
                        Console.WriteLine(a + ", " + b + ", " + c);
                        a = 1000;
                        b = 1000;
                    }
                }
            }
            sw.Stop();
            Console.WriteLine("Elapsed = {0}", sw.Elapsed.ToString());
            sw.Reset();
            sw.Start();
            for (int a = 1; a < 1000; a++)
            {
                int b = (1000000 - 2000 * a) / (2000 - 2 * a);
                int c = 1000 - a - b;
                if (c > 0 && b > 0 && (a * a + b * b == c * c))
                {
                    Console.WriteLine(a + ", " + b + ", " + c);
                    a = 1000;
                }
            }
            sw.Stop();
            Console.WriteLine("Elapsed = {0}", sw.Elapsed.ToString());
        }
    }
}
