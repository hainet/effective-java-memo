import java.math.BigInteger;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Randoms {

    public static void main(final String[] args) {
        random();
        splittableRandom();
        threadLocalRandom();
    }

    private static void random() {
        final long start = System.currentTimeMillis();

        System.out.println(new Random().ints(10_000_000, 0, 10_000_000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count());

        System.out.println("Processed in " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void splittableRandom() {
        final long start = System.currentTimeMillis();

        System.out.println(new SplittableRandom().ints(10_000_000, 0, 10_000_000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count());

        System.out.println("Processed in " + (System.currentTimeMillis() - start) + "ms");
    }

    private static void threadLocalRandom() {
        final long start = System.currentTimeMillis();

        System.out.println(ThreadLocalRandom.current().ints(10_000_000, 0, 10_000_000)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count());

        System.out.println("Processed in " + (System.currentTimeMillis() - start) + "ms");
    }
}
