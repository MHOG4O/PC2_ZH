import java.util.ArrayList;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix ={{ 84,  67,  22, -72,  95},
                { 72, -70,   2, -88,  30},
                { 95, -79, -87, -27, -97},
                {-52, -64, -13, -19, -27},
                {  0,   0,   0,   0,   0}};
        System.out.println("Nullsorok indexei: "+indexOfRowsWithZeros(matrix));
        System.out.println("5-tel oszthato elemek osszege: "+sumOfNumbersDivisibleByFive(matrix));
    }

    public static int sumOfNumbersDivisibleByFive(int[][] matrix){
        int osszeg=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]%5==0){
                    osszeg+=matrix[i][j];
                }
            }
        }
        return osszeg;
    }
    public static ArrayList<Integer> indexOfRowsWithZeros(int[][] matrix){
        ArrayList<Integer> indexes=new ArrayList<>();
        boolean van = false;
        int k=0;
        for(int i=0;i< matrix.length;i++){
            int j=0;
            if(matrix[i][j]==0){
                while(j<matrix.length){
                    if(matrix[i][j]==0){
                        k=i;
                        van=true;
                    }
                    j++;
                }
            }
            if(van==true){
                indexes.add(k+1);
                van=false;
            }

        }
        return indexes;
    }
}
