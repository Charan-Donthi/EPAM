package DataProviders;

import org.testng.annotations.DataProvider;

public class DataproviderClass {
	
	@DataProvider
	public Object[][] dataProviderForVerifyingSelectionOfDate(){
		return new Object[][] {
			{"2020-12-21","2020-12-30"},
			{"2020-07-21","2020-10-10"},
			{"2020-06-30","2020-08-20"},
			{"2020-05-22","2021-01-05"},
		};
	}

}
