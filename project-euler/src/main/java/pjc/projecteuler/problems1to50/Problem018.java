package pjc.projecteuler.problems1to50;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import pjc.projecteuler.util.TriangleNode;

/**
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3 
 * Need to read in lines from bottom. Each node calculates a value based on its value
 * plus the max value of its two children
 * @author 362516
 *
 */
public class Problem018 {
	public class Node {
		private int max;
		public Node(int i) {
			max = i;
		}
		public int getMax() {
			return max;
		}
        public Node(String s) {
            max = Integer.valueOf(s).intValue();
        }
        public Node(int i, Node node, Node node2) {
            max = i + Math.max(node.getMax(), node2.getMax());
        }
        public Node(String s, Node node, Node node2) {
            int i = Integer.valueOf(s).intValue();
            max = i + Math.max(node.getMax(), node2.getMax());
        }
	}
	
    public static void main(String[] args) {
        try {
            String filename = "triangle_problem67.txt";
            List<String> lines = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
            String s  = null;
            while ((s = reader.readLine()) != null) {
                lines.add(0, s);
            }
            reader.close();
            (new Problem018()).go(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void go(List<String> lines) {
        Node[] previousRow = new Node[lines.size()+1];
        String s0 = lines.get(0);
        StringTokenizer st0 = new StringTokenizer(s0);
        for (int j = 0; st0.hasMoreTokens(); j++) {
            previousRow[j] = new Node (st0.nextToken());
        }
        
        
        Node[] currentRow = new Node[lines.size()];
        for (int i = 1; i < lines.size(); i++) {
            String s = lines.get(i);
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; st.hasMoreTokens(); j++) {
                currentRow[j] = new Node (st.nextToken(), previousRow[j], previousRow[j+1]);
            }
            previousRow = currentRow;
        }
        System.out.println(currentRow[0].getMax());
    }
    public static void oldApproach() {
        TriangleNode n7 = new TriangleNode(null, null, 2);
        TriangleNode n8 = new TriangleNode(null, null, 9);
        TriangleNode n9 = new TriangleNode(null, null, 8);
        TriangleNode n10 = new TriangleNode(null, null, 3);
        TriangleNode n1 = new TriangleNode(n7, n8, 1);
        TriangleNode n2 = new TriangleNode(n8, n9, 2);
        TriangleNode n3 = new TriangleNode(n9, n10, 5);
        TriangleNode n4 = new TriangleNode(n1, n2, 4);
        TriangleNode n5 = new TriangleNode(n2, n3, 2);
        TriangleNode n6 = new TriangleNode(n4, n5, 3);
        System.out.println(n6.go());
        System.out.println(TriangleNode.getPathCount());
    	
    }
}