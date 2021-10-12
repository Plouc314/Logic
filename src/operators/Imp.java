package operators;

import java.util.Map;

import core.Operator;
import exceptions.InvalidValues;
import schemas.Node;

public class Imp extends Operator {

    public Imp(Node left, Node right) {
        super(left, right);
    }

    public boolean eval(Map<Character, Boolean> values) throws InvalidValues {
        return !this.nodes.get(0).eval(values) || this.nodes.get(1).eval(values);
    }

    public String toString() {
        return "(" + this.nodes.get(0).toString() + " ⇒ " + this.nodes.get(1).toString() + ")";
    }
}
