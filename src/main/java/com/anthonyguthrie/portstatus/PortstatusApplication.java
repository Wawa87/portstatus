package com.anthonyguthrie.portstatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

@SpringBootApplication
public class PortstatusApplication {

	public static void main(String[] args) throws SocketException {
		SpringApplication.run(PortstatusApplication.class, args);
		CheckerPrompt checkerPrompt = new CheckerPrompt();
		checkerPrompt.run();
	}
}
