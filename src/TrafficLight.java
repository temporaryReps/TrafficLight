/**
 * Traffic light
 * It has three color of lights, each color switches over after a certain time
 * Created by Artem
 */
public class TrafficLight {
    private static final int MAX_DURATION = 10; // in minutes
    private static final int MINUTE_MILLIS = 1000; // count of millisecond within minute

    private Controller controller;

    //duration of each lights in minutes
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    public TrafficLight(Controller controller) {
        this.controller = controller;
    }

    public void start() {
        greenDuration = durationAdjustment(Color.GREEN);
        yellowDuration = durationAdjustment(Color.YELLOW);
        redDuration = durationAdjustment(Color.RED);

        switchLight();
    }

    /**
     * adjust duration for definite light
     *
     * @param color of light
     * @return duration
     */
    private int durationAdjustment(Color color) {
        String askBefore = "Enter the duration of the ";
        String askAfter = " light";
        int result;

        sendInformation(askBefore + color + askAfter);
        do {
            result = controller.receiveDuration();

            if (result < 0 || result > MAX_DURATION) {
                wrongDuration();
            }
        } while (result < 0 || result > MAX_DURATION);

        return result;
    }

    /**
     * switch color of lights according established time
     */
    private void switchLight() {
        try {
            // switch on red light
            sendInformation(Color.GREEN);
            Thread.sleep(greenDuration * MINUTE_MILLIS);
            // switch on yellow light
            sendInformation(Color.YELLOW);
            Thread.sleep(yellowDuration * MINUTE_MILLIS);
            // switch on red light
            sendInformation(Color.RED);
            Thread.sleep(redDuration * MINUTE_MILLIS);
        } catch (InterruptedException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    /**
     * send Color as string to UI
     *
     * @param color of traffic lights
     */
    private void sendInformation(Color color) {
        controller.pushInformation(color.toString());
    }

    /**
     * send information to UI
     *
     * @param s string which would be send
     */
    private void sendInformation(String s) {
        controller.pushInformation(s);
    }

    /**
     * send message to user that the wrong duration was selected
     */
    private void wrongDuration() {
        controller.pushInformation(
                "Repeat the input, the duration should not be more than "
                        + MAX_DURATION + " minutes and less than 0");
    }

    /**
     * colors of traffic light
     */
    private enum Color {RED, YELLOW, GREEN}
}