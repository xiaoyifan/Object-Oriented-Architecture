public class Bond extends Component {
	private double y, k, c, m, x, i, r, t, F;

	public Bond(String name, double y, double k, double c, double x, double i, double F){
		this.name = name;
		this.y = y;
		this.k = k;
		this.c = c;
		this.x = x;
		this.i = i;
		this.F = F;
		this.m = k * x;
		this.t = m;
		this.r = i/k;
		PV = c*F*(1-1/Math.pow(1+r, t))/r + F/Math.pow(1+r, t);
		Calculate cal = new Calculate();

		this.MacD = cal.MacDCalculate(k, y, c, m);
		this.ModD = cal.ModDCalculate(k, y, c, m);
	}

	public void print(){
		System.out.println("This is individual bond \"" + name + "\". MacD: " + MacD + ". ModD: " + ModD);
	}
}
