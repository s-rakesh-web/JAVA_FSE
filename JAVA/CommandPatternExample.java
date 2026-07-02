package JAVA;

interface command{
    void execute();
    void undo();
}

class Light{
    void lightOn(){
        System.out.println("Light is on");
    }
    void lightOff(){
        System.out.println("Light is off");
    }
}
class lightOnCommand implements command{
    Light light;
    public lightOnCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute(){
        light.lightOn();
    }

    @Override
    public void undo() {
        light.lightOff();
    }
}

class lightOffCommand implements command{
    Light light;
    public lightOffCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.lightOff();
    }

    @Override
    public void undo() {
        light.lightOn();
    }
}

class RemoteControl{
    private command com;
    private command prevcom;

    public void setCommant(command com){
        this.com=com;

    }

    public void pressButton(){
        com.execute();
        prevcom=com;
    }
    public void pressUndo(){
        if(prevcom!=null){
            prevcom.undo();
        }
    }



}



public class CommandPatternExample {
    public static void main(String[] args){
        Light light=new Light();

        RemoteControl remote=new RemoteControl();
        remote.setCommant(new lightOnCommand(light));
        remote.pressButton();
        remote.pressUndo();
//        remote.setCommant(new lightOffCommand(light));
//        remote.pressButton();
    }
}
