import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class KindOfMethodReference {

    public static void main(String[] args) {
        // static参照
        // UnaryOperator<String> staticReference = (str) -> String.valueOf(str);
        UnaryOperator<String> staticReference = String::valueOf;
        // 受けたオブジェクトをメソッドの引数とする。
        System.out.println(staticReference.apply("StaticReference"));

        // バウンドインスタンス参照
        // 本質的にはstatic参照と似ている。
        // String created = "BoundInstance";
        // UnaryOperator<String> boundInstanceReference = (str) -> created.concat(str);
        UnaryOperator<String> boundInstanceReference = String.valueOf("BoundInstance")::concat;
        // 受けたオブジェクトをメソッドの引数とする。

        System.out.println(boundInstanceReference.apply("Reference"));

        // アンバウンドインスタンス参照
        // UnaryOperator<String> unboundInstanceReference = (str) -> str.toLowerCase();
        UnaryOperator<String> unboundInstanceReference = String::toLowerCase;
        // 受けたオブジェクトのメソッドを起動する。

        System.out.println(unboundInstanceReference.apply("UNBOUND_INSTANCE_REFERENCE"));

        // クラスコンストラクタ参照
        // UnaryOperator<String> classConstructorReference = (str) -> new String();
        UnaryOperator<String> classConstructorReference = String::new;
        // 受けたオブジェクトをコンストラクタの引数にしている。

        System.out.println(classConstructorReference.apply("ClassConstructorReference"));

        // 配列コンストラクタ参照
        // IntFunction<int[]> arrayConstructorReference = (i) -> new int[i];
        IntFunction<int[]> arrayConstructorReference = int[]::new;

        System.out.println(arrayConstructorReference.apply(3).length);
    }
}
