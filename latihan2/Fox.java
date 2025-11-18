import java.util.List;

/**
 * Subclass Fox.
 */
public class Fox extends Animal {

    public Fox(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = findFood();
            
            if (newLocation == null) {
                // No food found - try to move
                newLocation = getField().freeAdjacentLocation(getLocation());
            }

            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Can't move and no food: dies
                setDead();
            }
        }
    }

    /**
     * Mencari Rabbit di lokasi sekitar.
     * Jika ditemukan, Rabbit akan 'dimakan' (setDead).
     */
    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        for (Location loc : adjacent) {
            Object animal = getField().getObjectAt(loc);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                rabbit.setDead();
                return loc; // Pindah ke lokasi rabbit
            }
        }
        return null;
    }
}