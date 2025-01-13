package software.ulpgc.kata6.adapter;

import software.ulpgc.kata6.control.DiscountCalculatorCommand;
import spark.Request;
import spark.Response;

public class DiscountCalculatorAdapter {
    public static DiscountCalculatorCommand.Input adaptInput(Request request) {
        return new DiscountCalculatorCommand.Input() {
            @Override
            public double price() {
                return Double.parseDouble(request.queryParams("price"));
            }

            @Override
            public double percentage() {
                return Double.parseDouble(request.queryParams("percentage"));
            }
        };
    }

    public static DiscountCalculatorCommand.Output adaptOutput(Response response) {
        return discountedPrice -> response.body(String.valueOf(discountedPrice));
    }
}
