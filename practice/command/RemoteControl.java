interface Command{
    public void execute();
}

class Light {
    public void on(){};
    public void off(){};
}

class LightOnCommand implements Command {
    Light light;
    
    public LightOnCommand(Light light){
        this.light = light;
    }

    public void execute(){
        light.on();
    }
}

class NoCommand implements Command {
    public void execute() {
        // do nothing
    }
}

public class RemoteControl {
    static final int NUM_BUTTON = 8;
    private Command[] Buttons = new Command[NUM_BUTTON];
    public void RemoteControl(){
        for(int i=0;i<NUM_BUTTON;i++){
            Buttons[i] = new NoCommand(); 
        }
    }
    public static void main (String[] args){
        RemoteControl simpleRemoteControl = new RemoteControl();
    }
}
