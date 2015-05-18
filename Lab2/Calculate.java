public class Calculate {


	public double MacDCalculate(double k, double y, double c, double m) {

		return ((k+y)/y - (100*(k+y) + m * (c-100*y))/(c*(Math.pow(1+y/k, m) - 1) + 100*y))/k;
	}

    public double ModDCalculate(double k, double y, double c, double m) {

        return ((k+y)/y - (100*(k+y) + m * (c-100*y))/(c*(Math.pow(1+y/k, m) - 1) + 100*y))/(k+y);
    }

}
