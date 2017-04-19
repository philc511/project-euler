package pjc.projecteuler;
import java.util.ArrayList;
import java.util.List;

public class Problem {
    public class Node {
        private int maxTotal = -1;

        public Node(int value) {
            maxTotal = value;
        }
        public Node(int value, Node leftChild, Node rightChild) {
            this.maxTotal = value + Math.max(leftChild.getMaxTotal(), rightChild.getMaxTotal());
        }
        public int getMaxTotal() {
            return this.maxTotal;
        }
    }

    public static void main(String[] args) {
        Problem p = new Problem();
        
        int[] row1 = new int[]{3};
        int[] row2 = new int[]{7,4};
        int[] row3 = new int[]{2,4,6};
        int[] row4 = new int[]{8,5,9,3};
        
        List<Node> nodes4 = p.getNodes(null, row4);
        List<Node> nodes3 = p.getNodes(nodes4, row3);
        List<Node> nodes2 = p.getNodes(nodes3, row2);
        List<Node> nodes1 = p.getNodes(nodes2, row1);
        
        System.out.println(nodes1.get(0).getMaxTotal());
    }
    private List<List<Integer>> readFile()
    {
        return null;
    }
    private List<Node> getNodes(List<Node> childNodes, int[] values) {
        if (childNodes != null && (values.length+1) != childNodes.size()) {
            throw new IllegalArgumentException("Sizes of node lists are wrong");
        }
        List<Node> nodes = new ArrayList<Node>();
        for (int i = 0 ; i < values.length ; i++) {
            if (childNodes == null) {
                nodes.add(new Node(values[i]));
            } else {
                nodes.add(new Node(values[i], childNodes.get(i), childNodes.get(i+1)));
            }
        }
        
        return nodes;
    }
}


