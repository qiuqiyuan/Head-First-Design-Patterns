import java.util.*;

interface Subject {
    public void regObvs(Observer o);
    public void rmObvs(Observer o);
    public void ntfObvs();
}

interface Observer {
    public void update();
}

interface Display {
    public void display();
}

class HumidityDisplay implements Observer, Display{
    private Subject weatherdata;

    public HumidityDisplay(Subject weatherdata){
        this.weatherdata = weatherdata;
        weatherdata.regObvs(this);
    }

    public void update(){};
    public void display(){};
}

class TempuratureDisplay implements Observer, Display{
    private Subject weatherdata;

    public TempuratureDisplay(Subject weatherdata){
        this.weatherdata = weatherdata;
    }

    public void update(){};
    public void display(){};
}

class PressureDisplay implements Observer, Display{
    private Subject weatherdata;

    public PressureDisplay(Subject weatherdata){
        this.weatherdata = weatherdata;
    }

    public void update(){};
    public void display(){};
}

class WeatherData implements Subject{
    private int tempurature;
    private int humidity;
    private int pressure;
    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public int getTempurature(){
        return tempurature;
    }
    
    public int getHumidity(){
        return humidity;
    }

    public int getPressure(){
        return pressure;
    }

    public void measurementsChanged(){
        ntfObvs();
    }

    public void setMeasurements(int tempurature){
        this.tempurature = tempurature;
    }

    //Implement Subject interface
    public void regObvs(Observer o){
        observers.add(o);
    }

    public void rmObvs(Observer o){
        int i = observers.indexOf(o);
        if (i >=0 ) observers.remove(i);
    }
    
    public void ntfObvs() {
        for(Observer o : observers){
            o.update();
        }
    }
}

public class WeatherStation {
    public static void main (String[] args) {
        WeatherData wd = new WeatherData();
        HumidityDisplay hd = new HumidityDisplay(wd);
        PressureDisplay pd = new PressureDisplay(wd);
        TempuratureDisplay td  = new TempuratureDisplay(wd);


    }
}
