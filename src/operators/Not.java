package operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import core.Operator;
import exceptions.InvalidValues;
import schemas.Node;

public class Not extends Operator {

    public Not(Node node) {
        super(node);
    }

    public boolean eval(Map<Character, Boolean> values) throws InvalidValues {
        return !this.nodes.get(0).eval(values);
    }

    /** Special implementation -> no right node */
    public List<Character> getPropositions() {
        List<Character> props = new ArrayList<>();
        props.addAll(this.nodes.get(0).getPropositions());
        return props;
    }

    public String toString() {
        return "¬" + this.nodes.get(0).toString();
    }
}
