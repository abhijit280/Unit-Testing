package e.com.order.magt;

public class DiscountCalculator {

	public int calculateDiscount(int ammount, String type, int percentage) {
		int finalAmount = 0;
		try {
		switch (type) {
		case "REGULAR":
			finalAmount = ammount - (ammount * percentage) / 100;
			break;
		case "GOLD":
			finalAmount = ammount - (ammount * percentage) / 100 - 100;
			break;
		case "PLATINUM":
			finalAmount = ammount - (ammount * percentage) / 100 - 200;
			break;
		default:
			finalAmount = ammount;
			break;
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return finalAmount;
	}
}
