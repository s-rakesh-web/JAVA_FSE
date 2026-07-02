package JAVA;

class logger{

    private static logger instance=new logger();
    private logger(){
    }
    public static logger getInstance(){
        return instance;
    }
}
class SINGLETON_PATTERN_EXAMPLE{
    public static void main(String[] args){
    logger l1=logger.getInstance();
    logger l2=logger.getInstance();

    System.out.println(l1==l2);
    }
}