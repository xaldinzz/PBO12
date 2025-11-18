import java.util.ArrayList;
import java.util.List;
import java.util.Random; // BARU

/**
 * Kelas utama yang menjalankan simulasi.
 */
public class Simulator {
    private Field field;
    private List<Animal> animals;
    
    // BARU: Tambahan untuk membuat hewan secara acak
    private Random rand = new Random();
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;

    public Simulator(int depth, int width) {
        field = new Field(depth, width);
        animals = new ArrayList<>();
        populate(); // Sekarang method ini akan berjalan
    }

    public void simulate(int steps) {
        for (int step = 0; step < steps; step++) {
            List<Animal> newAnimals = new ArrayList<>();
            // Buat salinan daftar hewan untuk menghindari error
            List<Animal> currentAnimals = new ArrayList<>(animals); 
            
            for (Animal animal : currentAnimals) {
                if(animal.isAlive()) {
                    animal.act(newAnimals);
                }
            }
            // Hapus hewan yang mati
            animals.removeIf(animal -> !animal.isAlive());
            // Tambah hewan baru
            animals.addAll(newAnimals);
            
            // (Opsional) Tampilkan info di terminal
            System.out.println("Step: " + step + " | Jumlah Hewan: " + animals.size());
        }
    }

    /**
     * ⭐ KODE BARU DITAMBAHKAN ⭐
     * Mengisi field dengan Fox dan Rabbit secara acak.
     */
    private void populate() {
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Location location = new Location(row, col);
                double randomValue = rand.nextDouble();
                
                if (randomValue < FOX_CREATION_PROBABILITY) {
                    Fox fox = new Fox(field, location);
                    animals.add(fox);
                } 
                else if (randomValue < FOX_CREATION_PROBABILITY + RABBIT_CREATION_PROBABILITY) {
                    Rabbit rabbit = new Rabbit(field, location);
                    animals.add(rabbit);
                }
                // else: biarkan lokasi kosong
            }
        }
    }
    
    /**
     * ⭐ METHOD MAIN DITAMBAHKAN ⭐
     * Ini adalah cara untuk menjalankan program di BlueJ.
     */
    public static void main(String[] args) {
        // Buat simulator baru dengan ukuran grid 50x50
        Simulator sim = new Simulator(50, 50);
        
        // Jalankan simulasi untuk 100 langkah (step)
        // Anda bisa ubah angka ini
        sim.simulate(100);
        
        System.out.println("Simulasi selesai.");
    }
}