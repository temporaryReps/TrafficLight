public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getInstance();
        controller.setView(new View());
        TrafficLight trafficLight = new TrafficLight(controller);

        trafficLight.start();
    }
}
