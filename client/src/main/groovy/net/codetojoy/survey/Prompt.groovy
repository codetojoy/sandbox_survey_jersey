
package net.codetojoy.survey;

import java.util.*;

class Prompt {
    private static final String QUIT = "q";

    def getInput(def prompt, def options = []) {
        String input = "";
        boolean isMatch = false;

        System.out.println(prompt);

        while (!isMatch) {
            Scanner scanner = new java.util.Scanner(System.in);
            input = scanner.nextLine();
           
            if (options.isEmpty()) {
                isMatch = true;
            } else {
                isMatch = matchInput(input, options);
            } 
        }

        return input;
    }

    private boolean matchInput(String input, List<String> options) {
        boolean isMatch = false;

        for (String option : options) {
            if (input.equalsIgnoreCase(option)) {
                isMatch = true;
                break;
            } else if (input.equalsIgnoreCase(QUIT)) {
                System.out.println("quitting ...");
                System.exit(0);
            }
        }

        if (!isMatch) {
            System.out.println("try again: ");
        }

        return isMatch;
    }
}
