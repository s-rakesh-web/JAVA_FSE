package JAVA;

class Computer{
    private String CPU;
    private String RAM;
    private String Storage;
    private String GraphicCard;

    private Computer(String CPU,String RAM,String Storage,String GraphicCard){
        this.CPU=CPU;
        this.RAM=RAM;
        this.Storage=Storage;
        this.GraphicCard=GraphicCard;
    }

    public String toString(){
        return "CPU:"+this.CPU+"\n"
                +"RAM Enabled:"+this.RAM+"\n"+
                "Storage Enabled:"+this.Storage+
                "\n"+"GraphicCard Enabled:"+this.GraphicCard;
    }

    public static class ComputerBuilder{
        private String CPU;
        private String RAM;
        private String Storage;
        private String GraphicCard;

        public ComputerBuilder(String CPU){
            this.CPU=CPU;
        }

        public ComputerBuilder enableRam(String RAM){
            this.RAM=RAM;
            return this;
        }
        public ComputerBuilder enableStorage(String Storage){
            this.Storage=Storage;
            return this;
        }

        public Computer build(){
            return new Computer(CPU,RAM,Storage,GraphicCard);
        }
        
    }
}


public class BuilderPatternExample {
    public static void main(String[] args){
        Computer comp= new Computer.ComputerBuilder("Intel")
                .enableRam("16gb")
                .build();

        Computer co=new Computer.ComputerBuilder("AMD")
                .enableRam("8gb")
                        .enableStorage("512gb")
                                .build();
        System.out.println(comp);
        System.out.println(co);
    }

}
