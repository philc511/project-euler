using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProjectEulerProblems
{
    class Problem220 : ProjectEulerProblem
    {
        public long GetSolution()
        {
            Program p = new Program(10);
            p.run();
            System.Console.WriteLine();
            System.Console.WriteLine(p.index);
            return p.index;
        }
    }
    /// <summary> 
    /// "a"  "aRbFR" 
    /// "b"  "LFaLb" 
    /// </summary> 
    class Program
    {
        int maxLevel = 1;
        int x = 0;
        int y = 0;
        int dir = 0; // 0 = N, 1 = E, 2 = S, 3 = W 
        public int index = 0;

        public Program(int ml)
        {
            maxLevel = ml;
        }
        public void run()
        {
            processChar('F', 0);
            processChar('a', 0);
        }
        private bool processChar(char ch, int level)
        {
            switch (ch)
            {
                case 'F':
                    forward();
                    //System.Console.Write('F'); 
                    break;
                case 'R':
                    dir = (++dir) % 4;
                    //System.Console.Write('L'); 
                    break;
                case 'L':
                    dir += 3;
                    dir = dir % 4;
                    //System.Console.Write('R'); 
                    break;
                case 'a':
                    if (level < maxLevel)
                    {
                        processChar('a', level + 1);
                        processChar('R', level + 1);
                        processChar('b', level + 1);
                        processChar('F', level + 1);
                        processChar('R', level + 1);
                    }
                    else
                    {
                        //System.Console.Write('a'); 
                    }
                    break;
                case 'b':
                    if (level < maxLevel)
                    {//"LFaLb" 
                        processChar('L', level + 1);
                        processChar('F', level + 1);
                        processChar('a', level + 1);
                        processChar('L', level + 1);
                        processChar('b', level + 1);
                    }
                    else
                    {
                        //System.Console.Write('b'); 
                    }
                    break;
            }
            return true;
        }
        private void forward()
        {
            switch (dir)
            {
                case 0:
                    y++;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    x--;
                    break;
            }
            index++;
        }
    } 
}
