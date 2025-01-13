package software.ulpgc.kata6;

import software.ulpgc.kata6.adapter.DiscountCalculatorAdapter;
import software.ulpgc.kata6.control.DiscountCalculatorCommand;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(commandFactory()).init();
    }

    private static CommandFactory commandFactory() {
        return new CommandFactory()
                .add("discount-calculator", Main::createDiscountCalculatorCommand);
    }

    private static DiscountCalculatorCommand createDiscountCalculatorCommand(Request request, Response response) {
        return new DiscountCalculatorCommand(
                DiscountCalculatorAdapter.adaptInput(request),
                DiscountCalculatorAdapter.adaptOutput(response)
        );
    }
}
