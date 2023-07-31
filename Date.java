/**
 *The class "Date" represent date in the year and has various functions who activated on the date.
 * Such as: Setting the tomorrow date, Calculating the difference between 2 dates,etc.
 * if the date isn't valid it will be set to 1/1/2000.
 * The method is taking account leap years.
 *
 */
public class Date {

    //Instance Variables
    private int _day;
    private int _month;
    private int _year;
    final int JAN = 1;
    final int FEB = 2;
    final int MAR = 3;

    final int APR = 4;
    final int MAY = 5;
    final int JUN = 6;
    final int JUL = 7;
    final int AUG = 8;
    final int SEP = 9;
    final int OCT = 10;
    final int NOV = 11;
    final int DEC = 12;
    final int DEFAULT_DAY = 1;
    final int DEFAULT_YEAR = 2000;
    final int END_LONG_MONTH = 31;
    final int END_SHORT_MONTH = 30;
    final int END_FEB  = 29;

    //Constructions

    /**
     * Constructor who builds the Date and in-case of invalid date returns
     * @param day - represent the day in the date
     * @param month - represent the month in the date
     * @param year - represent the year in the date
     */
    public Date(int day , int month , int year) {
        _day = day;
        _month = month;
        _year = year;
        if (!(dateIsValid(day, month, year))) {
            _day = DEFAULT_DAY;
            _month = JAN;
            _year = DEFAULT_YEAR;
        }
    }

    /**
     * Second constructor who builds another date as parameter
     * @param other -  Date parameter
     */
    public Date(Date other){
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    //Methods

    /**
     * Returns the day in the date
     * @return - returns the day in the date
     */
    public int getDay(){
        return _day;
    }

    /**
     * Returns the month in the date
     * @return - returns the month in the date
     */
    public int getMonth(){
        return _month;
    }

    /**
     * Returns the year in the date
     * @return - returns the year in the date
     */
    public int getYear(){
        return _year;
    }

    /**
     * Sets the day in the date
     * @param dayToSet - in  format DD/MM/YYYY
     */
    public void setDay(int dayToSet){
        if (dayIsValid(dayToSet))
            _day = dayToSet;
    }

    /**
     * Sets the month in the date
     * @param monthToSet - in format DD/MM/YYYY
     */
    public void setMonth(int monthToSet){
        if(monthIsValid(monthToSet))
            _month = monthToSet;

    }

    /**
     * Sets the year in the date
     * @param yearToSet - in format DD/MM/YYYY
     */
    public void setYear(int yearToSet){
        if(yearIsValid(yearToSet))
            _year = yearToSet;
    }

    /**
     * Checks if two dates are equal
     * @param other - The date to compare with the current date
     * @return true if equals
     */
    public boolean equals(Date other){
        return (_day == other._day) && (_month == other._month) && (_year == other._year);
    }

    /**
     * Checks if the current date is before the parameter date
     * @param other - The date to compare with the current date
     * @return true if it before the compared date
     */
    public boolean before (Date other){
        if(_year < other._year)
            return true;
        else if((_year == other._year) && (_month < other._month))
            return true;
        else
            return (_year == other._year) && (_month == other._month) && (_day < other._day);
    }

    /**
     * Checks if the current date is after the parameter date
     * @param other - the date to compare with the current date
     * @return true if it after the compared date
     */
    public boolean after(Date other){
        return other.before(this);
    }

    /**
     * Returns the difference between the current and parameter date
     * @param other - The compared date
     * @return - Returns the difference in absolute value
     */
    public int difference(Date other){
        return Math.abs(calculateDate(other._day,other._month,other._year) - calculateDate(_day,_month,_year));
    }

    /**
     * Represent the date in a string by format DD/MM/YYYY
     * @return the date in the format DD/MM/YYYY
     */
    public String toString(){
        return "" + days(_day) + "/" +months(_month) + "/" +years(_year);
    }

    /**
     * Returns the date of tomorrow
     * @return the tomorrow date as a new object
     */
    public Date tomorrow(){
        if (dayIsValid(_day+1))
            return new Date(_day+1,_month,_year);
        else if(!dayIsValid(_day+1) && monthIsValid(_month+1))
            return new Date(DEFAULT_DAY,_month +1 , _year);
        else
            return new Date(DEFAULT_DAY,JAN,_year +1);
    }

    //Private Methods
    private boolean dayIsValid(int day){//Checks if the number who represent the day is valid according months
            if (_month == JAN || _month == MAR || _month == MAY || _month == JUL || _month == AUG || _month == OCT || _month == DEC)
                return day >= DEFAULT_DAY && day <= END_LONG_MONTH;
            else if (_month == APR || _month == JUN || _month == SEP || _month == NOV)
                return day >= DEFAULT_DAY && day <= END_SHORT_MONTH;
            else if (_month == FEB)
                return day >= DEFAULT_DAY && day <= END_FEB;
            else
            return false;
    }

    private boolean monthIsValid(int month){//Checks if the month is valid
        return month >= JAN && month <= DEC;
    }

    private boolean yearIsValid(int year){ // Checks if the year is valid
        return year > 0 && year < 10000;
    }

    private boolean dateIsValid(int day , int month , int year){
        if (!dayIsValid(day) || !monthIsValid(month) || !yearIsValid(year))
            new Date (DEFAULT_DAY,JAN , DEFAULT_YEAR);

        return true;
    }

    private int calculateDate ( int day, int month, int year)
    {// Convert the date into numbers of days since the counting.
        if (month < MAR) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

    //Methods for the string - if needed to put 0's before the dates to complete to full format
    private String days(int day){
        if (_day/10 == 0)
            return "0" +day;
        return "" + day;
    }

    private String months(int month){
        if (_month/10 == 0)
            return "0" +month;
        return "" + month;
    }

    private String years(int year){
        if (_year/10 == 0)
            return "000" + year;
        else if(_year/100 == 0)
            return "00" + year;
        else if(_year/1000 == 0)
            return "0" + year;
        else
            return ""+ year;
    }
}
