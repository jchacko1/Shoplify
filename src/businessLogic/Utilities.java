package businessLogic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class Utilities {
    //Put all generic helper methods here
    private static Random random = new Random();

    public static String getCurrentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static int getRandomNumber()
    {
          return random.nextInt();
    }

}
