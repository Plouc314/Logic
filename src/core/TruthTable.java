package core;

import java.util.List;
import java.util.Map;

import schemas.Node;

public class TruthTable {
    public Node exp;
    private Map<Integer, Boolean> values;

    TruthTable(Node exp, Map<Integer, Boolean> values) {
        this.exp = exp;
        this.values = values;
    }

    private String buildLineValue(boolean[] perm, boolean value, int space) {
        String line = "|";
        for (boolean v : perm) {
            line += " " + (v ? "T" : "F") + " |";
        }

        for (int i = 0; i < space / 2; i++) {
            line += " ";
        }
        line += value ? "T" : "F";
        for (int i = 0; i < (space + 1) / 2; i++) {
            line += " ";
        }
        line += " |\n";

        return line;
    }

    public String toString() {
        List<Character> props = this.exp.getPropositions();
        String expString = this.exp.toString();
        String table = "";

        // build header
        table += "|";
        for (char prop : props) {
            table += " " + prop + " |";
        }
        table += " " + expString + " |\n";

        int headerLength = table.length() - 1;
        for (int i = 0; i < headerLength; i++) {
            table += "-";
        }
        table += "\n";

        boolean[] perm;

        for (var entry : this.values.entrySet()) {
            perm = Util.unhash(entry.getKey(), props.size());
            table += buildLineValue(perm, entry.getValue(), expString.length());
        }
        return table;
    }
}
