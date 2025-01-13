package software.ulpgc.kata6.control;

public class DiscountCalculatorCommand implements Command {
    private final Input input;
    private final Output output;

    public DiscountCalculatorCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        double price = input.price();
        double percentage = input.percentage();
        double discountedPrice = price - (price * percentage / 100);
        output.result(discountedPrice);
    }

    public interface Input {
        double price();
        double percentage();
    }

    public interface Output {
        void result(double discountedPrice);
    }
}
