package Week1;

public class HelloGoodbye {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello " + args[0] + " and " + args[1] + ".");
            System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
        } else {
            System.out.println("No input arguments provided!");
        }
    }
}
