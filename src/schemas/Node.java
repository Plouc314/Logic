package schemas;

import java.util.List;
import java.util.Map;

import core.TruthTable;
import core.Value;
import exceptions.InvalidValues;

public interface Node {
    boolean eval(Value... values) throws InvalidValues;

    boolean eval(Map<Character, Boolean> values) throws InvalidValues;

    List<Character> getPropositions();

    TruthTable getTruthTable();

    String toString();
}
