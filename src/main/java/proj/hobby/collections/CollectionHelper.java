package proj.hobby.collections;

import java.util.Arrays;
import java.util.stream.Stream;

public class CollectionHelper {

    public String[] concat(String[] first, String[] second) {
        return Stream.concat(Arrays.stream(first), Arrays.stream(second)).toArray(String[]::new);
    }
}
