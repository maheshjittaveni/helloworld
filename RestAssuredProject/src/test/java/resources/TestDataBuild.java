package resources;

import java.util.ArrayList;
import java.util.List;

import pojoserialization.AddPlace;
import pojoserialization.Location;

public class TestDataBuild {

	public AddPlace addPlacePayload(String name, String language, String address) {
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 123 456 7890");
		p.setName(name);
		p.setWebsite("https://www.mahesh.com");
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		System.out.println(myList);
		p.setTypes(myList);
		
		Location loc=new Location();
		loc.setLang(33.427362);
		loc.setLat(-38.383494);
		p.setLocation(loc);
		return p;
	}
}
