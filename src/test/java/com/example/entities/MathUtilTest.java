package com.example.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//One Instance Per Class
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilTest {

	MathUtil mathUtil;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before All Init");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After all...");
	}

	@AfterEach
	void afterEach() {
		System.out.println("Clean Up..");
	}

	@BeforeEach
	void init() {
		mathUtil = new MathUtil();
	}

	@Test
	void test() {

		int expected = 4;

		int actual = mathUtil.add(2, 2);
		assertEquals(expected, actual);
	}

	@Test
	void divideTest() {
		assertThrows(ArithmeticException.class, () -> mathUtil.divide(10, 0), "Can't Divide By Zero or One");
	}

	@Test
	void computeCircleAreaTest() {
		assertEquals(31.41592653589793, mathUtil.computeCircleArea(10), "Compute Fails");
	}

//	Using Lambda ensure the value to return is only executed when the test fails
//	Like the case of test all method.
	@Test
	@DisplayName("Test Method Add and Substract")
	void testAll() {
		assertAll(() -> assertEquals(4, mathUtil.add(2, 2), () -> "Adding Values Test"),
				() -> assertEquals(-4, mathUtil.sub(2, 6), () -> "Substract Value Test"));

	}

	@RepeatedTest(3)
	@DisplayName("Repeated Test")
	@Tag("Important")
	void repeatTest(RepetitionInfo infor) {

		System.out.println("Total repeated Test = " + infor.getTotalRepetitions());
		assertEquals(31.41592653589793, mathUtil.computeCircleArea(10), "Compute Fails");

	}

	@Tag("Important")
	void tagTest(RepetitionInfo infor) {

		System.out.println("Total repeated Test = " + infor.getTotalRepetitions());
		assertEquals(31.41592653589793, mathUtil.computeCircleArea(10), "Compute Fails");

	}

//	Nested Class To Test Add Functionality
	@Nested
	@DisplayName("Add Method")
	class AddTest {

		@Test
		@DisplayName("When Adding 2 Possitive Number")
		void testAddPositive() {
			assertEquals(4, mathUtil.add(2, 2), "should return the right sum");
		}

		@Test
		@DisplayName("When adding 2 Negative Number")
		void testAddNumber() {
			assertEquals(-4, mathUtil.add(-2, -2));
		}
	}

}
