package pl.edu.pjatk.MPR_Projekt.exception;

public class PiesekNotFoundException extends RuntimeException {

  public PiesekNotFoundException() {
    super("Piesek not found");
  }
}
