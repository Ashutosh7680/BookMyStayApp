
public class UseCase2RoomInitialization {

    public static abstract class Room {
        protected String roomType;
        protected int numberOfBeds;
        protected double size; // in square meters
        protected double price; // per night

        public Room(String roomType, int numberOfBeds, double size, double price) {
            this.roomType = roomType;
            this.numberOfBeds = numberOfBeds;
            this.size = size;
            this.price = price;
        }

        public String getRoomType() {
            return roomType;
        }

        public int getNumberOfBeds() {
            return numberOfBeds;
        }

        public double getSize() {
            return size;
        }

        public double getPrice() {
            return price;
        }

        public abstract String getDescription();
    }

    public static class SingleRoom extends Room {
        public SingleRoom() {
            super("Single", 1, 20.0, 100.0);
        }

        @Override
        public String getDescription() {
            return "A comfortable single room perfect for solo travelers.";
        }
    }

    public static class DoubleRoom extends Room {
        public DoubleRoom() {
            super("Double", 2, 30.0, 150.0);
        }

        @Override
        public String getDescription() {
            return "A spacious double room ideal for couples or friends.";
        }
    }

    public static class SuiteRoom extends Room {
    
        public SuiteRoom() {
            super("Suite", 2, 50.0, 300.0);
        }

        @Override
        public String getDescription() {
            return "A luxurious suite with premium amenities and extra space.";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Book My Stay App - Use Case 2 ===");
        System.out.println("Welcome to Hotel Booking System v2.1");
        System.out.println();

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;


        System.out.println("=== Room Types & Availability ===");
        System.out.println();

        displayRoomInfo(singleRoom, singleRoomAvailable);
        System.out.println();
        displayRoomInfo(doubleRoom, doubleRoomAvailable);
        System.out.println();
        displayRoomInfo(suiteRoom, suiteRoomAvailable);

        System.out.println();
        System.out.println("Application terminated successfully.");
    }


    private static void displayRoomInfo(Room room, int available) {
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Description: " + room.getDescription());
        System.out.println("Number of Beds: " + room.getNumberOfBeds());
        System.out.println("Size: " + room.getSize() + " sqm");
        System.out.println("Price per Night: $" + room.getPrice());
        System.out.println("Available Rooms: " + available);
    }
}