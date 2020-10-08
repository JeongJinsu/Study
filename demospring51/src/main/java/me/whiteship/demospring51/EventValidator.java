package me.whiteship.demospring51;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //"title"이 비어있거나 공백이라면, 에러코드로 "notempty" (키값에 해당),
        // 에러코드를 찾지 못했을때 사용할 디폴트 메세지로 "Empty title is now allowed"
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is now allowed");

    }
}
