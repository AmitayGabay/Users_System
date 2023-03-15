package com.example.Users_System.external_api;

import com.example.Users_System.model.AnswerRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "externalapi",
        url = "${externalApi.polls.url}"
)
public interface PollsSystemService {
    @PostMapping(value = "/answer-the-question")
    String answerTheQuestion(@RequestBody AnswerRequest answerRequest);

    @DeleteMapping(value = "/delete-answers-by-user", params = "id")
    String deleteAnswersByUserId(@RequestParam Integer id);

    @GetMapping(value = "/numbers-of-answers-per-user", params = "id")
    Integer getNumberOfAnswersPerUser(@RequestParam Integer id);

    @GetMapping(value = "/user-answers-to-each-question-he-submitted", params = "id")
    String getUserAnswersToEachQuestionHeSubmitted(@RequestParam Integer id);
}
