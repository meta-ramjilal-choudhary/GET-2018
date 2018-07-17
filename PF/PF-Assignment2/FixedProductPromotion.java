import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class FixedProductPromotion extends ShoppingCart implements Promotion {
	
	private HashMap<Long, Double> fixedDiscount;
	
	FixedProductPromotion(){
		fixedDiscount = new HashMap<>();
	}
	
	/*
	 * @param   item id (long), promo code (string)
	 * @return  minimum item price
	 */
	public double getMinimumPrice(long itemID, String code) {
		
		this.setMinimumPrice(itemID, code);
		
		return this.getPrice(itemID);		
	}
	
	/*
	 * @param  item id (long), promo code (String)
	 * @return nothing
	 * set minimum price for item after apply promo code discount and fixed discount
	 */
	public void setMinimumPrice(long itemID, String code) {
		double priceAfterFixedDiscount ;
		double price = this.getPrice(itemID);
		
		priceAfterFixedDiscount = price - (price * (this.fixedDiscount.get(itemID)/100.0));
		
		if (this.isPromotionApplicable(itemID, code)) {
			
			double priceAfterPromoDiscount ;
			priceAfterPromoDiscount = price - (price *(this.getPromoDiscount(code)/100.0));
			
			if (priceAfterFixedDiscount < priceAfterPromoDiscount) {
				this.setPrice(itemID, priceAfterFixedDiscount);
			}
			else {
				this.setPrice(itemID, priceAfterPromoDiscount);
			}
		}
	}
	
	/*
	 * @param   Promotion code 
	 * @return  discount on given promotion code
	 */
	public double getPromoDiscount(String code) {
		
		final double noDiscount = 0.0;
		HashMap<String, Double> discount = new HashMap<>();
		discount.put("sky10", 15.00);
		discount.put("algo10", 10.00);
		discount.put("laptop10", 25.00);
		discount.put("samsung10", 40.00);
	
		if(discount.containsKey(code)) {
			return discount.get(code);
		}
		else {
			return noDiscount;
		}
		
	}
	
	/*
	 * @param   item id (int)
	 * @return  fixed Discount on item
	 */
	public double getFixedDiscount(long itemID) {
		
		double noDiscount = 0.0;
		
		if(this.fixedDiscount.containsKey(itemID)) {
			return this.fixedDiscount.get(itemID);
		}
		else {
			return noDiscount;
		}
		
	}
	
	/*
	 * @param   item id (int), discount (double)
	 * @return  nothing
	 * Set fixed discount on item 
	 */
	public void setFixedDiscount(long itemID, double discount) {
		
		this.fixedDiscount.put(itemID, discount);
		
	}
	
	/*
	 * @param   item id (int), promo code (String)
	 * @return  true if promo code applicable otherwise false
	 */
	public boolean isPromotionApplicable (long itemID, String code) {
		PromotionEnum [] promoEnum = PromotionEnum.values();
		for(PromotionEnum promo : promoEnum) {
			if(code.equals(promo.getCode())) {
				Date todayDate = new Date();
				try {
					Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(promo.getStartDate());
					Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(promo.getEndDate());
					if ((startDate.compareTo(todayDate) <= 0) && (endDate.compareTo(todayDate) >= 0)) {
						return true;
					}
				}
				catch(ParseException e) {
					System.out.println(e);
				}
				
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		FixedProductPromotion prodPromo = new FixedProductPromotion();
		prodPromo.add(1, "SkyBag", 1156.36, 1);
		prodPromo.add(2, "Algo Book", 560.36, 1);
		prodPromo.add(3, "Laptop", 32156.36, 1);
		prodPromo.add(4, "Samsung S8", 55556.36, 1);
		prodPromo.add(5, "iPhone", 105556.36, 1);
		
		prodPromo.itemList();
		
		prodPromo.setPrice(1, 1000.0);
		
		prodPromo.itemList();
		
		prodPromo.setFixedDiscount(1, 10.0);
		prodPromo.setFixedDiscount(2, 55.0);
		prodPromo.setFixedDiscount(3, 30.0);
		prodPromo.setFixedDiscount(4, 20.0);
		prodPromo.setFixedDiscount(5, 15.0);
	
		System.out.println(prodPromo.isPromotionApplicable(1, "sky10"));
		
		System.out.println(prodPromo.getFixedDiscount(5));
		
		System.out.println(prodPromo.getMinimumPrice(1, "sky10"));
	}
}
