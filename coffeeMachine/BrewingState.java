package coffeeMachine;

class BrewingState implements MachineState {
    @Override
    public void handleRequest(CoffeeMachine machine) {
        System.out.println("Machine is brewing coffee.");
    }
}
