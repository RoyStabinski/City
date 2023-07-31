/**
 * The class "City" represent a city in the state.
 * The class has many functions like - creating a new city , adding more residents,etc.
 * if the establishment date and city or station coordinates aren't legal (by definition) -
 * they will be set to 1/1/2000 and (0,0).
 * if the number of residents is negative it will be set to 0.
 * if the number of neighborhoods is less than 1 it will be set to 1.
 */
public class City {

    //Instance Variables
    private String _cityName;
    private Date _dateEstablished;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _numOfNeighborhoods;
    private final int DEFAULT_RES = 0;
    private final int DEFAULT_NEIGBRS = 1;

    //Constructions

    /**
     * Represents a city. City is represented by its name, the date it was established, center,
     * central station, number of residents(non negative) and number of neighborhoods(positive).
     * @param cityName - The city's name
     * @param dayEstablished - The day the city was established
     * @param monthEstablished - The month the city was established
     * @param yearEstablished - The year the city was established
     * @param centerX - The x coordinate of the city's center
     * @param centerY - The y coordinate of the city's center
     * @param stationX - The x coordinate of the city's central station
     * @param stationY - The y coordinate of the city's central station
     * @param numOfResidents - number of residents
     * @param noOfNeighborhoods - number of neighborhoods
     */
    public City(String cityName, int dayEstablished, int monthEstablished, int yearEstablished, int centerX, int centerY, int stationX, int stationY, long numOfResidents, int noOfNeighborhoods){
        _cityName = cityName;
        _dateEstablished = new Date(dayEstablished,monthEstablished,yearEstablished);
        _cityCenter = new Point(centerX,centerY);
        _centralStation = new Point(stationX,stationY);
        _numOfResidents = Math.max(numOfResidents,DEFAULT_RES);
        _numOfNeighborhoods = Math.max(noOfNeighborhoods, DEFAULT_NEIGBRS);
    }

    /**
     * A Copy constructor who builds a City parameter with same data field of the current city.
     * @param other - Copy parameter
     */
    public City(City other){
        _cityName = other._cityName;
        _dateEstablished = other._dateEstablished;
        _cityCenter = other._cityCenter;
        _centralStation = other._centralStation;
        _numOfResidents = Math.max(other._numOfResidents,DEFAULT_RES);
        _numOfNeighborhoods = Math.max(other._numOfNeighborhoods, DEFAULT_NEIGBRS);

    }

    //Methods

    /**
     * Returns the name of the city
     * @return - City's name
     */
    public String getCityName(){
        return _cityName;
    }

    /**
     * Returns the establishment date of the city
     * @return -Date of the establishment
     * */
    public Date getDateEstablished(){
        return _dateEstablished;
    }

    /**
     * Returns the Point-Coordinates of the city center
     * @return the point of the city center
     */
    public Point getCityCenter(){
        return _cityCenter;
    }

    /**
     * Returns the Point-Coordinates of the central station of the city
     * @return the point of the central station
     */
    public Point getCentralStation(){
        return _centralStation;
    }

    /**
     * Returns the number of the residents in the city
     * @return the number of residents
     */
    public long getNumOfResidents(){
        return _numOfResidents;
    }

    /**
     * Returns the number of neighborhoods in the city
     * @return the number of neighborhoods
     */
    public int getNumOfNeighborhoods(){
        return _numOfNeighborhoods;
    }

    /**
     * Sets the name of the city
     * @param cityName by a string
     */
    public void setCityName(String cityName){
        _cityName = cityName;
    }

    /**
     * Sets the establishment date of the city
     * @param dateEst - establishment date
     */
    public void setDateEstablished (Date dateEst){
        _dateEstablished = dateEst;
    }

    /**
     * Sets the Point of the city center
     * @param cityCenter - point coordinates
     */
    public void setCityCenter(Point cityCenter){
        _cityCenter = cityCenter;
    }

    /**
     * Sets the point of the central station
     * @param centralStation - point coordinates
     */
    public void setCentralStation(Point centralStation){
        _centralStation = centralStation;
    }

