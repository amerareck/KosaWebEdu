package mobile;

class Ltab extends Mobile {
	public Ltab() {}
	public Ltab(String mobileName, int batterySize, String osType) {
		super(mobileName, batterySize, osType);
	}
	
	public void operate(int time) {
		int drainAmount = time*10;
		setBatterySize(getBatterySize() - drainAmount);
	}
	
	public void charge(int time) {
		int chargeAmount = time*10;
		setBatterySize(getBatterySize() + chargeAmount);
	}
}