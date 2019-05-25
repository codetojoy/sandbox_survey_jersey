package net.codetojoy.survey.service;

import net.codetojoy.survey.model.*;
import static net.codetojoy.survey.model.Constants.*;

import java.util.*;
import java.util.stream.*;

public class SurveyService {
    // This is obviously a toy example.
    private static Map<Long,Survey> mockStorage = new HashMap<>();
    private static long nextId;

    static {
        SurveyFactory surveyFactory = new SurveyFactory();

        Survey survey1 = surveyFactory.buildSurvey(SURVEY1_ID);
        Survey survey2 = surveyFactory.buildSurvey(SURVEY2_ID);
        Survey survey3 = surveyFactory.buildSurvey(SURVEY3_ID);

        mockStorage.put(survey1.getId(), survey1);
        mockStorage.put(survey2.getId(), survey2);
        mockStorage.put(survey3.getId(), survey3);

        nextId = Constants.NEXT_ID;
    }

    public List<Survey> getSurveys() {
        List<Survey> surveys = mockStorage.entrySet()
                                          .stream()
                                          .map(Map.Entry::getValue)
                                          .collect(Collectors.toList());

        return surveys;
    }

    public Survey getSurvey(long id) {
        Survey survey = mockStorage.get(id);
        return survey;
    }

    public long createSurvey(long userId) {
        long surveyId = nextId;
        Survey survey = new SurveyFactory().buildSurvey(surveyId, userId);
        mockStorage.put(surveyId, survey);
        nextId++;
        return surveyId;
    }

    protected Survey findSurveyById(long id) {
        Survey survey = mockStorage.get(id);

        return survey;
    }

    protected Answer findAnswerById(List<Answer> answers, long id) {
        Answer result = answers.stream()
                               .filter(a -> a.getId() == id)
                               .findAny()
                               .orElse(null);
        return result;
    }

    protected void updateAnswer(Answer answer, UpdateSurveyRequest updateSurveyRequest) {
        long thisAnswerId = answer.getId();
        Answer updateAnswer = findAnswerById(updateSurveyRequest.getAnswers(), thisAnswerId);

        if (updateAnswer == null) {
            answer.clear();
        } else {
            answer.doSelect(updateAnswer.getComment());
        }
    }

    protected void updateQuestion(Question question, UpdateSurveyRequest updateSurveyRequest) {
        for (Answer answer : question.getAnswers()) {
            updateAnswer(answer, updateSurveyRequest);
        }
    }

    protected void updateSurvey(Survey survey, UpdateSurveyRequest updateSurveyRequest) {
        for (Question question : survey.getQuestions()) {
            updateQuestion(question, updateSurveyRequest);
        }
    }

    public void updateSurvey(long id, UpdateSurveyRequest updateSurveyRequest) {
        Survey survey = findSurveyById(id);
        updateSurvey(survey, updateSurveyRequest);
        mockStorage.put(id, survey);
    }
}
