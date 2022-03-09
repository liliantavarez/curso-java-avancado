package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date manuFactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manuFactureDate) {
		super(name, price);
		this.manuFactureDate = manuFactureDate;
	}

	public Date getManuFactureDate() {
		return manuFactureDate;
	}

	public void setManuFactureDate(Date manuFactureDate) {
		this.manuFactureDate = manuFactureDate;
	}
	
	@Override
	public String priceTag() {
		return getName()+" (Usado) R$ "+getPrice()+" (Data de Fabricação: "+sdf.format(manuFactureDate)+")";
	}
	
}
