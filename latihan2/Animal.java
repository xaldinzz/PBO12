import java.util.List;

/**
 * Kelas abstract Animal, mewakili semua hewan di simulasi.
 */
public abstract class Animal {
    private int age;
    private boolean alive;
    private Field field;
    private Location location;

    public Animal(Field field, Location location) {
        this.age = 0;
        this.alive = true;
        this.field = field;
        setLocation(location);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        if (newLocation != null) { 
            field.place(this, newLocation);
        }
    }
    
    protected Field getField() {
        return field;
    }

    /**
     * Method abstract yang harus diimplementasikan oleh subclass.
     */
    public abstract void act(List<Animal> newAnimals);
}