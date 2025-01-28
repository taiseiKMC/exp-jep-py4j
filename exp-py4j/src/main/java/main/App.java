package main;

import py4j.ClientServer;
import java.util.List;
import java.util.ArrayList;

public class App {
    static final int trials = 1000000;
    public static void main()
    {
        var client = new ClientServer(null);
        Exp exp = (Exp) client.getPythonServerEntryPoint(new Class[] { Exp.class });

        var ary = new ArrayList<Double>();
        for(int i=0;i<1000;i++)
        {
            ary.add(i*2.0);
        }

        var start = System.nanoTime();
        for(int i=0;i<trials;i++)
        {
            var ret = exp.echo(ary);
        }
        var stop = System.nanoTime();
        Long ms = (stop-start) / 1000000;
        System.out.println(ms.toString() + " ms");

        client.shutdown();
    }
}

/*
% javac -d . -cp ./py4j0.10.9.9.jar Hoge.java Main.java
% java -cp ./py4j0.10.9.9.jar:. example/Main
% kscript exec.kts
 */
