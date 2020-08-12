package org.openapitools.api;

import com.boggle.BoggleWordGenerator;
import org.openapitools.api.SolveBoggleApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-10T22:37:49.212575-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.boggleSolver.base-path:}")
public class SolveBoggleApiController implements SolveBoggleApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SolveBoggleApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<String>> solveBoggle(@Valid List<List<String>> requestBody) {
        System.out.println(requestBody);
        char[][] finalBoggleBoard = new char[5][5];
        List<String> currentRowOfLetters = new ArrayList();
        for (int a = 0; a < requestBody.size(); a++) {
            currentRowOfLetters = requestBody.get(a);
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
