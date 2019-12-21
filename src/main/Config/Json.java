package Config;

import java.io.FileReader;

import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class Json {
    public static int width;
    public static int height;
    public static int startEnergy;
    public static int moveEnergy;
    public static int grassEnergy;
    public static double jungleRatio;
    public static int animalsStartingNumber;
    public static int grassPerDay;
    public static boolean debug = false;

    public static void readJSON() throws Exception {
        Object obj = new JSONParser().parse(new FileReader("./parameters.json"));
//        Object aaa = new JSONParser().parse(new FileReader("./parameters.json"));
        JSONObject parameters = (JSONObject) obj;

        try {
            Json.width = (int) (long) parameters.get("width") ;
            Json.height = (int) (long) parameters.get("height");
            Json.startEnergy = (int) (long) parameters.get("startEnergy");
            Json.moveEnergy = (int) (long) parameters.get("moveEnergy");
            Json.grassEnergy = (int) (long) parameters.get("grassEnergy");
            Json.jungleRatio = (double) parameters.get("jungleRatio");
            Json.animalsStartingNumber = (int) (long) parameters.get("startingAnimalsNumber");
            Json.grassPerDay = (int) (long) parameters.get("grassPerDay");
        } catch (ArithmeticException a) {
            System.out.println(a);
        }
    }
}
