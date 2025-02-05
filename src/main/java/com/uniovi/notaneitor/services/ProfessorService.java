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
        professors.add(new Professor(1, "Carmelo", "Suarez", "Catedratico"));
        professors.add(new Professor(2, "Paco", "Fernandez", "Profesor adjunto"));
    }


   public String getListProfessors() {
    return professors.toString();
   }

   public Professor getProfessor(Long id) {
       return professors.getFirst();
   }

   public void addProfessors(Professor professor) {
    professors.add(professor);
   }

   public String detailsProfessor(Professor professor) {
       return professor.toString();
   }

   public void deleteProfessors(Professor professor) {
    professors.remove(professor);
   }

}
