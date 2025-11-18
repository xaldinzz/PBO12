public class Main {
    public static void main(String[] args) {
        // Humans
        Human programmer = new Programmer("Alice");
        Human doctor = new Doctor("Bob");

        programmer.breathe();
        programmer.grow();
        programmer.speak();
        
        System.out.println(); // Kasih spasi

        doctor.breathe();
        doctor.grow();
        doctor.speak();
        
        System.out.println(); // Kasih spasi

        // Animals
        Animal dog = new Dog("Buddy");
        Animal bird = new Bird("Tweety");

        dog.breathe();
        dog.grow();
        dog.move();
        
        System.out.println(); // Kasih spasi

        bird.breathe();
        bird.grow();
        bird.move();
        
        System.out.println(); // Kasih spasi

        // Plants
        Plant rose = new FloweringPlant("Rose");
        Plant fern = new NonFloweringPlant("Fern");

        rose.breathe();
        rose.grow();
        rose.photosynthesize();
        
        System.out.println(); // Kasih spasi

        fern.breathe();
        fern.grow();
        fern.photosynthesize();
    }
}