package coffeeMachine;

class CoffeeMachineInvoker {
    private CoffeeCommand command;

    public void setCommand(CoffeeCommand command) {
        this.command = command;
    }

    public void processCommand() {
        if (command != null) {
            command.execute();
        }
    }
}
