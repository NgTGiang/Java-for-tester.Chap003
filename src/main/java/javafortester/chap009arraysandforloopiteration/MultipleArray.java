package javafortester.chap009arraysandforloopiteration;

public class MultipleArray {
    public void print2DIntArray(int[][] multi){
        for(int[] outer : multi){
            if(outer == null){
                System.out.print("null");
            } else{
                for(int inner : outer){
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }
}
