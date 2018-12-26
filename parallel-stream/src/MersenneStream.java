import java.math.BigInteger;
import java.util.stream.Stream;

public class MersenneStream {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger ONE = BigInteger.valueOf(1);

    public static void main(final String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                // 処理が終了しない。
                // .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
