public interface Recipe {
	String calculate(int time, int size);
	int getTime();
}

class Ramp implements Recipe {

    @Override
    public String calculate(int time, int size) {
        // TODO Auto-generated method stub
        if(size < 50){
            System.out.println("Error: Only part sizes of 50 or above can be used in Ramp strategy");
            return null;
        }
        int pressure = time * 10;
        int power = time * 20 + size;
        if(pressure < 0){
            pressure = 0;
        }
        if(power < 0){
            power = 0;
        }
        if(pressure > 100){
            pressure = 100;
        }
        if(power > 200){
            power = 200;
        }

        return time + "," + pressure + "," + power + "\n";
    }

    @Override
    public int getTime() {
        // TODO Auto-generated method stub
        return 20;
    }

}


class ConstantCurrent implements Recipe {

    @Override
    public String calculate(int time, int size) {
        // TODO Auto-generated method stub
        int pressure = 50 - time * 2;
        int power = 50 + size;
        if(pressure < 10){
            pressure = 10;
        }
        if(power < 0){
            power = 0;
        }
        if(pressure > 200){
            pressure = 200;
        }
        if(power > 200){
            power = 200;
        }

        return time + "," + pressure + "," + power + "\n";
    }

    @Override
    public int getTime() {
        // TODO Auto-generated method stub
        return 30;
    }

}


class ConstantPressure implements Recipe {

    @Override
    public String calculate(int time, int size) {
        // TODO Auto-generated method stub
        int pressure = size + 100;
        int power = time * 2;
        if(pressure < 0){
            pressure = 0;
        }
        if(power < 0){
            power = 0;
        }
        if(pressure > 200){
            pressure = 200;
        }
        if(power > 200){
            power = 200;
        }

        return time + "," + pressure + "," + power + "\n";
    }

    @Override
    public int getTime() {
        // TODO Auto-generated method stub
        return 10;
    }

}

