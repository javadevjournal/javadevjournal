package javadevjournal.design.creational.builder;

/**
 * @author Kunwar
 * Product Class
 * Builder Pattern Class
 */
public class Computer {
	//required parameters
	private String HDD;
	private String RAM;
	private String screenSize;

	//optional parameters
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	private boolean isWebCamEnabled;
	private boolean isTouchScreenEnabled;

	public String getHDD() {
		return HDD;
	}

	public String getRAM() {
		return RAM;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}

	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	public boolean isWebCamEnabled() {
		return isWebCamEnabled;
	}

	public boolean isTouchScreenEnabled() {
		return isTouchScreenEnabled;
	}

	private Computer(ComputerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.screenSize=builder.screenSize;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
		this.isTouchScreenEnabled=builder.isTouchScreenEnabled;
		this.isWebCamEnabled=builder.isWebCamEnabled;
		this.isWebCamEnabled=builder.isWebCamEnabled;
	}
	
	//Builder Class
	public static class ComputerBuilder{

		// required parameters
		private String HDD;
		private String RAM;
		private String screenSize;

		// optional parameters
		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		private boolean isWebCamEnabled;
		private boolean isTouchScreenEnabled;

		public ComputerBuilder(String hdd, String ram, String screenSize){
			this.HDD=hdd;
			this.RAM=ram;
			this.screenSize=screenSize;
		}

		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public ComputerBuilder setWebCamEnabled(boolean webCamEnabled) {
			isWebCamEnabled = webCamEnabled;
			return this;
		}

		public ComputerBuilder setTouchScreenEnabled(boolean touchScreenEnabled) {
			isTouchScreenEnabled = touchScreenEnabled;
			return this;
		}

		public Computer build(){
			return new Computer(this);
		}
	}

	@Override
	public String toString() {
		return "Computer{" +
				"HDD='" + HDD + '\'' +
				", RAM='" + RAM + '\'' +
				", screenSize='" + screenSize + '\'' +
				", isGraphicsCardEnabled=" + isGraphicsCardEnabled +
				", isBluetoothEnabled=" + isBluetoothEnabled +
				", isWebCamEnabled=" + isWebCamEnabled +
				", isTouchScreenEnabled=" + isTouchScreenEnabled +
				'}';
	}
}