package org.example.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class StrongPassword {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("file/Password.txt");
        String fileText = Files.readString(path);


        Pattern pattern = compile(".*[1-9].*");
        Matcher matcher = pattern.matcher(fileText);
        List<String> passwords = new ArrayList<>();



        while (matcher.find()){
            passwords.add(matcher.group());
        }

        for (String password : passwords) {
            if (matcherStrong(password)) {
                System.out.println(password);
            }
        }
    }

    private static boolean matcherStrong(String password) {
        if (password.length()>8) return true;
        if (!password.matches(".*[/d].*")) return true;
        if (!password.matches(".*[A-Z].*")) return true;
        if (!password.matches(".*[a-z].*")) return true;
        if (!password.matches(".*[!@#$%^&*()_+~{}/.].*")) return true;
        return false;
    }
}
