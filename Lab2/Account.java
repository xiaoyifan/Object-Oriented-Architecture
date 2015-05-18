public class Account {
	Portfolios root;
	public Account(){
        Component a = new Bond("a", 0.04, 2, 20, 10, 0.0250, 20);
        Component b = new Bond("b", 0.01, 1, 19, 7, 0.04, 15);
        Component c = new Bond("c", 0.1, 3, 30, 18, 0.02, 20);
		root = new Portfolios("root", a, b, c);
        Component a2 = new Bond("a2", 0.04, 2, 20, 10, 0.0250, 25);
        Component b2 = new Bond("b2", 0.01, 1, 19, 7, 0.04, 15);
        Component c2 = new Bond("c2", 0.1, 3, 30, 18, 0.02, 20);

        Component a3 = new Bond("a3", 0.04, 2, 10, 10, 0.0250, 20);
        Component b3 = new Bond("b3", 0.015, 1, 19, 7, 0.05, 11);
        Component c3 = new Bond("c3", 0.1, 3, 30, 18, 0.02, 14);

        Component x1 = new Portfolios("x1", a2, b2, c2);
        Component x2 = new Portfolios("x2", a3, b3, c3);
		root.add(x1);
		root.add(x2);
		
		
	}
	public void print(){
		root.print();
		Iterator it = ((Portfolios) root).iterator();
		while(it.hasNext()){
			it.next().val.print();
		}
	}
}
