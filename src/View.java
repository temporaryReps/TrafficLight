import java.util.Scanner;

/**
 * UI class for interaction with user
 * Created by Artem
 */
public class View implements UIConnectable {
    @Override
    public int getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                break;
            }
            scanner.nextLine();
        }

        return result;
    }

    @Override
    public void show(String s) {
        System.out.println(s);
    }
}