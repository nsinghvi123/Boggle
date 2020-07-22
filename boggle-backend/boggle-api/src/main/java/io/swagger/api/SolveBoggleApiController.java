package io.swagger.api;

import com.boggle.BoggleWordGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.BoggleBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-18T11:45:23.562-04:00")

@Controller
public class SolveBoggleApiController implements SolveBoggleApi {

    private static final Logger log = LoggerFactory.getLogger(SolveBoggleApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SolveBoggleApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<String>> solveBoggle(@ApiParam(value = "A 2d array representing boggle boards" ,required=true )  @Valid @RequestBody BoggleBoard boggleBoard) {
        System.out.println(boggleBoard);
        char[][] finalBoggleBoard = new char[5][5];
        List<String> currentRowOfLetters = new ArrayList();
        for (int a = 0; a < boggleBoard.size(); a++) {
            currentRowOfLetters = boggleBoard.get(a);
            for (int i = 0; i < currentRowOfLetters.size(); i++) {
                String letter = currentRowOfLetters.get(i);
                char finalLetter = letter.charAt(0);
                finalBoggleBoard[a][i] = finalLetter;
            }
        }
        BoggleWordGenerator newBoggleWordGenerator = new BoggleWordGenerator();
        try {
            HashSet<String> finalWordList = newBoggleWordGenerator.generateWords(finalBoggleBoard);
            return ResponseEntity.of(Optional.of(new ArrayList<>(finalWordList)));
        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

}
