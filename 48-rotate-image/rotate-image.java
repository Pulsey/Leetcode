class Solution {
    public void rotate(int[][] matrix) {   
        int n=matrix.length-1;
        for(int j=0;j<=n/2;j++){
            for(int i=j;i<n-j;i++){     
                int temp1, temp2;
                temp1=matrix[i][n-j];
                matrix[i][n-j]=matrix[j][i];
                temp2=matrix[n-j][n-i];
                matrix[n-j][n-i]=temp1;
                temp1=matrix[n-i][j];
                matrix[n-i][j]=temp2;
                matrix[j][i]=temp1;
            }
         }
        
    }
}