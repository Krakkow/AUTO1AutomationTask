package com.helpers.automationtask;

public class CarInfo
	{
		private String carName;
		private String stockNumber;
		private String mileage;
		private String firstRegistration;
		private String horsepower;
		private String bodyType;
		private String gearbox;
		private String fuelTYpe;

		public CarInfo(String carName, String stockNumber, String mileage, String firstRegistration, String horsepower,
                       String bodyType, String gearbox, String fuelTYpe)
			{
				super();
				this.carName = carName;
				this.stockNumber = stockNumber;
				this.mileage = mileage;
				this.firstRegistration = firstRegistration;
				this.horsepower = horsepower;
				this.bodyType = bodyType;
				this.gearbox = gearbox;
				this.fuelTYpe = fuelTYpe;
			}

		public String getCarName(String carName)
			{
				return carName;
			}

		public String getStockNumber(String stockNumber)
			{
				return stockNumber;
			}

		public String getMileage(String mileage)
			{
				return mileage;
			}

		public String getFirstRegistration(String firstRegistration)
			{
				return firstRegistration;
			}

		public String getHorsepower(String horsepower)
			{
				return horsepower;
			}

		public String getBodyType(String bodyType)
			{
				return bodyType;
			}

		public String getGearbox(String gearbox)
			{
				return gearbox;
			}

		public String getFuelTYpe(String fuelTYpe)
			{
				return fuelTYpe;
			}

		@Override
		public String toString()
			{
				return "CarInfo [carName=" + carName + ", stockNumber=" + stockNumber + ", mileage=" + mileage
						+ ", firstRegistration=" + firstRegistration + ", horsepower=" + horsepower + ", bodyType="
						+ bodyType + ", gearbox=" + gearbox + ", fuelTYpe=" + fuelTYpe + "]";
			}

	}
