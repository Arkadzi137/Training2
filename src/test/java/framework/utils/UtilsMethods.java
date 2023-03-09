package framework.utils;

public class UtilsMethods {

    public static int parseString(String str){
        str = str.replaceAll("[^0-9]", "");
        int i = Integer.parseInt(str);
        return i;
    }
}
