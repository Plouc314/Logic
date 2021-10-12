
import core.*;
import exceptions.*;
import operators.*;
import schemas.*;

public class App {

    public static void main(String args[]) throws InvalidValues {

        Proposition w = new Proposition('w');
        Proposition x = new Proposition('x');
        Proposition y = new Proposition('y');
        Proposition z = new Proposition('z');

        TruthTable result;
        Node exp;

        exp = new Bid(w, x, y, z);
        result = exp.getTruthTable();
        System.out.println(result.toString());

        exp = new Bid(x, new Bid(y, z));
        result = exp.getTruthTable();
        System.out.println(result.toString());

        // boolean r = exp.eval(new Value('x', false), new Value('y', true), new
        // Value('z', false));
    }
}
