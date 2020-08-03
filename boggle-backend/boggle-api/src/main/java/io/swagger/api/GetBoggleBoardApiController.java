package io.swagger.api;

import com.boggle.BoggleBoardGenerator;
import io.swagger.model.BoggleBoard;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-31T20:55:18.710-04:00")

@Controller
public class GetBoggleBoardApiController implements GetBoggleBoardApi {

    private static final Logger log = LoggerFactory.getLogger(GetBoggleBoardApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetBoggleBoardApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BoggleBoard> getBoggleBoard(@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile imageFile) {
        try {
            Character [][] finalBoggleBoard = new Character[5][5];
            BoggleBoard boggleBoard = new BoggleBoard();
            byte[] fileBytes = imageFile.getBytes();
            BoggleBoardGenerator boggleBoardGenerator = new BoggleBoardGenerator();
            finalBoggleBoard = boggleBoardGenerator.returnBoggleBoard(fileBytes);
            for (int i = 0; i < finalBoggleBoard.length; i++){
                List<String> stringFinalBoggleBoard = new ArrayList<>();
                for (int j = 0; j < finalBoggleBoard.length; j++){
                    String letter = String.valueOf(finalBoggleBoard[i][j]);
                    stringFinalBoggleBoard.add(letter);
                    if (j == 4){
                        boggleBoard.add(stringFinalBoggleBoard);
                    }
                }
            }
            return new ResponseEntity<BoggleBoard>(boggleBoard, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
