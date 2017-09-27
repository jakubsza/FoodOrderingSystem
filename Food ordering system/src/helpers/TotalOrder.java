package helpers;

import java.util.List;

public class TotalOrder {
	
	private List<Order> orders;

	public List<Order> getSingleOrder() {
		return orders;
	}

	public void setSingleOrder(List<Order> singleOrder) {
		this.orders = singleOrder;
	}
	
	private double getBillTotal(){
		double bill=0.0;
		for(Order order : orders){
			bill+=order.getTotalPrice();
		}
		return bill;
	}
	
	public void displayBill(){
		System.out.println("Please see your bill:");
		
		String format = "%-70s%s%n";
		
		for(Order order : orders){
			System.out.printf(format, order.getOrder() + " x" + order.getTimes(), order.getTotalPrice() + " PLN");
		}
		
		System.out.println("********************************************************************************");
		System.out.printf(format, "Total price: ", getBillTotal() + " PLN");
	}

}
