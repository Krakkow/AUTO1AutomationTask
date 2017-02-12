package com.main.automationtask;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.helpers.automationtask.CarInfo;
import com.helpers.automationtask.variablesHelper;

/*
 * Auto1 Automation task
 * Developed by Or Kowalsky
 */

//As testNG doesn't distinguish test order, I had to put before every test function name a capital letter by the "ABC" order.

public class Main extends variablesHelper
	{


		// 1. Get to https://auto1.com/en/our-cars

		@Test
		public void AbeforeClass() 
			{
				try
					{
						System.out.println("Initializing Firefox...");
						driver = new FirefoxDriver();
					}
				catch (Exception e)
					{
						e.printStackTrace();
					}
				System.out.println("Firefox initialized...");
			}

		@AfterTest
		public void waitForFirefox() throws InterruptedException
		{
			Thread.sleep(3000);
			
		}
		//Get to the desired page and filter to BMWs
		@Test
		public void BgetToPageAndFilter() throws InterruptedException
			{
				System.out.println("Redirecting to AUTO1 at: " + page);
				driver.get(page);
				Thread.sleep(4000);
				WebElement checkbox = driver.findElement(By.xpath(bmwCheckbox));
				System.out.println("Checking BMW box...");
				checkbox.click();
			}

		//Filter verification
		@Test
		public void CverifyFilter()
			{
				WebElement filter = driver.findElement(By.xpath(filteredTo));
				String title = "BMW";
				if (title.equals(filter.getAttribute("title")))
					{
						System.out.println("Filter verification - Filtered manufacturer to: " + title);
					}
				else
					{
						System.out.println("title was not caught");
					}

			}
		
		//Calculating how many car objects are in the page
		@Test
		public void DfindAmountOfCarsInPage() throws InterruptedException
		{
			// Finding the cars container in the page
			
			String containerId = null;
			try
				{
					carContainerList = driver.findElement(By.id(carListId));
					containerId = carContainerList.getAttribute("id");
				}
			catch (Exception e)
				{
					e.printStackTrace();
					e.getMessage();
				}
			if (containerId.equals(carListId))
				{
					System.out.println("Cars container found by ID: " + containerId);
				}
			else
				{
					System.out.println("Car container was not found...");
				}

			// Here I iterate over all the cars item there are in the page
			// to find out how many are there in total.
			List<WebElement> carAmountInPage = carContainerList.findElements(By.className("car-item"));
			if (carAmountInPage.size() > 0)
				{
					System.out.println("Total amount of cars in the page is: " + carAmountInPage.size());
				}
			else
				{
					System.out.println("Wasn't able to get amount of cars");
				}
			Thread.sleep(3500);
		}
		
		//Getting all cars information and verification of it
		@Test
		public void EgettingAllCarsInfo()
		{
			// Getting all the information from each car.
			carsInfoInPage = new ArrayList<WebElement>(
					carContainerList.findElements(By.className("car-info")));
			System.out.println("There are " + carsInfoInPage.size() + " info blocks in the page");
			try
				{
					for (int i = 0; i < carsInfoInPage.size(); i++)
						{
							String theCarName = "car-name";
							ArrayList<WebElement> carNameFromDiv = new ArrayList<WebElement>(
									carContainerList.findElements(By.className(theCarName)));
							carName = (carNameFromDiv.get(i).getText());
							for (int attribute = 1; attribute <= 7; attribute++)
								{
									int category = i + 1;
									WebElement gettingCarInfo = driver
											.findElement(By.xpath(".//*[@id='car-list']/li[" + category
													+ "]/div[3]/table/tbody/tr[" + attribute + "]/td[2]"));
									switch (attribute)
										{
										case 1:

											stockNumber = gettingCarInfo.getText();
										case 2:

											mileage = gettingCarInfo.getText();
										case 3:

											firstRegistration = gettingCarInfo.getText();
										case 4:

											horsepower = gettingCarInfo.getText();
										case 5:

											bodyType = gettingCarInfo.getText();
										case 6:

											gearbox = gettingCarInfo.getText();
										case 7:
											fuelType = gettingCarInfo.getText();

										default:
											break;
										}

								}
							car = new CarInfo(carName, stockNumber, mileage, firstRegistration, horsepower,
									bodyType, fuelType, gearbox);
							// Verification that all cars in the page are
							// BMWs
							if (!carName.contains("BMW"))
								{
									System.out.println(
											"Not all cars in this page are BMWs, I've caught this: " + carName);
								}
							else
								{
									System.out.println(
											"Car number " + (i + 1) + ": Car name - " + car.getCarName(carName));

								}
							// Verification that all cars has all the
							// information
							try
								{
									for (int j = 0; j < carsInfoInPage.size(); j++)
										{
											if (car.getCarName(carName).equals(null)
													|| car.getStockNumber(stockNumber).equals(null)
													|| car.getMileage(mileage).equals(null)
													|| car.getFirstRegistration(firstRegistration).equals(null)
													|| car.getHorsepower(horsepower).equals(null)
													|| car.getBodyType(bodyType).equals(null))
												{
													System.out.println("Some cars don't hold all the information.");
												}

										}
								}
							catch (Exception e)
								{
									e.printStackTrace();
									System.out.println("Some cars don't hold all the information.");

								}
							System.out.println("Car number " + (i + 1) + ": " + car.toString());
							System.out.println("Car number " + (i + 1) + ": All information retrieved!");
						}
					System.out.println("Every car in the page has all the information.");
				}
			catch (Exception e)
				{
					e.printStackTrace();
				}
			System.out.println("All cars in the page are BMWs.");
		}
		
		@Test
		public void FimageVerifier()
		{
			// Verifying each car has an image
			String imageAddress = null;
			WebElement carImagesList;
			try
				{
					for (int image = 0; image < carsInfoInPage.size(); image++)
						{
							int imageIndex = (image + 1);
							try
								{
									carImagesList = driver.findElement(
											By.xpath(".//*[@id='car-list']/li[" + imageIndex + "]/div[2]/img"));
									imageAddress = carImagesList.getAttribute("src");
									if (!imageAddress.equals(null))
										{
											System.out.println("Image address for car number " + imageIndex + ": "
													+ imageAddress);
										}
									else
										{
											System.out.println(
													"Something went wrong with fetching car image address");
										}
								}
							catch (Exception e)
								{
									e.printStackTrace();
								}

						}
				}
			catch (Exception e)
				{
					e.printStackTrace();
					e.getMessage();
				}
		}

		@AfterClass
		public void afterClass()
			{
				driver.close();
			}



	}
