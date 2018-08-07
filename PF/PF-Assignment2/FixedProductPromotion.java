import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class FixedProductPromotion extends ShoppingCart implements Promotion {
	
	FixedProductPromotion(){
	}
	
	/*
	 * @param   item id (long), promo code (string)
	 * @return  minimum item price
	 */
	public double getMinimumPrice(int itemID, String code) {
		
		this.setMinimumPrice(itemID, code);
		ItemList item = this.searchItemInCart(itemID);
		return item.getItemTotalPrice();
	}
	
	/*
	 * @param  item id (long), promo code (String)
	 * @return nothing
	 * set minimum price for item after apply promo code discount and fixed discount
	 */
	public void setMinimumPrice(int itemID, String code) {
		
		ItemList item = this.searchItemInCart(itemID);
		double price = item.getItemTotalPrice();
		System.out.println(price);
		double priceAfterFixedDiscount ;
		priceAfterFixedDiscount = price - (price * (this.getItemFixedDiscount(itemID)/100.0));
		
		if (this.isPromotionApplicable(code)) {
			
			double priceAfterPromoDiscount ;
			priceAfterPromoDiscount = price - (price *(this.getPromoDiscount(code)/100.0));
			
			if (priceAfterFixedDiscount < priceAfterPromoDiscount) {
				item.setItemTotalPrice(priceAfterFixedDiscount);;
			}
			else {
				item.setItemTotalPrice(priceAfterPromoDiscount);
			}
		}
	}
	
	/*
	 * @param   Promotion code 
	 * @return  discount on given promotion code
	 */
	public double getPromoDiscount(String code) {

		HashMap<String, Double> discount = new HashMap<>();
		discount.put("sky10", 15.00);
		discount.put("laptop10", 25.00);
		discount.put("mobile10", 40.00);
	
		return (discount.containsKey(code) ? discount.get(code) : 0.0);
	
	}
	
	/*
	 * @param   item id (int)
	 * @return  fixed Discount on item
	 */
	public double getItemFixedDiscount(int itemID) {
		Item item = this.items[this.searchItem(itemID)];
		return item.getItemFixedDiscount();
	}
	
	/*
	 * @param   item id (int), discount (double)
	 * @return  nothing
	 * Set fixed discount on item 
	 */
	public void setItemFixedDiscount(int itemID, double discount) {
		
//		this.fixedDiscount.put(itemID, discount);
		
	}
	
	/*
	 * @param   item id (int), promo code (String)
	 * @return  true if promo code applicable otherwise false
	 */
	public boolean isPromotionApplicable (String code) {
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
}
