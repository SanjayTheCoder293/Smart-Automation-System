package com.OopsConcept;
// 1. ABSTRACTION: An abstract class cannot be instantiated on its own
abstract class Device {
    private String name; // 2. ENCAPSULATION: Private variable

    Device(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    // Abstract method: Every child MUST implement this
    abstract void performAction();
}

// 2. INHERITANCE: Light "is-a" Device
class Light extends Device {
    Light(String name) { super(name); }

    @Override
    void performAction() { // 4. POLYMORPHISM: Specific behavior
        System.out.println(getName() + " is now illuminating at 5000K (Daylight).");
    }
}

// 2. INHERITANCE: Fan "is-a" Device
class Fan extends Device {
    Fan(String name) { super(name); }

    @Override
    void performAction() { // 4. POLYMORPHISM: Specific behavior
        System.out.println(getName() + " is spinning at Speed 3.");
    }
}

// The Central Hub that accepts objects as parameters
class SmartHub {
    // This method takes the Abstract class as a parameter, 
    // allowing it to accept any child (Light, Fan, etc.)
    void executeCommand(Device device) {
        System.out.print("HUB SIGNAL: ");
        device.performAction();
    }
}

// 3. MAIN CLASS
public class Oops_Anonymous {
    public static void main(String[] args) {
        SmartHub hub = new SmartHub();

        // --- PASSING ANONYMOUS OBJECTS AS PARAMETERS ---
        // We don't store these in variables. We create and pass them instantly.
        
        hub.executeCommand(new Light("Living Room LED")); 
        hub.executeCommand(new Fan("Master Bedroom Fan"));
        
        // Even a different type of light...
        hub.executeCommand(new Light("Kitchen Strip Light"));
    }
}