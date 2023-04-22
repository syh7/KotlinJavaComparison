package example.dataclass;

class RecordExample {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle(2);
        System.out.println("Bicycle has " + bicycle.tires() + " tires");

        Bicycle.changeable = true;

    }
}

record Bicycle(Integer tires) {

    public static Boolean changeable = false;

    public void ride() {
        System.out.println("I'm riding my bicyle");
    }
}
