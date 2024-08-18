package kviz.etf.bg.ac.rs.questions.service;

import jakarta.transaction.Transactional;
import kviz.etf.bg.ac.rs.chatroom.adapter.ChatroomAdapter;
import kviz.etf.bg.ac.rs.chatroom.dto.ChatroomDto;
import kviz.etf.bg.ac.rs.chatroom.service.ChatroomService;
import kviz.etf.bg.ac.rs.questions.adapter.AnswerAdapter;
import kviz.etf.bg.ac.rs.questions.adapter.QuestionAdapter;
import kviz.etf.bg.ac.rs.questions.dto.QuestionDto;
import kviz.etf.bg.ac.rs.questions.model.AnswersEntity;
import kviz.etf.bg.ac.rs.questions.model.QuestionsEntity;
import kviz.etf.bg.ac.rs.questions.repository.AnswerRepository;
import kviz.etf.bg.ac.rs.questions.repository.QuestionRepository;
import kviz.etf.bg.ac.rs.questions_for_quiz.service.QuestionsForQuizService;
import kviz.etf.bg.ac.rs.quiz.dto.QuizDto;
import kviz.etf.bg.ac.rs.quiz.model.QuizEntity;
import kviz.etf.bg.ac.rs.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuestionService {

    final QuestionRepository questionRepository;
    final QuizService quizService;
    final QuestionsForQuizService questionsForQuizService;
    final ChatroomService chatroomService;
    final AnswerRepository answerRepository;

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

    public List<QuestionDto> generateQuestionsRandom(Integer numberOfQuestions, Integer section) {

        List<QuestionDto> questionDtoList = new ArrayList<>();

        List<QuestionsEntity> questionsEntityList = questionRepository.getAllQuestionsBySection(section);
        List<Integer> randomNumbers = generateUniqueRandomNumbers(questionsEntityList.size(), numberOfQuestions);

        randomNumbers.forEach(element -> questionDtoList.add(QuestionAdapter.convertEntityToDto(questionsEntityList.get(element))));

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

    @Transactional
    public List<QuestionDto> generateQuestions(Integer section, Integer chatroomId, Integer userId) {
        int numberOfQuestions = 10;
        List<QuestionDto> questionDtoList = new ArrayList<>();

        List<QuestionsEntity> questionsEntityList = questionRepository.getAllQuestionsBySection(section);
        List<Integer> randomNumbers = generateUniqueRandomNumbers(questionsEntityList.size()-1, numberOfQuestions);
        List<QuestionsEntity> questionsEntityList1 = new ArrayList<>();
        randomNumbers.forEach(element -> {
            questionDtoList.add(QuestionAdapter.convertEntityToDto(questionsEntityList.get(element)));
            questionsEntityList1.add(questionsEntityList.get(element));
        });
        saveAllFromListInQuiz(questionsEntityList1, chatroomId, userId);
        return questionDtoList;
    }

    private String saveAllFromListInQuiz(List<QuestionsEntity> questionsEntityList, Integer chatroomId, Integer userId) {
        if (!chatroomService.isOwner(userId, chatroomId)) {
            return "Not a owner.";
        }

        QuizDto quizDto = new QuizDto();
        quizDto.setChatroom(chatroomService.getCharoomById(chatroomId));
        QuizEntity quizEntity = quizService.createQuizInternal(quizDto);

        questionsEntityList.forEach(element -> questionsForQuizService.addQuestionForQuiz(quizEntity.getQuizId(), element.getQuestionId()));
        return "Success.";
    }

    @Transactional
    public QuestionDto addQuestion(QuestionDto questionDto) {
        if (questionDto == null || questionDto.getAnswersDto() == null
                || questionDto.getSection() == null) {
            return null;
        }
        QuestionsEntity questionsEntity = QuestionAdapter.convertDtoToEntity(questionDto);
        questionsEntity.setAnswersEntityList(null);
        QuestionsEntity questionsEntity1 = questionRepository.save(questionsEntity);

        List<AnswersEntity> answersEntityList = AnswerAdapter.convertDtoToEntityList(questionDto.getAnswersDto());
        answersEntityList.forEach(element->element.setQuestionEntity(questionsEntity1));
        answerRepository.saveAll(answersEntityList);
        questionsEntity1.setAnswersEntityList(answersEntityList);

        return QuestionAdapter.convertEntityToDto(questionsEntity1);
    }

}
