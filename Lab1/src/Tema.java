import java.util.*;
public class Tema
{
    public static int[][] latinSquare(int dimension)
    {
        long start=System.nanoTime();
        int[][] matrix=new int[dimension][dimension];

        for (int row = 0; row < dimension; row++)
        {
            for (int column = 0; column <dimension ; column++)
            {
                if(row+column>=dimension)
                {
                    matrix[row][column]=row+column-dimension+1;
                }
                else
                {
                    matrix[row][column]=row+column+1;
                }
            }
        }

        if(dimension>30_000)
        {
            System.out.println("Nanoseconds: "+Long.toString(System.nanoTime()-start));
        }
        return matrix;
    }

    public static void showLines(int[][] array)
    {
        System.out.println("Showing the lines:");
        String line="";
        for (int row = 0; row <array.length ; row++)
        {
            for (int column = 0; column < array.length ; column++)
            {
                line=line + Integer.toString(array[row][column]);
            }
            System.out.println(line);
            line="";
        }

    }

    public static void showColumns(int[][] array)
    {
        System.out.println("Showing the columns:");
        String line="";
        for (int row = 0; row <array.length ; row++)
        {
            for (int column = 0; column < array.length ; column++)
            {
                line=line + Integer.toString(array[column][row]);
            }
            System.out.println(line);
            line="";
        }

    }
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("N=");
        int number=input.nextInt();

        int[][] matrix=new int[number][number];

        matrix=latinSquare(number);
        showLines(matrix);
        showColumns(matrix);

    }
}