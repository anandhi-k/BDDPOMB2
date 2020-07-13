package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src\\test\\java\\com\\features",
		glue= {"stepdefinitions"},
		monochrome=true,
		plugin= {"pretty"}
		)

public class TestNGRunner {
	private TestNGCucumberRunner testngCucumberRunner;
	@BeforeClass(alwaysRun=true)
	public void setup() {
		testngCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	@Test(groups="cucumber",description="Runs cucubmer feature",dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberfeature) {
		testngCucumberRunner.runCucumber(cucumberfeature.getCucumberFeature());
	}
	@DataProvider(name="features")
	public Object[][] features(){
		return testngCucumberRunner.provideFeatures();
	}
	@AfterClass(alwaysRun=true)
	public void teardown() {
		testngCucumberRunner.finish();
	}
	

}
