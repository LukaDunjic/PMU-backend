package kviz.etf.bg.ac.rs.questions.service;

import kviz.etf.bg.ac.rs.questions.adapter.QuestionAdapter;
import kviz.etf.bg.ac.rs.questions.dto.QuestionDto;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.questions.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuestionService {

    QuestionRepository questionRepository;

    public List<QuestionDto> getAllQuestions() {
        List<QuestionsEntity> questionsEntityList = questionRepository.getAllQuestions();
        return QuestionAdapter.convertEntityToDtoList(questionsEntityList);
    }

    public QuestionDto getSpecificQuestion(Integer qId) {
        QuestionsEntity questionsEntity = questionRepository.getById(qId);
        return QuestionAdapter.convertEntityToDto(questionsEntity);
    }

    public void deleteQuestion(Integer question) {
        questionRepository.deleteById(question);
    }

    public void addQuestion(QuestionDto questionDto){
        QuestionsEntity questionsEntity = QuestionAdapter.convertDtoToEntity(questionDto);

        questionRepository.save(questionsEntity);

    }

    public List<QuestionDto> generateQuestions(Integer numberOfQuestions, Integer section) {

        List<QuestionDto> questionDtoList = new ArrayList<>();

        List<QuestionsEntity> questionsEntityList = questionRepository.getAllQuestionsBySection(section);
        List<Integer> randomNumbers = generateUniqueRandomNumbers(questionsEntityList.size(), numberOfQuestions);

        randomNumbers.forEach(element -> {
            questionDtoList.add(QuestionAdapter.convertEntityToDto(questionsEntityList.get(element)));
        });

        return questionDtoList;
    }

    private static List<Integer> generateUniqueRandomNumbers(int n, int numberOfQuestions) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers, new Random());

        return numbers.subList(0, numberOfQuestions);
    }


}
