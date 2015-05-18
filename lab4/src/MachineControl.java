import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MachineControl {
	private Recipe recipe;
	private Hardware hardware = new Hardware();
	
	public boolean execute(String recipe, int time, int partsize) throws IOException
    {
		hardware.start();
		hardware.execute(recipe);
        //write the primary values
		for(int i = 0; i <= time; i++){
			String res = this.recipe.calculate(i, partsize);
			hardware.execute(res);
		}
		hardware.stop();

		int type = this.recipe.getTime();
		String path = null;
		//find out which reference file to compare with
		if(type == 10){
			path = "LAB4_recipe1.csv.reference.csv";
		}
		else if(type == 30){
			path = "LAB4_ConstantCurrent.csv.reference.csv";
		}
		else{
			path = "LAB4_Ramp.csv.reference.csv";
		}

        return validate(path);
	}

	public void manualRun(int time, int psi, int amps, int part) throws IOException{
		hardware.start();
		String s = "Manual\n";
		hardware.execute(s);
		for(int i = 0; i <= time; i++){
			String result = i + "," + psi + "," + amps + "\n";				
			hardware.execute(result);
		}
		hardware.stop();
    	System.out.println();
	}
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getControlValue() {
		return hardware.getControlValue();
	}

	public void setControlValue(String controlValue) {
		hardware.setControlValue(controlValue);
	}
	//compare with the reference file
	public boolean validate(String path) throws IOException{

		String res_path = hardware.getSavingPath();
		BufferedReader das = new BufferedReader(new FileReader(path));
		BufferedReader res = new BufferedReader(new FileReader(res_path));
        //get data from original data file and the result file.

		while (true) {
		    String s1 = das.readLine();
		    String s2 = res.readLine();
		    
		    if (s1 == null || s2 == null){
		    	break;	    	
		    } else if (!s1.equals(s2.trim())) {
		    	System.out.println("result: Bad part\n");
		    	das.close();
		    	res.close();
		    	return false;
		    }		   
	    }
		String s1 = das.readLine();
	    String s2 = res.readLine();
		
		if (s1 == null && s2 == null){
			System.out.println("result: Good part\n");
	    	das.close();
	    	res.close();
			return true;
		}
		System.out.println("result: Bad part\n");
    	das.close();
    	res.close();
		return false;
	}
	

	public String getResultpath() {
		return hardware.getSavingPath();
	}

	public void setResultpath(String resultpath) {
		hardware.setSavingPath(resultpath);
	}

}
