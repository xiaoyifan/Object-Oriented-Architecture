import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Hardware {
	private String controlValue;
	private boolean isWorking;
	private String savingPath;

	private int PSI;
    private int AMPS;

    private BufferedWriter bw;
	
	public void execute(String value)
    {
		if(!isWorking){
			return;
		}
        // if it's working, no more execute
		this.setControlValue(value);// set the parameters

		try{
			bw.write(value);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void start()
    {
		if(isWorking) return;
		System.out.println("The hardware is on.");
		isWorking = true;
		try{
			File file = new File(savingPath);
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, false);

            bw = new BufferedWriter(fw);
            //start then execute. set the write buffer here

		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void stop()
    {
		if(!isWorking) return;
        // if it's not working, no more stop
		System.out.println("The hardware is off.");
		isWorking = false;
		try{
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public boolean isWorking()
    {
		return isWorking;
	}


    public String getControlValue() {
        //can also get from subsystems
        return controlValue;
    }

    public void setControlValue(String controlValue)
    {
        this.controlValue = controlValue;
        //set the subsystems
        String[] separateParts = controlValue.split(",");
        if(separateParts.length < 3 || separateParts[1].length() > 3)
            return;  //first line parsing, the format is wrong
        int pressure = Integer.parseInt(separateParts[1]);
        int power = Integer.parseInt(separateParts[2].substring(0, separateParts[2].length() - 1));
        this.PSI = pressure;
        this.AMPS = power;
    }

	public String getSavingPath() {
		return savingPath;
	}

	public void setSavingPath(String savingPath) {
		this.savingPath = savingPath;
	}
}
