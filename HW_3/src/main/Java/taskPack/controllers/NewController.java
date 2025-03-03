package taskPack.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class NewController {
    @GetMapping("/uuid")
    public String successPage() {
        long uuid = (long) ( Math.random() * 4294836225L );
        String strUuid ;
        strUuid = "" + uuid;
        return strUuid;
    }
    @GetMapping("/notfound")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFound() {
    }
    @GetMapping("/exchange")
    @ResponseBody
    public String jsExchange() {
        int uuid = (int) ( Math.random() * 255 );
        String strUuid ;
        strUuid = "" + uuid;
        return strUuid;
    }
    @GetMapping("/exchange/{currency}")
    @ResponseBody
    public String jsExchange2(@PathVariable("currency") int currency) {
        String strUuid ;
        strUuid = "" + currency;
        return strUuid;
    }

}