package main;

import java.util.*;
import jep.*;
import jep.python.PyCallable;
import jep.python.PyObject;

public class App {
    static final int trials = 1000000;
    public static void main() {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.runScript("./exp.py");
            interp.exec("exp = Exp()");
            
            ArrayList<Double> ary = new ArrayList<>();
            for(int i=0;i<1000;i++)
            {
                ary.add(i*2.0);
            }
            var exp = interp.getValue("exp", PyObject.class);
            var echo = exp.getAttr("echo", PyCallable.class);


            var start = System.nanoTime();
            for(int i=0;i<trials;i++)
            {
                var ret = echo.callAs(ArrayList.class, ary);
            }
            var stop = System.nanoTime();
            Long ms = (stop-start) / 1000000;
            System.out.println(ms.toString() + " ms");

        }
    }
}
