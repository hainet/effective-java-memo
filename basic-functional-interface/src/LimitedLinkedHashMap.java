import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final BiPredicate<Map<K, V>, Map.Entry<K, V>> p;

    public LimitedLinkedHashMap(BiPredicate<Map<K, V>, Map.Entry<K, V>> p) {
        this.p = p;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return p.test(this, eldest);
    }
}
