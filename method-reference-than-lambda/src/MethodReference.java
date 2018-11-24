import java.util.HashMap;
import java.util.Map;

public class MethodReference {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // keyに対応する値はないため、値は1となる。
        map.merge("key", 1, (a, b) -> a + b);
        System.out.println(map.get("key"));

        // keyに対応する値があるため、ラムダの定義に従って計算された値となる。
        map.merge("key", 1, (a, b) -> a + b);
        System.out.println(map.get("key"));

        // 必要に応じてラムダの定義を記述することは誤りを生む。
        // また、操作を命名するためにメソッドとして切り出すことができる。
        map.merge("key", 1, (a, b) -> MethodReference.sum(a, b));
        System.out.println(map.get("key"));

        // ラムダの引数とラムダの返り値の型が一致するメソッドでメソッド参照に置き換えられる。
        map.merge("key", 1, MethodReference::sum);
        System.out.println(map.get("key"));

        // もっとも、このような標準的な計算はJavaが提供しているが...
        map.merge("key", 1, Integer::sum);
        System.out.println(map.get("key"));

        // パラメータ名が有益なドキュメントになる場合にはラムダを用いても良い。
        map.merge("key", 10, (original, addend) -> {
            System.out.println("original: " + original);
            System.out.println("addend: " + addend);

            return original + addend;
        });
        System.out.println(map.get("key"));
    }

    private static int sum(final int a, final int b) {
        return a + b;
    }
}
