/**
 * For user UI interaction
 */
public interface UIConnectable {
    /**
     * get Integer information from input
     *
     * @return information as int
     */
    int getUserAnswer();

    /**
     * show information
     *
     * @param s string that would be showed
     */
    void show(String s);
}