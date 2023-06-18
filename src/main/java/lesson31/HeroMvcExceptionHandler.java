package lesson31;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HeroMvcExceptionHandler {

    @ExceptionHandler(HeroMvcNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlerException(Model model,HeroMvcNotFound e ) {
        model.addAttribute("message",e.getMessage());
        return "error";
    }
}
