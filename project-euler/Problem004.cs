using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProjectEulerProblems
{
    /// <summary>
    /// A palindromic number reads the same both ways. The largest palindrome made from the product of 
    /// two 2-digit numbers is 9009 = 91x99.
    /// Find the largest palindrome made from the product of two 3-digit numbers.

    /// </summary>
    class Problem004 : ProjectEulerProblem
    {
        public long GetSolution()
        {
            int maxPalindrome = 0;
            for (int i = 999; i > 100; i--)
            {
                for (int j = 999; j > 100; j--)
                {
                    if (IsPalindrome(i * j) && (i*j) > maxPalindrome)
                    {
                        maxPalindrome = (i * j);
                    }
                }
            }
            return maxPalindrome;
        }
        // for length 6 digits
        private bool IsPalindrome(int n)
        {
            int msd1 = n / 100000;
            int msd2 = (n % 100000) / 10000;
            int msd3 = (n % 10000) / 1000;
            int msd4 = (n % 1000) / 100;
            int msd5 = (n % 100) / 10;
            int msd6 = n % 10;
            return (msd1 == msd6) && (msd2 == msd5) && (msd3 == msd4);
        }
     }
}
