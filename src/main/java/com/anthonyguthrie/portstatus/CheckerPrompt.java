package com.anthonyguthrie.portstatus;

import java.util.Scanner;

public class CheckerPrompt {
    Scanner scanner;
    String ipAddress;
    PortChecker portChecker;
    String input;

    public CheckerPrompt() {
        this.scanner = new Scanner(System.in);
    }

    public void promptForIP() {
        System.out.println("Enter an ip address or 'exit' to quit the program...");
        this.input = scanner.nextLine();
    }

    public void promptForPort() {
        System.out.println("Enter port number, enter 'new' to use a new ip, or enter 'exit' to quit the program.");
        this.input = scanner.nextLine();
    }

    public void run() {
        System.out.println("PortChecker running...");
        while (portChecker == null) {
            this.promptForIP();
            if (this.input.equals("exit")) {
                return;
            } else {
                this.portChecker = PortCheckerFactory.create(input);
            }

            if (this.portChecker != null) {
                while (true) {
                    this.promptForPort();
                    if (this.input.equals("exit")) {
                        return;
                    }
                    else if (this.input.equals("new")) {
                        this.portChecker = null;
                        break;
                    }
                    else {
                        try {
                            System.out.println(this.portChecker.checkPort(Integer.parseInt(input)));
                        } catch (Exception e) {
                            System.out.println("Input error - try another value...");
                        }
                    }
                }
            }
        }
    }
}
