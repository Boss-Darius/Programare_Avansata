package TimeKeeper;

public class TimeKeeperThread implements Runnable{
    private int limit;

    public TimeKeeperThread(int limit){
        this.limit=limit;
    }

    public void run(){
        int seconds=0;
        for (seconds = 0; seconds < limit; seconds++) {
            try {
                Thread.sleep(1000);
                seconds++;
            } catch (InterruptedException e) {
                System.err.println("Eroare la sleep");
            }
        }

        if(seconds>=limit){
            System.out.println(limit+" seconds have pasted(limit reached)");
        }

        else{
            System.out.println(seconds+" have pasted(limit hasn't been reached)");
        }
    }
}
