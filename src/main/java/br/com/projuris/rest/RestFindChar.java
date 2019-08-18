package br.com.projuris.rest;

import br.com.projuris.MyFindChar;
import br.com.projuris.objects.ResultMyChar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class RestFindChar {

    @GetMapping("/findMyChar/{string}")
    private ResultMyChar findMyChar(@PathVariable(value = "string")String string){
        try{
            MyFindChar myFindChar = new MyFindChar();
            String stringResult = myFindChar.findChar(string);
            ResultMyChar resultMyChar = new ResultMyChar();
            resultMyChar.setResult(stringResult);
            return resultMyChar;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

}
