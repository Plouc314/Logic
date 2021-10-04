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
        return !this.leftNode.eval(values);
    }

    /** Special implementation -> no right node */
    public List<Character> getPropositions() {
        List<Character> props = new ArrayList<>();
        props.addAll(this.leftNode.getPropositions());
        return props;
    }

    public String toString() {
        return "¬" + this.leftNode.toString();
    }
}
