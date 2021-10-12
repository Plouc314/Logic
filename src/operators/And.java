package operators;

import java.util.Map;

import core.Operator;
import exceptions.InvalidValues;
import schemas.Node;

public class And extends Operator {

    public And(Node... nodes) {
        super(nodes);
    }

    public boolean eval(Map<Character, Boolean> values) throws InvalidValues {
        boolean result = this.nodes.get(0).eval(values);
        for (int i = 1; i < this.nodes.size(); i++) {
            result = result && this.nodes.get(i).eval(values);
        }
        return result;
    }

    public String toString() {
        String result = "( ";
        int s = this.nodes.size();
        Node node;
        for (int i = 0; i < s - 1; i++) {
            node = this.nodes.get(i);
            result += node.toString() + " ∧ ";
        }
        result += this.nodes.get(s - 1).toString() + " )";
        return result;
    }
}
