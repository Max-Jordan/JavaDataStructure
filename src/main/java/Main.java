import CustomArrayList.CustomArrayList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CustomArrayList<String> test = new CustomArrayList<String>();
        test.add("String");
        test.add("String");
        System.out.println(test.size());
        test.remove(1);
        System.out.println(test.size());
    }
}
