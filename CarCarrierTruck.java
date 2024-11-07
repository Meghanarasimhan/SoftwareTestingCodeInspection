package assignment;

import java.util.Arrays;

class CarCarrierTruck {

    private String truckId; // 10 characters, uppercase letters and digits only

    private final int upperCapacity = 3;
    private final int lowerCapacity = 3;

    private Vehicle[] upperLevel;
    private Vehicle[] lowerLevel;

    private int upperCount = -1;
    private int lowerCount = -1;

    private static final String idRegex = "^[A-Z0-9]{10}$";


    public CarCarrierTruck(String id) throws InvalidParameterException {
        setTruckId(id);
    }

    /*
     * Set the truck ID.
     * The truck ID must be 10 uppercase letters and digits.
     */
    private void setTruckId(String truckId) throws InvalidParameterException {
        if (truckId.length() == 10) {
            this.truckId = truckId;
        } else {
            throw new InvalidParameterException("Truck ID must be 10 uppercase letters and digits.");
        }
    }

    /*
     * Load a vehicle onto the truck's upper level.
     * The location parameter is the index of the location
     * on the upper level where the vehicle will be loaded.
     * A position can only be loaded if it is empty.
     * If a position is blocked, the vehicle cannot be loaded.
     */
    public void loadUpperLevel(Vehicle vehicle, int location) throws InvalidParameterException {
        if (location < upperCount) {
            throw new InvalidParameterException("Location is occupied or blocked.");
        }
        upperLevel[location] = vehicle;
        upperCount = location;
        System.out.println(vehicle + " loaded onto the upper level of the truck.");
    }

    /*
     * Load a vehicle onto the truck's lower level.
     * The location parameter is the index of the location
     * on the upper level where the vehicle will be loaded.
     * A position can only be loaded if it is empty.
     * If a position is blocked, the vehicle cannot be loaded.
     */
    public void loadLowerLevel(Vehicle vehicle, int location) throws InvalidParameterException {
        if (location < lowerCount) {
            throw new InvalidParameterException("Location is occupied or blocked.");
        }
        lowerLevel[location] = vehicle;
        lowerCount = location;
        System.out.println(vehicle + " loaded onto the lower level of the truck.");
    }

    /*
     * Unload a vehicle from the upper level of the truck.
     * The location parameter is the index of the location
     * on the upper level where the vehicle will be unloaded.
     * A position can only be unloaded if it is occupied and not blocked.
     */
    public Vehicle unloadUpperLevel(int location) throws InvalidParameterException {
        Vehicle vehicle = upperLevel[location];
        upperLevel[location] = null;
        upperCount--;
        System.out.println(vehicle + " unloaded from the upper level of the truck.");
        return vehicle;
    }

    /*
     * Unload a vehicle from the lower level of the truck.
     * The location parameter is the index of the location
     * on the upper level where the vehicle will be unloaded.
     * A position can only be unloaded if it is occupied and not blocked.
     */
    public Vehicle unloadLowerLevel(int location) throws InvalidParameterException {
        Vehicle vehicle = lowerLevel[location];
        lowerLevel[location] = null;
        lowerCount--;
        System.out.println(vehicle + " unloaded from the lower level of the truck.");
        return vehicle;
    }

    /*
     * Check if the upper level of the truck is empty.
     */
    public boolean isUpperLevelEmpty() {
        return upperCount == -1;
    }

    /*
     * Check if the lower level of the truck is empty.
     */
    public boolean isLowerLevelEmpty() {
        return lowerCount == -1;
    }

    @Override
    public String toString() {
        return "CarCarrierTruck\n" +
                "\ttruckId='" + truckId + '\'' +
                ", upperCapacity=" + upperCapacity +
                ", lowerCapacity=" + lowerCapacity +
                "\n\tupperLevel=" + Arrays.toString(upperLevel) +
                "\n\tlowerLevel=" + Arrays.toString(lowerLevel) +
                "\n\tupperCount=" + upperCount +
                ", lowerCount=" + lowerCount;
    }
}