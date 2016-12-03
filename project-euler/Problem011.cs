using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace ConsoleApplication1
{
    class Problem11
    {
        static void Main()
        {
            int size = 20;
            int[,] grid = ReadIntoArray(@"c:\temp\temp.dat", size, size);
            //int[,] grid = { { 1, 3, 1, 1 }, { 1, 1, 1, 1 }, { 1, 10, 1, 1 }, { 1, 1, 1, 1 } };
            int maxPrd = 0;
            string msg = "";
            int prd = 0;
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    if (j < size - 3)
                    {
                        prd = grid[i, j] * grid[i, j + 1] * grid[i, j + 2] * grid[i, j + 3];
                        if (prd > maxPrd)
                        {
                            maxPrd = prd;
                            msg = maxPrd + ", " + i + ", " + j + ", across";
                        }
                    }
                    if (i < size - 3)
                    {
                        prd = grid[i, j] * grid[i + 1, j] * grid[i + 2, j] * grid[i + 3, j];
                        if (prd > maxPrd)
                        {
                            maxPrd = prd;
                            msg = maxPrd + ", " + i + ", " + j + ", down";
                        }
                    }
                    if (i < size - 3 && j < size - 3)
                    {
                        prd = grid[i, j] * grid[i + 1, j+1] * grid[i + 2, j+2] * grid[i + 3, j+3];
                        if (prd > maxPrd)
                        {
                            maxPrd = prd;
                            msg = maxPrd + ", " + i + ", " + j + ", diag";
                        }
                    }
                    if (i > 2 && j < (size - 3))
                    {
                        prd = grid[i, j] * grid[i - 1, j + 1] * grid[i - 2, j + 2] * grid[i - 3, j + 3];
                        if (prd > maxPrd)
                        {
                            maxPrd = prd;
                            msg = maxPrd + ", " + i + ", " + j + ", upper diag";
                        }
                    }
                }
            }
            Console.WriteLine(msg);
        }
        static int[,] ReadIntoArray(string filename, int x, int y)
        {
            System.IO.StreamReader myFile = new System.IO.StreamReader(filename);
            string myString = myFile.ReadToEnd();
            myFile.Close();

            string[] nums = myString.Split(new char[]{' ','\r', '\n'});
            int[,] grid = new int[x, y];
            int i = 0;
            int j = 0;
            foreach (string s in nums)
            {
                if (s.Length > 0)
                {
                    grid[i, j] = int.Parse(s);
                    j++;
                    if (j == y)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
            return grid ;
        }
    }
}
