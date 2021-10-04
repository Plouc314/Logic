package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.InvalidValues;
import operators.Not;
import schemas.Node;

public class Proposition implements Node {
    final char name;

    public Proposition(char name) {
        this.name = name;
    }

    /** Shortcut for new Not(...) */
    public Not not() {
        return new Not(this);
    }

    public boolean eval(Value... values) throws InvalidValues {
        for (Value value : values) {
            if (value.name == this.name) {
                return value.value;
            }
        }
        throw new InvalidValues("Missing key '" + this.name + "' in values.");
    }

    public boolean eval(Map<Character, Boolean> values) throws InvalidValues {
        if (!values.containsKey(this.name)) {
            throw new InvalidValues("Missing key '" + this.name + "' in values.");
        }

        return values.get(this.name);
    }

    public List<Character> getPropositions() {
        List<Character> props = new ArrayList<>();
        props.add(this.name);
        return props;
    }

    public TruthTable getTruthTable() {
        Map<Integer, Boolean> values = new HashMap<>();
        values.put(0, false);
        values.put(1, true);
        return new TruthTable(this, values);
    }

    public String toString() {
        return String.valueOf(this.name);
    }

}
