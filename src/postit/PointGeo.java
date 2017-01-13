package postit;
import java.lang.Math;
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

	static public double getDistance(PointGeo p, double latitude, double longitude){
	  // renvoi la distance en km
	  double lat_p = p.getLatitude();
	  double lon_p = p.getLongitude();
	  double rayon = 6371.0;
	  return rayon*Math.acos(Math.sin(lat_p)*Math.sin(latitude)+Math.cos(lat_p)*Math.cos(latitude)*Math.cos(lon_p-longitude));
	}


}
