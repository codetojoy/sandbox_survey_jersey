package net.codetojoy.survey.service;

import net.codetojoy.survey.model.*;
import static net.codetojoy.survey.model.Constants.*;

import java.util.*;

class SurveyFactory {
    List<Answer> buildAnswers(Answer... answers) {
        List<Answer> result = new ArrayList<>();

        for (Answer answer : answers) {
            result.add(answer);
        }

        return result;
    }

    List<Question> buildQuestions() {
        List<Question> questions = new ArrayList<>();

        Question q1 = new Question(Q1_ID, Q1, Q1 + " question text? ",
                                   buildAnswers(new Answer(A1_1_ID, "answer 1.1"), new Answer(A1_2_ID, "answer 1.2"))
                                   );

        Question q2 = new Question(Q2_ID, Q2, Q2 + " question text? ",
                                   buildAnswers(new Answer(A2_1_ID, "answer 2.1"), new Answer(A2_2_ID, "answer 2.2"))
                                   );

        Question q3 = new Question(Q3_ID, Q3, Q3 + " question text? ",
                                   buildAnswers(new Answer(A3_1_ID, "answer 3.1"),
                                                new Answer(A3_2_ID, "answer 3.2"),
                                                new Answer(A3_3_ID, "answer 3.3"))
                                   );

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

        return questions;
    }

    Survey buildSurvey(long surveyId, long userId) {
        Survey survey = new Survey();

        survey.setId(surveyId);
        survey.setUserId(userId);
        survey.setQuestions(buildQuestions());

        return survey;
    }

    Survey buildSurvey(long surveyId) {
        Survey survey = new Survey();

        if (surveyId == SURVEY1_ID) {
            survey.setId(SURVEY1_ID);
            survey.setUserId(USER1_ID);
            survey.setQuestions(buildQuestions());
        } else if (surveyId == SURVEY2_ID) {
            survey.setId(SURVEY2_ID);
            survey.setUserId(USER2_ID);
            survey.setQuestions(buildQuestions());
        } else if (surveyId == SURVEY3_ID) {
            survey.setId(SURVEY3_ID);
            survey.setUserId(USER3_ID);
            survey.setQuestions(buildQuestions());
        }

        return survey;
    }
}
