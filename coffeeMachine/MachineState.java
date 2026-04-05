package coffeeMachine;

interface MachineState {
    void handleRequest(CoffeeMachine machine);
}
