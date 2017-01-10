package postit;

public class PointGeo
{
	private double latitude, longitude;
	
	public PointGeo(double lat, double long) {
		this.latitude = lat;
		this.longitude = long;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
}
