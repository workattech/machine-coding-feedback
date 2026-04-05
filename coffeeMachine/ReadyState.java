package coffeeMachine;

class ReadyState implements MachineState {
    @Override
    public void handleRequest(CoffeeMachine machine) {
        System.out.println("Machine is ready. Choose your coffee.");
    }
}
