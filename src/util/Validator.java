package util;

import java.io.File;

public class Validator {

    public boolean fileExist(String file) {
        return new File(file).exists() && new File(file).isFile();
    }

    public boolean isPositiveNumber(int number) {
        return number > 0 && number < 3;
    }

}
