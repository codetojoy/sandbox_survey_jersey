package net.codetojoy.survey.service;

import net.codetojoy.survey.model.*;
import static net.codetojoy.survey.model.Constants.*;

import java.util.*;

class SurveyFactory {
    List<Question> buildQuestions() {
        List<Question> questions = new ArrayList<>();

        Question q1 = new Question(Q1_ID, Q1, Q1 + " question text? ");
        Question q2 = new Question(Q2_ID, Q2, Q2 + " question text? ");
        Question q3 = new Question(Q3_ID, Q3, Q3 + " question text? ");

        questions.add(q1);
        questions.add(q2);
        questions.add(q3);

        return questions;
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
