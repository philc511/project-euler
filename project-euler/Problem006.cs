using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApplication1
{
    class Problem6
    {
        static void Main(string[] args)
        {
            System.Diagnostics.Stopwatch sw = new System.Diagnostics.Stopwatch();
            sw.Start();

            int n = 100;// <=214 both methods work. <=305 second method works only
            int s = 0;
            int sumOfSqs = 0;
            for (int i = 1; i <= n; i++)
            {
                sumOfSqs += i * i;
            }
            int sqOfSums = n * (n + 1) * n * (n + 1) / 4;
            s = sqOfSums - sumOfSqs;
            sw.Stop();
            System.Console.WriteLine(s);
            Console.WriteLine("Elapsed = {0}", sw.Elapsed.ToString());

            sw.Reset();
            sw.Start();
            s = 0;
            for (int i = 1; i <= n; i++)
            {
                for (int j = i + 1; j <= n; j++)
                {
                    s += 2 * i * j;
                }
            }
            sw.Stop();
            System.Console.WriteLine(s);
            Console.WriteLine("Elapsed = {0}", sw.Elapsed.ToString());

            sw.Reset();
            sw.Start();
            sumOfSqs = n * (n + 1) * (2 * n + 1) / 6;
            sqOfSums = n * (n + 1) * n * (n + 1) / 4;
            s = sqOfSums - sumOfSqs;
            sw.Stop();
            System.Console.WriteLine(s);
            Console.WriteLine("Elapsed = {0}", sw.Elapsed.ToString());
        }
    }
}
