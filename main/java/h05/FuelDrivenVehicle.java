package h05;

public class FuelDrivenVehicle extends MeansOfTransport implements FuelDriven {

    private FuelType fuelType;

    public FuelType getFuelType() {

        return fuelType;
    }

    public double getAverageConsumption(double speed) {

        if (speed < 0) {
            return 0;
        } else if (speed > 200) {
            return 20;
        } else if (speed <= 200 && speed > 0) {

            return 0.1 * speed;
        }
        return speed;
    }

    private int fillingLevel;

    public int getFillingLevel() {
        return fillingLevel;
    }

    public void fillUp(int fillValue) {

        if (fillValue >= 0) {
            fillingLevel += fillValue;
        }
    }

    public int letMeMove(int distance) {

        if (distance < 0) {
            return 0;
        }
        else if ((distance < 10*fillingLevel) && (distance >= 0)) {

            fillingLevel = (fillingLevel) - (distance/10);

            return distance;
        }
        else {
            fillingLevel = 0;

            return 0;
        }
    }

    public FuelDrivenVehicle (FuelType fuelType, TransportType transportType, int fillingLevel){

        this.fuelType = fuelType;
        this.transportType = transportType;
        this.fillingLevel = fillingLevel;
    }


}
