package pl.edu.pjatk.MPR_Projekt.exception;

public class PiesekAlreadyExistException extends RuntimeException {

    public PiesekAlreadyExistException() {
        super("Piesek already exist");
    }
}
