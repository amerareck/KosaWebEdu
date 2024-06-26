package lotto;

public class LottoGame {

	public static void main(String[] args) {
		LottoMachine lm = new LottoMachine();
		lm.createLottoNums();
		try {
			lm.checkLottoNums();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		day7.MethodLab7.printArray(lm.getNums());
	}
}
