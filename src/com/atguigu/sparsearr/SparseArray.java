package com.atguigu.sparsearr;

public class SparseArray {
    public static void main(String[] args) {
        // create an 2D array 11*11
        // 0: no chess, 1: black, 2: blue
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        System.out.println("Original 2D array: ");
        for(int[] row: chessArr1){
            for(int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 1. Go through 2D array and get the number of non-zero val
        int sum = 0;
        for(int i = 0; i < 11;i++){
            for(int j = 0; j < 11;j++){
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        // 2. Create sparse array
        int[][] sparseArr = new int[sum+1][3];
        // assign value
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 3. Go through 2D array and get the value of non-zero val
        int count = 0;
        for(int i = 0; i < 11;i++){
            for(int j = 0; j < 11;j++){
                if(chessArr1[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // print sparse array
        System.out.println();
        System.out.println("Sparse array is:");
        for (int[] row : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", row[0], row[1], row[2]);
        }

        // convert sparse array to 2D array
        int[][] chessArr2 = new int [sparseArr[0][0]][sparseArr[0][1]];


        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println();
        System.out.println("Original 2D array is");

        for(int[] row: chessArr2){
            for(int data: row){
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