    /**
     * Sets the number of residents in the city
     * @param numOfResidents - up to Math.pow(2,63)-1
     */
    public void setNumOfResidents(long numOfResidents){
        _numOfResidents = numOfResidents;
    }

    /**
     * Sets the number of neighborhoods in the city
     * @param noOfNeighborhoods - up to Math.pow(2,31)-1
     */
    public void setNumOfNeighborhoods(int noOfNeighborhoods){
        _numOfNeighborhoods = noOfNeighborhoods;
    }

    /**
     * Prints the data according to the given format
     * @return - Given data
     */
    public String toString(){
        return "City name: " +_cityName +"\nDate established: " +_dateEstablished +"\nCity center: " +_cityCenter +"\nCentral station: " +_centralStation + "\nNumber of residents: " +_numOfResidents +"\nNumber of neighborhoods: " +_numOfNeighborhoods;

    }

    /**
     * Checks if the data of the current city is equal to parameter city
     * @param other - the data of the parameter city
     * @return - true if equals
     */
    public boolean equals(City other) {
        if ((_cityName.equals(other._cityName)) && (_dateEstablished.equals(other._dateEstablished)))
            if ((_cityCenter.equals(other._cityCenter) && (_centralStation.equals(other._centralStation))))
                return (_numOfResidents == other._numOfResidents) && (_numOfNeighborhoods == other._numOfNeighborhoods);

        return false;
    }

    /**
     * Adding or subtracting residents in the city
     * @param residentsUpdate -  the sum that we would like to add or subtract
     * @return true if the residents number is bigger then 0
     */
    public boolean addResidents(long residentsUpdate){

        _numOfResidents += residentsUpdate;
        if(_numOfResidents < DEFAULT_RES) {
            _numOfResidents = DEFAULT_RES;
            return false;
        }else{
            return true;
        }
    }

    /**
     * Moving the coordinates of the central station on the cartesian system
     * @param deltaX - The movement on X line
     * @param deltaY - The movement on Y line
     */
    public void moveCentralStation(int deltaX, int deltaY){
        _centralStation.move(deltaX, deltaY);
    }

    /**
     * Returns the distance between the city center and the city's central station in absolute value
     * @return the distance between city center and central station
     */
    public double distanceBetweenCenterAndStation(){
       return  _centralStation.distance(_cityCenter);
    }

    /**
     * Returns a new city that her name is the newCityName string, her establishment date is 1day after the
     * current city's establishment date,her location is moved by dx and dy (by match) on the cartesian system
     * from the current city,her central station is moved my dx and dy(by match) on the cartesian system
     * from the current city's central station ,her number of residents is 0, and her number of neighborhoods
     * is 0.
     * @param newCityName - New city's name
     * @param dX -  Parameter to the X line on cartesian system
     * @param dY -  Parameter to the Y line on cartesian system
     * @return Data of the new city.
     */
    public City newCity(String newCityName, int dX, int dY){
        _dateEstablished = _dateEstablished.tomorrow(); //Initializing the establishment date to tomorrow of the current city

        return new City(newCityName,_dateEstablished.getDay(),_dateEstablished.getMonth(),_dateEstablished.getYear(),_cityCenter.getX()+dX,_cityCenter.getY()+dY,_centralStation.getX()+dX,_centralStation.getY()+dY,DEFAULT_RES, DEFAULT_NEIGBRS);
    }

    /**
     * Checks if establishment date of a city is between 2 dates.
     * @param date1 - first date of parameter
     * @param date2 - second date of parameter
     * @return true if date is between
     */
    public boolean cityEstablishedBetweenDates(Date date1, Date date2){
        return (date1.before(_dateEstablished) && date2.after(_dateEstablished) || date2.before(_dateEstablished) && date1.after(_dateEstablished) || date1.equals(_dateEstablished) || date2.equals(_dateEstablished));
    }

    /**
     * Checks if 2 cities has the same establishment date
     * @param other - establishment date of parameter city
     * @return true if it has same date
     */
    public int establishmentDateDiff(City other){
       return  _dateEstablished.difference(other._dateEstablished);
    }




}


