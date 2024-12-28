package pl.edu.pjatk.MPR_Projekt.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PiesekNotFoundException extends RuntimeException {

  public PiesekNotFoundException() {
    super("Piesek not found");
  }
}
