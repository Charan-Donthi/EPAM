package calculator.CalculatorTest;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.epam.tat.module4.Calculator;


@Listeners(calculator.CalculatorTest.CalculatorListener.class)
public class CalculatorTesting {
	

	
	Calculator calculator;

	
	
	@BeforeClass(groups= {"Arthimetic","Trignometry"})
	public void objectCreation() {
		calculator=new Calculator();
	}
	
		
	@Test(dataProvider="dataProviderForTestingSumForLong",groups="Arthimetic")
	public void testSumForLong(long a,long b,long expected)
	{
		
		assertEquals(calculator.sum(a, b),expected);
	}
	
	
	@DataProvider
	public Object[][] dataProviderForTestingSumForLong(){
		return new Object[][] {
			{0,0,0},
			{-1,8,7},
			{-9,-9,-18},
			{1000000000L,10000000L,1010000000L},
			{1,-1,0},
			{Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE+Long.MIN_VALUE}
			};
	}
	
	
	@Test(dataProvider="dataProviderForTestingSumForDouble",groups= "Arthimetic")
	public void testSumForDouble(double a,double b,double expected)
	{
		assertEquals(calculator.sum(a, b),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingSumForDouble(){
		return new Object[][] {
			{0.0,0,0},
			{-1,8,7},
			{-9,-9,-18},
			{1000000000d,10000000d,1010000000d},
			{1,-1,0},
			{1.1,-1,0.1},
			{Double.MIN_VALUE,Double.MIN_VALUE,Double.MIN_VALUE+Double.MIN_VALUE}
			};
	}
	
	
	
	
	
	
	
	
	
	@Test(dataProvider="dataProviderForTestingSubForLong",groups= "Arthimetic")
	public void testSubForLong(long a,long b,long expected)
	{
		
		assertEquals(calculator.sub(a, b),expected);
	}
	
	
	@DataProvider
	public Object[][] dataProviderForTestingSubForLong(){
		return new Object[][] {
			{0,0,0},
			{-1,8,-9},
			{-9,-9,0},
			{1000000000L,10000000L,990000000L},
			{1,-1,2},
			{Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE-Long.MIN_VALUE}
			};
	}
	
	
	@Test(dataProvider="dataProviderForTestingSubForDouble",groups= "Arthimetic")
	public void testSubForDouble(double a,double b,double expected)
	{
		assertEquals(calculator.sub(a, b),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingSubForDouble(){
		return new Object[][] {
			{0.0,0,0},
			{-1,8,-9},
			{-9,-9,0},
			{1000000000d,10000000d,990000000d},
			{1,-1,2},
			{1.1,-1,2.1},
			{Double.MIN_VALUE,Double.MIN_VALUE,Double.MIN_VALUE-Double.MIN_VALUE}
			};
	}
	
	
	
	
	
	
	
	@Test(dataProvider="dataProviderForTestingMulForLong",groups= {"Arthimetic"})
	public void testMulForLong(long a,long b,long expected)
	{
		
		assertEquals(calculator.mult(a, b),expected);
	}
	
	
	@DataProvider
	public Object[][] dataProviderForTestingMulForLong(){
		return new Object[][] {
			{0,0,0},
			{-1,8,-8},
			{-9,-9,81},
			{1000000000L,10000000L,10000000000000000L},
			{1.1,-1,-1},
			{Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE*Long.MIN_VALUE}
			};
	}
	

	@Test(dataProvider="dataProviderForTestingMulForDouble",groups= "Arthimetic")
	public void testMulForDouble(double a,double b,double expected)
	{
		assertEquals(calculator.mult(a, b),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingMulForDouble(){
		return new Object[][] {
			{0.0,0,0},
			{-1,8,-8},
			{-9,-9,81},
			{1000000000d,10000000d,10000000000000000d},
			{1,-1,-1},
			{1.1,-1,-1.1},
			{Double.MIN_VALUE,Double.MIN_VALUE,Double.MIN_VALUE*Double.MIN_VALUE}
			};
	}
	
	
	
	
	
	
	
	@Test(dataProvider="dataProviderForTestingDivForLong",groups= "Arthimetic")
	public void testDivForLong(long a,long b,long expected)
	{
		
		assertEquals(calculator.div(a, b),expected);
	}
	
	
	@DataProvider
	public Object[][] dataProviderForTestingDivForLong(){
		return new Object[][] {
			{0,0,0},
			{-9,-9,1},
			{1000000000L,10000000L,100},
			{1.1,-1,-1.1},
			{Long.MIN_VALUE,Long.MIN_VALUE,1}
			};
	}
	
	
	@Test(dataProvider="dataProviderForTestingDivForDouble",groups= "Arthimetic")
	public void testDivForDouble(double a,double b,double expected)
	{
		assertEquals(calculator.div(a, b),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingDivForDouble(){
		return new Object[][] {
			{0.0,0,0},
			{-1,8,-0.125},
			{-9,-9,1},
			{1000000000d,10000000d,100d},
			{1,-1,-1},
			{1.1,-1,-1.1},
			{Double.MIN_VALUE,Double.MIN_VALUE,1}
			};
	}
	
	
	
	
	
	
	
	
	@Test(dataProvider="dataProviderForTestingPow",groups= "Arthimetic")
	public void testPow(double a,double b,double expected)
	{
		assertEquals(calculator.pow(a, b),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingPow(){
		return new Object[][] {
			{0.0,0,1.0},
			{-1,8,1},
			{-9,2,81},
			{1000000000d,3,1000000000000000000000000000d},
			{1,-1,1},
			{1.1,-1,0.90909090909090909090909090909091},
			{1,0,1.0}
			};
	}
	
	
	
	
	
	@Test(dataProvider="dataProviderForTestingIsNegativity")
	public void testIsNegative(long val)
	{
		assertTrue(calculator.isNegative(val));
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingIsNegativity(){
		return new Object[][] {
			{-1},
			{Long.MIN_VALUE},
			{-231342},
			{-(-(-8))},
			};
	}
	
	
	
	
	@Test(dataProvider="dataProviderForTestingIsPositivity")
	public void testIsPositivity(long val)
	{
		assertTrue(calculator.isPositive(val));
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingIsPositivity(){
		return new Object[][] {
			{Long.MAX_VALUE},
			{231342},
			{-(-(8))},
			};
	}
	
	
	@Test(expectedExceptions=Exception.class)
	public void testSqrtForNegativeValues() {
		calculator.sqrt(-1);
	}
	
	
	@Test(dataProvider="dataProviderForTestingSqrt",groups= "Arthimetic")
	public void testSqrt(long val,double expected)
	{
		assertEquals(calculator.sqrt(val),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingSqrt(){
		return new Object[][] {
			{0,0},
			{1,1},
			{45,6.708203932499369},
			{10,3.1622776601683795}
			};
	}
	
	
	
	
	
	@Test(dataProvider="dataProviderForTestingCos",groups= "Trignometry")
	public void testCos(double val,double expected)
	{
		assertEquals(calculator.cos(val),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingCos(){
		return new Object[][] {
			{180,-0.59846006905},
			{-180,-0.59846006905},
			{90,-0.44807361612},
			{45,0.52532198881},
			{270,0.98438195063},
			{-270,0.98438195063}
		};

	}
	
	
	@Test(dataProvider="dataProviderForTestingSin",groups= "Trignometry")
	public void testSin(double val,double expected)
	{
		assertEquals(calculator.sin(val),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingSin(){
		return new Object[][] {
			{180,-0.8011526357338304},
			{-180,0.8011526357338304},
			{90,0.8939966636005579},
			{45,0.8509035245341184},
			{270,-0.1760459464712114},
			{-270,0.1760459464712114}
		};

	}
	
	
	
	@Test(dataProvider="dataProviderForTestingCtg",groups= "Trignometry")
	public void testCtg(double val,double expected)
	{
		assertEquals(calculator.ctg(val),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingCtg(){
		return new Object[][] {
			{180,0.74699881441},
			{-180,-0.74699881441},
			{90,-0.50120278338},
			{45,0.61736962378},
			{270,-5.59161951959},
			{-270,5.59161951959}
		};

	}
	
	
	@Test(dataProvider="dataProviderForTestingtg",groups= "Trignometry")
	public void testtg(double val,double expected)
	{
		assertEquals(calculator.tg(val),expected);
	}
	
	@DataProvider
	public Object[][] dataProviderForTestingtg(){
		return new Object[][] {
			{180,1.33869021035},
			{-180,-1.33869021035},
			{90,-1.99520041221},
			{45,1.61977519054},
			{270,-0.17883906379},
			{-270,0.17883906379}
		};

	}
	
	
}
