public class Road {
    private Roads type;
    private int speedLimit;
    private int length;

    public Road(Roads type, int speedLimit, int length) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.length = length;
    }

    public void setType(Roads type) {
        this.type = type;
    }

    public Roads getType() {
        return type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    @Override
    public String toString() {
        String description = "Speed limit : " + this.speedLimit;
        return super.toString();
    }
}
