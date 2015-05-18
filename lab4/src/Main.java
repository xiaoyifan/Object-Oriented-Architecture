import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();
		//manually
		ui.manualRun(12, 130, 10, 60);
		//constant pressure
		ui.executeRecipe("LAB4_recipe1.csv");
		//constant current
		ui.executeRecipe("LAB4_ConstantCurrent.csv");
		//ramp
		ui.executeRecipe("LAB4_Ramp.csv");		
	}

}
