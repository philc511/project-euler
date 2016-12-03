using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProjectEulerProblems
{
    class Runner
    {
        static void Main(string[] args)
        {
            System.Diagnostics.Stopwatch clock = new System.Diagnostics.Stopwatch();
            clock.Start();

            ProjectEulerProblem prob = new Problem220();
            long count = prob.GetSolution();

            clock.Stop();
            System.Console.WriteLine(count);
            System.Console.WriteLine(clock.ElapsedMilliseconds);
            System.Console.ReadLine();
        }

    }
}
