package pl.edu.pjatk.MPR_Projekt.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StringUtilsService {



    public String lower(String text) {
        return text.toLowerCase();
    }

    public String upper(String text) {

        return text.toUpperCase();

    }
}
