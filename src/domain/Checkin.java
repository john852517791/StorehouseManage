package domain;

public class Checkin {
    private int checkin_num;
    private String supplier;
    private String goods_name;
    private int quantity;
    private String checkin_date;
    
    public int getCheckin_num(){
    	return checkin_num;
    }
    
    public void setCheckin_num(int checkin_num){
    	this.checkin_num = checkin_num;
    }
    
    public String getSupplier(){
    	return supplier;
    }
    
    public void setSupplier(String supplier){
    	this.supplier = supplier;
    }
    
    public String getGoods_name(){
    	return goods_name;
    }
    
    public void setGoods_name(String goods_name){
    	this.goods_name = goods_name;
    }
    
    public int getQuantity(){
    	return quantity;
    }
    
    public void setQuantity(int quantity){
    	this.quantity = quantity;
    }
    
    public String getCheckin_date(){
    	return checkin_date;
    }
    
    public void setCheckin_date(String checkin_date){
    	this.checkin_date = checkin_date;
    }
    
    
    
    
}
