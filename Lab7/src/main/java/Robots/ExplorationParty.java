package Robots;

public class ExplorationParty {
    private String name;
    private ThreadGroup searchers;

    private boolean stop;

    public ExplorationParty(String name, ThreadGroup searchers){
        this.name=name;
        this.searchers=searchers;
        stop=true;
    }
    

    public ThreadGroup getSearchers() {
        return searchers;
    }

    public String getName() {
        return name;
    }
}
