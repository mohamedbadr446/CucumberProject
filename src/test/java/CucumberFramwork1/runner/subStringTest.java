package CucumberFramwork1.runner;

import org.apache.commons.lang.StringUtils;

public class subStringTest {
    public static void main(String[] args) {
        String str = "9.8909";
        System.out.println(StringUtils.substringAfterLast(str, "."));
        System.out.println(StringUtils.substringBeforeLast(str, "."));

    }
}
