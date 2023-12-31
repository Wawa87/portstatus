package com.anthonyguthrie.portstatus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class PortstatusApplicationTests {

	@Test
	void testPortCheckerFactory() {
		PortChecker p = PortCheckerFactory.create("127.0.0.1");
		Assert.isTrue(p != null, "Check that PortChecker is not null for localhost.");

		PortChecker p1 = PortCheckerFactory.create("192.168.3.249");
		Assert.isTrue(p1 != null, "Check that PortChecker is not null for Class C address.");

		PortChecker p2 = PortCheckerFactory.create("2342");
		Assert.isTrue(p2 == null, "Check that PortChecker is null for malformed ip.");
	}

	@Test
	void testPortCheckerUDPTest() {
		PortChecker p = PortCheckerFactory.create("127.0.0.1");
		Assert.isTrue(p.checkUDPPort(8081), "Test known open UDP port 8081");
		Assert.isTrue(!p.checkUDPPort(53), "Test known unavailable UDP port 53");
	}

	@Test
	void testPortCheckerTCPTest() {
		PortChecker p = PortCheckerFactory.create("127.0.0.1");
		Assert.isTrue(p.checkTCPPort(5040), "Test known open TCP port 5040");
		Assert.isTrue(!p.checkTCPPort(8080), "Test known unavailable TCP port 8080");
	}

	@Test
	void testPortCheckerResult() {
		PortChecker p = PortCheckerFactory.create("127.0.0.1");
		String res = "Checking Port#: 8081\n" +
				"TCP: UNAVAILABLE\n" +
				"UDP: OPEN\n";
		Assert.isTrue(p.checkPort(8081).equals(res), "Test result message.");
	}
}
