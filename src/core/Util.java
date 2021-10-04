package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Util {

    public static int hash(Collection<Boolean> values) {

        boolean[] arrayLike = new boolean[values.size()];

        int idx = 0;
        for (boolean value : values) {
            arrayLike[idx] = value;
            idx++;
        }

        return hash(arrayLike);
    }

    public static int hash(boolean[] values) {
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            result += (values[i] ? 1 : 0) * Math.pow(2, values.length - i - 1);
        }
        return result;
    }

    /** Doesn't handeln negative value */
    public static boolean[] unhash(int value, int size) {

        boolean[] result = new boolean[size];

        if (value <= 0) {
            return result;
        }

        int high;

        while (value > 0) {
            high = (int) Math.floor(Math.log(value) / Math.log(2));
            result[size - high - 1] = true;
            value -= Math.pow(2, high);
        }
        return result;
    }

    /**
     * https://stackoverflow.com/questions/63433335/java-alternative-of-product-function-of-python-form-itertools
     */
    public static <T> List<Collection<T>> product(Collection<T> a, int r) {
        List<Collection<T>> result = Collections.nCopies(1, Collections.emptyList());
        for (Collection<T> pool : Collections.nCopies(r, new LinkedHashSet<>(a))) {
            List<Collection<T>> temp = new ArrayList<>();
            for (Collection<T> x : result) {
                for (T y : pool) {
                    Collection<T> z = new ArrayList<>(x);
                    z.add(y);
                    temp.add(z);
                }
            }
            result = temp;
        }
        return result;
    }
}
