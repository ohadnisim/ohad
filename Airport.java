public class AirPort {
  private Flight[] _flightsSchedule;
  private int _noOfFlights;
  private String _city;
  private final int MAXFLIGHT = 200;

  public Airport(String city) {
    this.city = city;
    this._flightsSchedule = new Flight[MAXFLIGHT];
    this._noOfFlights = 0;
  }
  public boolean addFlight(Flight f) {
    if (this._noOfFlights == this.MAXFLIGHT)
      return false;
    this._flightsSchedule[this._noOfFlights] = f;
    this._noOfFlights++;
    return true;
  }
  public boolean removeFlight(Flight f) {
    int index = -1;
    for (int i = 0; i < this._noOfFlights; i++) {
      if (this._flightsSchedule[i] == f)
        index = i;
    }
    if (index == -1)
      return false;
    this._flightsSchedule[index] = this._flightsSchedule[this.noOfFlights - 1];
    this._flightsSchedule[this._noOfFlights - 1] = null;
    this._noOfFlights--;
    return true;
  }
  public Time1 firstFlightFromOrigin(String place) {
    Time firsttime = null;
    for (int i = 0; i < this._noOfFlights; i++) {
      if (this._flightsSchedule[i].get_origin.equals(place))
        if (firsttime == null)
          firsttime = this._flightsSchedule[i].get_departure();
      if (firsttime.before(this._flightsSchedule[i].get_departure()))
        firsttime = this._flightsSchedule[i].get_departure();
    }
    return firsttime;
  }
  public String toString() {
    String s = “The flights
    for airport” + this.city + ”today are: ”+”/n”;
    for (int i = 0; i < this._noOfFlights; i++) {
      s += “Flight from“ + this._flightsSchedule[i].get_origin() + ”to“ + this._flightsSchedule[i].get_destination() + ”departs at“ + this._flightsSchedule[i].get_departure() + ”.Flight is”;
      if (this._flightsSchedule[i].get_isFull())
        s += “full”;
      else
        s += “not full”;
      s += “/n”;
    }
    return s;
  }
  public int howManyFullFlights() {
    int count = 0;
    for (int i = 0; i < this._noOfFlights; i++) {
      if (this._flightsSchedule[i].get_isFull())
        count++;
    }
    return count;
  }
  public int howManyFlightsBetween(String place) {
    Flight f;
    int count = 0;
    for (int i = 0; i < this._noOfFlights; i++) {
      f = this._flightsSchedule[i];
      if (f.get_origin().equals(place) && f.get_destination().equals(this.city) || f.get_origin().equals(this.city) && f.get_destination().equals(place))
        count++;
    }
    return count;
  }
  public String mostPopularDestination() {
    if (this._noOfFlights == 0) return null;
    String[] cityA = new String[this._noOfFlights];
    for (int i = 0; i < this._noOfFlights; i++) {
      cityA[i] = “”;
    }
    boolean check;
    Flight f;
    for (int i = 0; i < this._noOfFlights; i++) {
      f = this._flightsSchedule[i];
      addCityToArray(cityA, f.get_destination())
    }
    int max = 0, count = 0;
    String citymax = “”, citycheck = “”;
    for (int i = 0; i < this._noOfFlights; i++) {
      if (cityA[i] != “”) {
        citycheck = cityA[i];
        for (int j = 0; j < this._noOfFlights; j++) {
          f = this._flightsSchedule[j];
          if (f.get_destination().equals(citycheck))
            count++;
        }
        if (count > max) {
          max = count;
          citymax = citycheck;
        }
      }
    }
    return citymax;
  }
  public static void addCityToArray(String[] cityA, String city) {
    int lastindex = -1;
    boolean check = false;
    for (int i = 0; i < cityA.length; i++) {
      if (cityA[i].equals(city) check = true;
        if (lastindex == -1 && cityA[i] == “”)
          lastindex = i;
      }
      if (!check)
        cityA[lastindex] = city;
    }
    public Flight mostExpensiveTicket() {
      if (this._noOfFlights == 0) return null;
      Flight f = this._flightsSchedule[0];
      for (int i = 0; i < this._noOfFlights; i++) {
        if (this._flightsSchedule[i].get_price() > f.get_price())
          f = this._flightsSchedule[i];
      }
      return f;
    }
    public Flight longestFlight() {
      if (this._noOfFlights == 0) return null;
      Flight f = this._flightsSchedule[0];
      for (int i = 0; i < this._noOfFlights; i++) {
        if (this._flightsSchedule[i].get_flightDuration() > f.get_flightDuration())
          f = this._flightsSchedule[i];
      }
      return f;
    }
  }