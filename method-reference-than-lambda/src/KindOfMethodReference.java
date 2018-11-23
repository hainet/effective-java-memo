public class KindOfMethodReference {

    public static void main(String[] args) {
        // static参照
        // Function staticReference = (str) -> String.valueOf(str);
        Function staticReference = String::valueOf;
        // 受けたオブジェクトをメソッドの引数としている。

        System.out.println(staticReference.run("StaticReference"));

        // バウンドインスタンス参照
        // 本質的にはstatic参照と似ている。
        // String created = "BoundInstance";
        // Function boundInstanceReference = (str) -> created.concat(str);
        Function boundInstanceReference = String.valueOf("BoundInstance")::concat;
        // 受けたオブジェクトをメソッドの引数としている。

        System.out.println(boundInstanceReference.run("Reference"));

        // アンバウンドインスタンス参照
        // Function unboundInstanceReference = (str) -> str.toLowerCase();
        Function unboundInstanceReference = String::toLowerCase;
        // 受けたオブジェクトのメソッドを起動している。

        System.out.println(unboundInstanceReference.run("UNBOUND_INSTANCE_REFERENCE"));

        // クラスコンストラクタ参照
        // Function classConstructorReference = (str) -> new String();
        Function classConstructorReference = String::new;
        // 受けたオブジェクトをコンストラクタの引数にしている。

        System.out.println(classConstructorReference.run("ClassConstructorReference"));

        // 配列コンストラクタ参照
        // IntegerArrayFunction arrayConstructorReference = (i) -> new int[i];
        IntegerArrayFunction arrayConstructorReference = int[]::new;

        System.out.println(arrayConstructorReference.run(3).length);
    }

    @FunctionalInterface
    interface Function {
        String run(String str);
    }

    @FunctionalInterface
    interface IntegerArrayFunction {
        int[] run(int i);
    }
}
