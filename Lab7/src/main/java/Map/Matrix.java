package Map;

import java.util.Arrays;

public class Matrix {
    private boolean[][] accesible;
    private int [][][] area;
    private int dimension;

    private int unexplored;
    public Object Lock1;
    public Object Lock2;

    public Matrix(int dimension){

        this.dimension=dimension;
        accesible=new boolean[dimension][dimension];
        initializeAccesible();
        area=new int [dimension][dimension][dimension];
        unexplored=dimension*dimension;
        Lock1=new Object();
        Lock2=new Object();

        int [] zero=new int[dimension];

        for (int i = 0; i < dimension; i++) {
            zero[i]=0;
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                area[i][j]=zero.clone();
            }
        }
    }

    public void initializeAccesible(){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                accesible[i][j]=true;
            }
        }
    }


    public void getToCell(int x,int y,int [] newValue){
        int[] coordonates=new int[2];
        int [] zero=new int[getDimension()];

        for (int i = 0; i < getDimension(); i++) {
            zero[i]=0;
        }
        synchronized (getLock1()){
            while(!getAccesible()[x][y]) {
                try {
                    getLock1().wait();
                } catch (InterruptedException e) {
                    System.err.println("Eroare la wait");
                }
            }
            if(Arrays.equals(getArea()[x][y], zero)){
                decrementUnexplored();
                System.arraycopy(newValue,0,area[x][y],0,dimension);
            }
            getAccesible()[x][y]=false;
            getLock1().notifyAll();
        }
    }

    public  void moveFromCell(int x,int y){
        synchronized (getLock2()){
            while(getAccesible()[x][y]){
                try{
                    getLock2().wait();
                }catch (InterruptedException e){
                    System.err.println("Eroare la wait din move");
                }
            }

            getAccesible()[x][y]=true;
            getLock2().notifyAll();
        }
    }


    public int[][][] getArea() {
        return area;
    }

    public int getDimension() {
        return dimension;
    }

    public Object getLock1() {
        return Lock1;
    }

    public Object getLock2() {
        return Lock2;
    }

    public boolean[][] getAccesible() {
        return accesible;
    }

    public int getUnexplored() {
        return unexplored;
    }
    public void decrementUnexplored(){
        unexplored=unexplored-1;
    }
}
