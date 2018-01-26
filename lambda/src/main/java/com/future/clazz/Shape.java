package com.future.clazz;

/**
 * @description this is just a full copy code from stack overflow website
 * @date 2018-01-20 11:18
 * @see <a href="http://pyyaml.org/wiki/PyYAML">PyYAML</a> for more information
 * @see <a>https://stackoverflow.com/questions/20252727/is-not-an-enclosing-class-java</a>
 *          for more discussion about this problem
 */
public class Shape {

    private String shape;
    private int[][] coords;
    private int[][] noShapeCoords = { { 0, 0 }, { 0, 0 }, { 0, 0 }, { 0, 0 } };
    private static final int[][] zShapeCoords = { { 0, -1 }, { 0, 0 }, { -1, 0 }, { -1, 1 } };
    private int[][] sShapeCoords = { { 0, -1 }, { 0, 0 }, { 1, 0 }, { 1, 1 } };
    private int[][] lineShapeCoords = { { 0, -1 }, { 0, 0 }, { 0, 1 }, { 0, 2 } };
    private int[][] tShapeCoords = { { -1, 0 }, { 0, 0 }, { 1, 0 }, { 0, 1 } };
    private int[][] squareShapeCoords = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 } };
    private int[][] lShapeCoords = { { -1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } };
    private int[][] mirroredLShapeCoords = { { 1, -1 }, { 0, -1 }, { 0, 0 }, { 0, 1 } };

    public Shape(){
        int[][] coords =  noShapeCoords;
        shape = "NoShape";
    }

    static class ZShape {
        int[][] coords =  zShapeCoords;
        String shape = "ZShape";
    }

    class SShape {
        int[][] coords = sShapeCoords;
        String shape = "SShape";
    }

    //etc

    public static void main(String[] args) {
        // stupid!
        /*
         * first ZShape class is not a static inner class
         * second there is still a incompatible type issue even if we claim ZShape static
         * third the field zShapeCoords declared in Shape is non-static even if claim ZShape static
         * fourth we'd better declared field zShapeCoords final if there is no change to be allowed for it
         */
//        Shape s = new Shape.ZShape();
        ZShape zs = new  Shape.ZShape();
    }


}
