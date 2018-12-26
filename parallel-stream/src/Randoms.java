import java.math.BigInteger;
import java.util.Random;
import java.util.SplittableRandom;

public class Randoms {

    public static void main(final String[] args) {
        splittableRandom();
        random();
    }

    private static void random() {
        final long start = System.currentTimeMillis();

        new Random().ints(10_000_000, 0, 10_000_000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .forEachOrdered(System.out::println);

        System.out.println("Processed in " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void splittableRandom() {
        final long start = System.currentTimeMillis();

        new SplittableRandom().ints(10_000_000, 0, 10_000_000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .forEachOrdered(System.out::println);

        System.out.println("Processed in " + (System.currentTimeMillis() - start) + "ms");
    }
}
