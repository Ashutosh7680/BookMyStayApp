
import java.util.HashMap;

public class UseCase3InventorySetup {

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

    
    public static class RoomInventory {
        private HashMap<String, Integer> inventory;

       
        public RoomInventory() {
            inventory = new HashMap<>();
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        
        public int getAvailableRooms(String roomType) {
            return inventory.getOrDefault(roomType, 0);
        }

       
        public void updateAvailability(String roomType, int count) {
            inventory.put(roomType, count);
        }

       
        public boolean decreaseAvailability(String roomType, int decrease) {
            int current = getAvailableRooms(roomType);
            if (current >= decrease) {
                updateAvailability(roomType, current - decrease);
                return true;
            }
            return false;
        }

        
        public void increaseAvailability(String roomType, int increase) {
            int current = getAvailableRooms(roomType);
            updateAvailability(roomType, current + increase);
        }

        public void displayInventory() {
            System.out.println("Current Room Inventory:");
            for (String roomType : inventory.keySet()) {
                System.out.println(roomType + ": " + inventory.get(roomType) + " available");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Book My Stay App - Use Case 3 ===");
        System.out.println("Welcome to Hotel Booking System v3.0");
        System.out.println();

        RoomInventory inventory = new RoomInventory();

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        System.out.println("=== Initial Room Inventory ===");
        inventory.displayInventory();
        System.out.println();

        System.out.println("=== Room Types & Availability ===");
        System.out.println();

        displayRoomInfo(singleRoom, inventory.getAvailableRooms("Single"));
        System.out.println();
        displayRoomInfo(doubleRoom, inventory.getAvailableRooms("Double"));
        System.out.println();
        displayRoomInfo(suiteRoom, inventory.getAvailableRooms("Suite"));
        System.out.println();

        System.out.println("=== Inventory Updates Demo ===");
        System.out.println("Booking 2 Single rooms...");
        if (inventory.decreaseAvailability("Single", 2)) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed - insufficient availability.");
        }

        System.out.println("Adding 1 Double room back to inventory...");
        inventory.increaseAvailability("Double", 1);

        System.out.println();
        System.out.println("=== Updated Room Inventory ===");
        inventory.displayInventory();

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