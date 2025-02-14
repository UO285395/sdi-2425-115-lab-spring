package com.uniovi.notaneitor.validators;
import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.ProfessorService;
import com.uniovi.notaneitor.services.UsersService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddProfessorValidator implements Validator{
    private final ProfessorService professorService;

    public AddProfessorValidator(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Professor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Error.empty");
        if (professor.getDNI().length() < 9) { //ultimo que sea char
            errors.rejectValue("dni", "Error.signup.dni.length");
        }
        //DNI unico
        if (professorService.getProfessorByDNI(professor.getDNI()) != null) {
            errors.rejectValue("dni", "Error.signup.dni.duplicate");
        }
        //Nombre y apellido con espacios

        //mirar el signup de User
        //Las claves de error deben estar definidas en el message properties
        //En el formulario th:object que coincida con el objeto, span por cada error

    }
}
