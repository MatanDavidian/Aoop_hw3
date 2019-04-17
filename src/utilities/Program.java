
package utilities;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import ui.MainScreen;

public class Program {
    public static void main(String[] args) {
        try {
            MainScreen frame = new MainScreen();
            frame.setVisible(true);
        }
        catch (ValueException e){
            System.out.println("main error");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
