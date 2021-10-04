package operators;

import java.util.Map;

import core.Operator;
import exceptions.InvalidValues;
import schemas.Node;

public class And extends Operator {

    public And(Node left, Node right) {
        super(left, right);
    }

    public boolean eval(Map<Character, Boolean> values) throws InvalidValues {
        return this.leftNode.eval(values) && this.rightNode.eval(values);
    }

    public String toString() {
        return "(" + this.leftNode.toString() + " ∧ " + this.rightNode.toString() + ")";
    }
}
