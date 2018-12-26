import java.math.BigInteger;
import java.util.stream.LongStream;

public class PrimeStream {

    // 並列動作中のCPU使用率に注目。
    public static void main(final String[] args) {
        final long start = System.currentTimeMillis();

        LongStream.rangeClosed(2, 5_000_000)
                // 有効な並列化となる。
                // .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                // 348,543個の1,000個を計算するだけで大きな計算時間を使う。
                // .limit(1_000)
                .forEachOrdered(System.out::println);

        System.out.println("Processed in " + (System.currentTimeMillis() - start) + "ms");
    }
}
