package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.*;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		if (item instanceof Book) {
			propertiesMap.put("Liczba stron", ((Book)item).getPages());
			propertiesMap.put("Twarda oprawa", ((Book)item).getHardcover());
		} else if (item instanceof Electronic){
			propertiesMap.put("Mobilny", ((Electronic) item).getMobile());
			propertiesMap.put("Gwarancja", ((Electronic)item).getWarranty());
		} else if(item instanceof Food){
			propertiesMap.put("Data przydatności", ((Food) item).getExpirationDate());
		} else if (item instanceof Music){
			propertiesMap.put("Gatunek muzyczny", ((Music) item).getGenre());
			propertiesMap.put("Czy ma wideo", ((Music) item).getVideo());
		}
		
		return propertiesMap;
	}
}
