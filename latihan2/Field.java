import java.util.List;
import java.util.ArrayList;

/**
 * Merepresentasikan lapangan (grid) 2D.
 */
public class Field {
    private Object[][] field;
    private int depth; // BARU
    private int width; // BARU

    public Field(int depth, int width) {
        this.depth = depth; // BARU
        this.width = width; // BARU
        field = new Object[depth][width];
    }
    
    // Getter ditambahkan agar kelas lain bisa tahu ukuran field
    public int getDepth() { // BARU
        return depth;
    }
    
    public int getWidth() { // BARU
        return width;
    }

    public void clear(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location) {
        field[location.getRow()][location.getCol()] = object;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public Location freeAdjacentLocation(Location location) {
        List<Location> free = new ArrayList<>();
        List<Location> adjacent = adjacentLocations(location); // Ini sekarang berfungsi
        
        for (Location loc : adjacent) {
            if (getObjectAt(loc) == null) {
                free.add(loc);
            }
        }
        
        return free.isEmpty() ? null : free.get(0);
    }

    /**
     * ⭐ KODE BARU DITAMBAHKAN ⭐
     * Mengembalikan daftar semua lokasi yang valid di sekitar (8 arah).
     */
    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        int row = location.getRow();
        int col = location.getCol();
        
        // Loop di 8 kotak sekitar lokasi
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                // Lewati lokasi
                if (r == row && c == col) {
                    continue; 
                }
                // Cek apakah lokasi ada di dalam batas field
                if (r >= 0 && r < depth && c >= 0 && c < width) {
                    locations.add(new Location(r, c));
                }
            }
        }
        return locations;
    }
}