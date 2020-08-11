package org.openapitools.api;

import com.boggle.BoggleBoardGenerator;
import org.openapitools.api.GetBoggleBoardApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-08-10T22:37:49.212575-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.boggleSolver.base-path:}")
public class GetBoggleBoardApiController implements GetBoggleBoardApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetBoggleBoardApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<List<String>>> getBoggleBoard(@Valid MultipartFile fileName) {
        try {
            Character [][] finalBoggleBoard = new Character[5][5];
            byte[] fileBytes = fileName.getBytes();
            BoggleBoardGenerator boggleBoardGenerator = new BoggleBoardGenerator();
            finalBoggleBoard = boggleBoardGenerator.returnBoggleBoard(fileBytes);
            List<List<String>> boggleBoard = new ArrayList<>();
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
            return new ResponseEntity<>(boggleBoard, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
