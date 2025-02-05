package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {
    private final List<Professor> professors = new ArrayList<>();

    @PostConstruct
    public void init() {
        professors.add(new Professor(1L,"123", "Carmelo", "Suarez", "Catedratico"));
        professors.add(new Professor(2L,"1234", "Paco", "Fernandez", "Profesor adjunto"));
    }


   public List<Professor> getProfessors() {
    return professors;
   }

    public Professor getProfessor(Long id) {
        return professors.stream().filter(professor->professor.getId().equals(id)).findFirst().get();
    }

   public void addProfessor(Professor professor) {
    professors.add(professor);
   }

   public String detailsProfessor(Professor professor) {
       return professor.toString();
   }

   public void deleteProfessor(Long id) {
    professors.removeIf(professor-> professor.getId().equals(id));
   }

}
