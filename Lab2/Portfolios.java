public class Portfolios extends Component{
	private BondList bonds;
	private Iterator it;
	public Portfolios(String name, Component a, Component b, Component c){
		this.name = name;
		bonds = new BondList();
		bonds.add(new ListNode(a));
		bonds.add(new ListNode(b));
		bonds.add(new ListNode(c));
		it = new BondIterator(bonds);
		ListNode cur = bonds.getHead();
		this.PV = a.getPV() + b.getPV() + c.getPV();
		this.MacD = (a.getMacD()*a.getPV() + b.getMacD() * b.getPV() + c.getMacD() * c.getPV())/this.PV;
		this.ModD = (a.getModD()*a.getPV() + b.getModD() * b.getPV() + c.getModD() * c.getPV())/this.PV;
	}
	public void add(Component d){
		bonds.add(new ListNode(d));

		MacD = (MacD * PV + d.getMacD() * d.getPV()) / (PV + d.getPV());
		ModD = (ModD * PV + d.getModD() * d.getPV()) / (PV + d.getPV());
		PV += d.getPV();
	}
	public void remove(Component d){
		bonds.remove(d);
		MacD = (MacD * PV - d.getMacD() * d.getPV()) / (PV - d.getPV());
		ModD = (ModD * PV - d.getModD() * d.getPV()) / (PV - d.getPV());
		PV -= d.getPV();
	}
	public void print(){
		System.out.println("This is portfolio \"" + name + "\". MacD: " + MacD + ". ModD: " + ModD);
		
	}
	public Iterator iterator(){
		return it;
	}
}
