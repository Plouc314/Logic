package core;

import schemas.Node;

public class Engine {
    public static Node getCNF(Node exp) {
        TruthTable table = exp.getTruthTable();

        return new Proposition('a');
    }
}
