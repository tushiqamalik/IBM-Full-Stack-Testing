//Activity4 (Test Suite)
//This activity will show the usage of testng.xml to execute multiple classes.
//[Optional] Create a package named suiteExample
//Create a new TestNG class file named DemoOne.java in the package.
//It will have two @Test methods
//Create another TestNG class named DemoTwo.java in the suiteExample package.
//This class will have only one @Test method

import org.testng.annotations.Test;

public class TestNGActivity4Demo2 {
    @Test
    public void TestCase() {
        System.out.println("I'm in the test case from DemoTwo Class");
    }
}