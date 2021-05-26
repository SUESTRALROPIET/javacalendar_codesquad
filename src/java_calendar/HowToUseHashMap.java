package java_calendar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HowToUseHashMap {

	public static void main(String[] args) {
		
		var productPrice = new HashMap<String, Double>();
		
		// add value
		productPrice.put("Rice", 6.9);
		productPrice.put("Flour", 3.9);
		productPrice.put("Sugar", 4.9);
		productPrice.put("Milk", 3.9);
		productPrice.put("Egg", 1.9);
		
//		value를 알기 위하여 map에서 key를 사용한다. get () 메소드를 사용한다.
		Double a = productPrice.get("Egg");
		System.out.println("The price of Egg is: " + a);
		
//		모든 key를 print 하는 방법
		Set<String> keys = productPrice.keySet();
	
		for (String key : keys) {
			  System.out.println(key);
			}

		keys.forEach(key -> System.out.println(key));
		
//		모든 value를 print 하는 방법
		Collection<Double> values = productPrice.values();
		values.forEach(value -> System.out.println(value));
		
//		모든 key와 value를 같이 print하는 방법
		Set<Map.Entry<String, Double>> entries = productPrice.entrySet();

		for (Map.Entry<String, Double> entry : entries) {
		  System.out.print("key: "+ entry.getKey());
		  System.out.println(", Value: "+ entry.getValue());
		}
	}

}
