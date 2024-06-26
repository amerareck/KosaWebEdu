package mobile;

class Otab extends Mobile {
	public Otab() {}
	public Otab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	
	public void operate(int time) {
		int drainAmount = time*12;
		setBatterySize(getBatterySize() - drainAmount);
	}
	
	public void charge(int time) {
		int chargeAmount = time*8;
		setBatterySize(getBatterySize() + chargeAmount);
	}
}