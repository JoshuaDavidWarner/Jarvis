package edu.metrostate.ics340.p5.jw2684.test;
import edu.metrostate.ics340.p5.jw2684.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SpillContainerTest {

	@Test
	void test() {
		List<String> output = new ArrayList<>();
		output.add("L0");
		output.add("L3");
		output.add("L1");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test4.txt");
		assertEquals(test,output);
		
	}
	@Test
	void test2() {
		List<String> output = new ArrayList<>();
		output.add("S10_1");
		output.add("S10_3");
		output.add("S10_4");
		output.add("S10_2");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test2.txt");
		assertEquals(test,output);
		
	}
	@Test
	void test3() {
		List<String> output = new ArrayList<>();
		output.add("S10_5");
		//output.add("S10_1");
		output.add("S10_6");
		//output.add("S10_4");
		output.add("S10_3");
		//output.add("S10_2");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test1.txt");
		assertEquals(test,output);
		
	}
	@Test
	void test4() {
		List<String> output = new ArrayList<>();
		//output.add("S10_1");
		//output.add("S10_3");
		//output.add("S10_2");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test3.txt");
		assertEquals(test,output);
		
	}
	@Test
	void test5() {
		List<String> output = new ArrayList<>();
		//output.add("S10_1");
		//output.add("S10_3");
		//output.add("S10_2");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test5.txt");
		assertEquals(test,output);
		
	}
	@Test
	void test6() {
		List<String> output = new ArrayList<>();
		//output.add("S10_1");
		//output.add("S10_3");
		//output.add("S10_2");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test6.txt");
		System.out.println(test.toString());
		//assertEquals(test,output);
		
	}
	@Test
	void test7() {
		List<String> output = new ArrayList<>();
		//output.add("S10_1");
		//output.add("S10_3");
		//output.add("S10_2");
		List<String> test = SpillContainer.getBoundary("E:\\METRO_STATE\\ICS340\\assignments\\P5\\p5_test7.txt");
		System.out.println(test.toString());
		assertEquals(test,output);
		
	}


}
