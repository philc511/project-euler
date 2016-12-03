using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApplication1
{
    /// <summary>
    /// Product 'A' 'B' 
    /// Beluga Caviar 5248 640 
    /// Christmas Cake 1312 1888 
    /// Gammon Joint 2624 3776 
    /// Vintage Port 5760 3776 
    /// Champagne Truffles 3936 5664 

    /// </summary>
    class Problem236
    {
        static void Main()
        {
            double r = 0.0;
            double s = 0.0;
            double t = 0.0;
            double u = 0.0;
            double m1 = 0.0;
            double m2 = 0.0;
            long count = 0;
            for (int abc = 1; abc < 5249; abc++)
            {
                r = abc / 5248.0;
                Console.WriteLine(abc);
                for (int bbc = 1; bbc < 641; bbc++)
                {
                    Console.WriteLine(bbc);
                    s = bbc / 640.0;
                    for (int acc = 1; acc < 1313; acc++)
                    {
                        t = acc / 1312.0;
                        for (int bcc = 1; bcc < 1889; bcc++)
                        {
                            u = bcc / 1888.0;
                            m1 = s / r;
                            m2 = u / t;
                            if (m1 == m2)
                            {
                                count++;
                            }
                        }
                    }
                }
            }
            Console.WriteLine(count);

        }
    }
}
