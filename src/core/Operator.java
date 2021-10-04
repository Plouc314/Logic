package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.InvalidValues;
import schemas.Node;

public abstract class Operator implements Node {
    protected final Node leftNode;
    protected final Node rightNode;

    public Operator(Node node) {
        this.leftNode = node;
        this.rightNode = null;
    }

    public Operator(Node left, Node right) {
        this.leftNode = left;
        this.rightNode = right;
    }

    public boolean eval(Value... values) throws InvalidValues {

        Map<Character, Boolean> valuesMap = new HashMap<>();

        for (Value value : values) {
            valuesMap.put(value.name, value.value);
        }

        return eval(valuesMap);
    }

    public List<Character> getPropositions() {
        List<Character> props = new ArrayList<>();

        props.addAll(this.leftNode.getPropositions());

        // guarantees uniqueness
        for (char name : this.rightNode.getPropositions()) {
            if (!props.contains(name)) {
                props.add(name);
            }
        }

        return props;
    }

    public TruthTable getTruthTable() {

        List<Character> props = getPropositions();
        var permutations = Util.product(List.of(true, false), props.size());

        Map<Integer, Boolean> result = new HashMap<>();
        int hash;
        Map<Character, Boolean> values;

        for (var perm : permutations) {
            hash = Util.hash(perm);
            values = getValues(props, perm);
            try {
                result.put(hash, eval(values));
            } catch (InvalidValues e) {
                // should never happen
                continue;
            }
        }

        return new TruthTable(this, result);
    }

    private Map<Character, Boolean> getValues(List<Character> props, Collection<Boolean> permutation) {

        List<Boolean> poss = new ArrayList<>(permutation);
        Map<Character, Boolean> values = new HashMap<Character, Boolean>();

        for (int i = 0; i < props.size(); i++) {
            values.put(props.get(i), poss.get(i));
        }
        return values;
    }
}
