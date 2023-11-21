package com.anthonyguthrie.portstatus;

import java.util.Scanner;

public class CheckerPrompt {
    Scanner scanner;
    String ipAddress;
    PortChecker portChecker;
    public void run() {
        this.scanner = new Scanner(System.in);
        String input;
        System.out.println("PortChecker running...");
        while (portChecker == null) {
            System.out.println("Enter an ip address or 'exit' to quit the program...");
            input = scanner.nextLine();
            if (input.equals("exit")) {
                return;
            } else {
                portChecker = PortCheckerFactory.create(input);
            }

            if (portChecker != null) {
                while (true) {
                System.out.println("Enter port number, enter 'new' to use a new ip, or enter 'exit' to quit the program.");
                    input = scanner.nextLine();
                    if (input.equals("exit")) {
                        return;
                    }
                    else if (input.equals("new")) {
                        this.portChecker = null;
                        break;
                    }
                    else {
                        System.out.println(this.portChecker.checkPort(Integer.parseInt(input)));
                    }
                }
            }
        }
    }
}
