java.util.Exception;

class QuantidadeInvalidaException extends Exception{
    public QuantidadeInvalidaException(String msg){
        System.out.println(msg);
    }
}