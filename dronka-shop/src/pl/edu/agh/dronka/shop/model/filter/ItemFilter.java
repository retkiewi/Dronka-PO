package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Book;
import pl.edu.agh.dronka.shop.model.Electronic;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Music;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItemFilter {

	private Item itemSpec = new Item();

	private Map<String, Boolean> properties =new HashMap<String, Boolean>();

	public ItemFilter(){
		this.properties.put("HardCover", false);
		this.properties.put("Mobile", false);
		this.properties.put("Warranty", false);
		this.properties.put("VideoIncluded", false);
	}

	public boolean getPropertyValue(String propertyName){
		return this.properties.get(propertyName);
	}

	public void setPropertyValue(String propertyName, boolean value){
		this.properties.put(propertyName, value);
	}

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		// applies filter only if the flag (secondHand) is true)
		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		// applies filter only if the flag (polish) is true)
		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}

		if(item.getClass()==Book.class && this.getPropertyValue("HardCover") && ((Book) item).getHardcover()){
			return false;
		}
		if(item.getClass()==Electronic.class && this.getPropertyValue("Mobile") && ((Electronic) item).getMobile()){
			return false;
		}
		if(item.getClass()==Electronic.class && this.getPropertyValue("Warranty") && ((Electronic) item).getWarranty()){
			return false;
		}
		if(item.getClass()==Music.class && this.getPropertyValue("VideoIncluded") && ((Music) item).getVideo()){
			return false;
		}

		return true;
	}

}