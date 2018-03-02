/**
 * Controller for "Traffic light"
 * Created by Artem
 */
public class Controller {
    private static Controller instance;

    private UIConnectable view;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public void setView(UIConnectable view) {
        this.view = view;
    }

    /**
     * push information to UI
     *
     * @param s string of information
     */
    public void pushInformation(String s) {
        view.show(s);
    }

    /**
     * receive Integer information from UI
     *
     * @return information for model
     */
    public int receiveDuration() {
        return view.getUserAnswer();
    }
}
