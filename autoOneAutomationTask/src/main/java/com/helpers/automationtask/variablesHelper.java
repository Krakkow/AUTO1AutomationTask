package com.helpers.automationtask;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class variablesHelper
	{
		protected CarInfo car;
		protected WebDriver driver;
		protected String carListId = "car-list-container";
		protected String page = "https://auto1.com/en/our-cars";
		protected String bmwCheckbox = "html/body/div/div/div[1]/div[2]/aside/form/div/ul/li[6]/div";
		protected String filteredTo = "html/body/div[1]/div/div[1]/div[2]/aside/form/div/div/span/span[1]/span/ul/li[1]";
		protected String carName = null;
		protected String stockNumber = null;
		protected String mileage = null;
		protected String firstRegistration = null;
		protected String horsepower = null;
		protected String bodyType = null;
		protected String fuelType = null;
		protected String gearbox = null;
		protected WebElement carContainerList = null;
		protected List<WebElement> carsInfoInPage = null;
	}
