package domain;

public class Checkout {
	private int checkout_num;
	private String client;
	private String goods_name;
	private int quantity;
	private String checkout_date;
	
    public int getCheckout_num(){
    	return checkout_num;
    }
    
    public void setCheckout_num(int checkout_num){
    	this.checkout_num = checkout_num;
    }
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCheckout_date() {
		return checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}
}
