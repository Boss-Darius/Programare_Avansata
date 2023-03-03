public class Main {
    public static void main(String[] args) {
        Location iasi = new Location(300, 420, Locations.cities);
        System.out.println(iasi.toString());

        Road bulevardulIndependentei = new Road(Roads.highways, 200, 200);
        System.out.println(bulevardulIndependentei.toString());
    }
}
