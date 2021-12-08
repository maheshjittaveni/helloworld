package resources;

// enum is special class in java which has collection of constants or methods
public enum ApiEnumResources {
	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");

	private String resource;
	ApiEnumResources(String resource){
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}
	
}
