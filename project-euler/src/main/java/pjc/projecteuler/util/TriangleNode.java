package pjc.projecteuler.util;

/**
 * Represents one number in a triangle structure of numbers.
 * 
 * Used for problem 18
 * @author Phil
 */
public class TriangleNode {
    private static int pathCount = 0;
    private TriangleNode leftChild = null;
    private TriangleNode rightChild = null;
    private int value;
    
    public TriangleNode(TriangleNode left, TriangleNode right, int val) {
        leftChild = left;
        rightChild = right;
        value = val;
    }
    
    /**
     * Finds the maximum sum of elements to go from top to bottom of triangle  
     * @return
     */
    public int go() {
        int aggregateValue = -1;// move this to private member to reduce paths 
        if (aggregateValue == -1) {
            int leftVal = 0;
            int rightVal = 0;
            if (leftChild != null && rightChild != null) {
                leftVal =  leftChild.go();
                rightVal =  rightChild.go();
            } else {
                pathCount++;
            }
            aggregateValue = value + Math.max(leftVal, rightVal);
        }
        return aggregateValue;
    }
    
    public static int getPathCount() {
        return pathCount;
    }
}
