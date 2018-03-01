import parser.Parser;
import parser.functionality.Functionality;

public class ParserTest {

    ParserTest(){
        Parser parser = new Parser("a+b*c+d-e+f/g^2+PI/EL");
        parser.setParameter("a", 4);
        parser.setParameter("b", 5);
        parser.setParameter("c", 2);
        parser.setParameter("d", 3);
        parser.setParameter("e", 1);
        parser.setParameter("f", 3);
        parser.setParameter("g", 4);
        parser.registerFunctionality(Functionality.PI, Functionality.EULER_NUMBER);
        double result = parser.calculate();
        System.out.println(String.format("Result: %s", result));
    }
}
