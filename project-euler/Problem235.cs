using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Problem235
    {
        static void Main()
        {
            for (int i = 0; i < 200; i++)
            {
//                Console.WriteLine("{0}, {1}", -1.0+(double)i/50,calc(-1.0 + (double)i / 50));
            }
            double lower = 1.0;
            double upper = 1.02;
            double midval = 0.5 * (lower + upper);
 
            double flower = calc(lower);
            double fupper = calc(upper);
            double fmid = calc(midval);


            for (int i = 0; i < 100; i++)
            {
                if (fmid < 0.0)
                {
                    upper = midval;
                    fupper = fmid;
                    midval = 0.5 * (lower + upper);
                    fmid = calc(midval);
                }
                else
                {
                    lower = midval;
                    flower = fmid;
                    midval = 0.5 * (lower + upper);
                    fmid = calc(midval);
                }
                Console.WriteLine("{0}, {1}", midval, fmid);
            }
 
        }
        static double calc(double r)
        {
            double sum = 0.0;
            for (int k = 1; k <= 5000; k++)
            {
                sum += (900 - 3 * k) * Math.Pow(r, k - 1);
            }
            return sum + 600000000000.0;
        }
    }
}
