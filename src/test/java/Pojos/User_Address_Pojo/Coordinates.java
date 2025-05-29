package Pojos.User_Address_Pojo;

public class Coordinates {
    private double lat;
    private double lng;

    public Coordinates(){
        //empty constructor
    }
    public Coordinates(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
