import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	private MachineControl mc = new MachineControl();
	//manually
	public void manualRun(int time, int psi, int amp, int partsize) throws IOException{
		System.out.println("Running manually:\n");
		mc.setResultpath("Manual.DAS.csv");
		mc.manualRun(time, psi, amp, partsize);
	}
	
	public boolean executeRecipe(String path) throws IOException{
		String res = path.substring(0, path.length() - 3) + "DAS.csv";
		mc.setResultpath(res);
		//read recipe
		Scanner input = new Scanner(new File(path));
		input.useDelimiter(",");
		ArrayList<String> words = new ArrayList<String>();
		String recipe = "";
		while(input.hasNext()){
            String next = input.next();
            recipe = recipe + next + ",";
            next = next.toLowerCase();
            //put things to a uniform way, all to lowercase
            String word = new String(next);
            words.add(word);            
        }
		//parse the file content
        //choose the right strategy with regard to the content of file.

		if(words.get(1).equals("ramp")){
        	mc.setRecipe(new Ramp());
        } else if(words.get(1).equals("constantpressure")){
        	mc.setRecipe(new ConstantPressure());
        } else if(words.get(1).equals("constantcurrent")){
        	mc.setRecipe(new ConstantCurrent());
        } else {
        	System.out.println("ERROR: Could not read recipe file");
        }
		System.out.println("Running in Recipe " + words.get(1) + ":\n");
		int partsize = Integer.parseInt(words.get(2));
		input.close();
		int time = mc.getRecipe().getTime();
		return mc.execute(recipe.substring(0, recipe.length() - 1) + "\n", time, partsize);
	}

	public String getControlValue() {
		return mc.getControlValue();
	}

	public void setControlValue(String controlValue) {
		mc.setControlValue(controlValue);
	}
}
