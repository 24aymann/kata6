package software.ulpgc.kata6;

import software.ulpgc.kata6.control.Command;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandFactory implements Iterable<String>{
    private final Map<String, CommandBuilder> builders;

    public CommandFactory() {
        this.builders = new HashMap<>();
    }

    @Override
    public Iterator<String> iterator() {
        return this.builders.keySet().iterator();
    }

    public Executing given(Request req, Response res) {
        return name -> builders.get(name).build(req, res);
    }

    public interface Executing {
        Command get(String name);
    }

    public CommandFactory add(String name, CommandBuilder builder) {
        builders.put(name, builder);
        return this;
    }
}
