package br.com.projuris.rest;

import br.com.projuris.MyFindArray;
import br.com.projuris.MyFindChar;
import br.com.projuris.objects.MyArray;
import br.com.projuris.objects.ResultMyChar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class RestFindArray {
    public static final Logger logger = LoggerFactory.getLogger(RestFindChar.class);

    @RequestMapping(value = "/findArray/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Integer> findMyChar(@RequestBody MyArray myArray){

        int[] array = myArray.getArray();
        int[] subArray = myArray.getSubArray();

        MyFindArray myFindArray = new MyFindArray();
        int result =  myFindArray.findArray(array,subArray);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
