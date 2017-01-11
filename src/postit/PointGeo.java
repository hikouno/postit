package postit;

public class PointGeo
{
	private double latitude, longitude;
	
	public PointGeo(double lat, double longitude) {
		this.latitude = lat;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
