import java.io.*;
import java.util.*;

public abstract class Component {
	protected double PV, MacD, ModD;
	String name;

	public abstract void print();
	
	public double getPV(){
		return this.PV;
	}
	
	public double getMacD(){
		return this.MacD;
	}
	
	public double getModD(){
		return this.ModD;
	}
}
