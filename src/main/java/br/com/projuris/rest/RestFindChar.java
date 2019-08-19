package br.com.projuris.rest;

import br.com.projuris.MyFindChar;
import br.com.projuris.objects.ResultMyChar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/")
public class RestFindChar {
    public static final Logger logger = LoggerFactory.getLogger(RestFindChar.class);

    @RequestMapping(value = "/findMyChar/{string}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResultMyChar> findMyChar(@PathVariable(value = "string")String string){

            MyFindChar myFindChar = new MyFindChar();
            String stringResult = myFindChar.findChar(string);
            ResultMyChar resultMyChar = new ResultMyChar();
            resultMyChar.setResult(stringResult);
            return new ResponseEntity<>(resultMyChar, HttpStatus.OK);
    }

}
