package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClasseMere.class, TestClassesGestion.class, TestClassesSalarie.class })
public class AllTests {

}
