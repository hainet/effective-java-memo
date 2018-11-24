import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final Map<Integer, Integer> map = new LimitedLinkedHashMap<>((m, e) -> m.size() > 3);

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);

        System.out.println(map);
    }
}
