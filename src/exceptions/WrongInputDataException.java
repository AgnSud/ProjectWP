package exceptions;

public class WrongInputDataException extends Exception{
    public WrongInputDataException (){
        super("Empty file");
    }
    public WrongInputDataException(String message){
        super(message);
    }
}
