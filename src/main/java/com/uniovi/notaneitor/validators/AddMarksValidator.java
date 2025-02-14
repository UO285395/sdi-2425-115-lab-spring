package com.uniovi.notaneitor.validators;

import com.uniovi.notaneitor.entities.Mark;
import com.uniovi.notaneitor.entities.User;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.UsersService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddMarksValidator implements Validator {
//    private final MarksService marksService;
//
//
//    public AddMarksValidator(MarksService marksService) {
//        this.marksService = marksService;
//    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Mark.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Mark mark = (Mark) target;
        if (mark.getScore() < 0 || mark.getScore() > 10) {
            errors.rejectValue("score", "Error.addMark.score.value");
        }
//        if (mark.getDescription().length() < 20) {
//            errors.rejectValue("description", "Error.addMark.description.length");
//        }
    }
}
