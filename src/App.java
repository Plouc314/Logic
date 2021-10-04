
import core.*;
import exceptions.*;
import operators.*;
import schemas.*;

public class App {

    public static void main(String args[]) throws InvalidValues {

        Proposition x = new Proposition('x');
        Proposition y = new Proposition('y');
        Proposition z = new Proposition('z');

        Node exp = new Or(new And(x.not(), y), new Not(new Bid(z, y.not())));

        System.out.println(exp.toString());

        boolean r = exp.eval(new Value('x', false), new Value('y', true), new Value('z', false));

        var result = exp.getTruthTable();
        System.out.println(result.toString());

    }
}
