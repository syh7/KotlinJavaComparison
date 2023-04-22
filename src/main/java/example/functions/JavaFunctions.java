package example.functions;

import java.util.function.Function;

public class JavaFunctions {

    public void example() {
        Function<String, String> function = String::toString;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("d");
    }
}
