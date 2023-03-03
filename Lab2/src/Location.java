public class Location {
    private Locations type;
    private int coordonateX;
    private int coordonateY;

    public Location(int x, int y, Locations place) {
        this.coordonateX = x;
        this.coordonateY = y;
        this.type = place;
    }

    public int getCoordonateX() {
        return coordonateX;
    }

    public void setCoordonateX(int coordonateX) {
        this.coordonateX = coordonateX;
    }

    public void setType(Locations type) {
        this.type = type;
    }

    public int getCoordonateY() {
        return coordonateY;
    }

    public void setCoordonateY(int coordonateY) {
        this.coordonateY = coordonateY;
    }

    public Locations getType() {
        return type;
    }

    @Override
    public String toString() {
        String description = "type=type of location \n coordonateX=x coordonate \n coordonateY=y coordonate";
        return description;
    }
}
