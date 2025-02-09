package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {
//    private final List<Professor> professors = new ArrayList<>();
//
//    @PostConstruct
//    public void init() {
//        professors.add(new Professor(1L,"123", "Carmelo", "Suarez", "Catedratico"));
//        professors.add(new Professor(2L,"1234", "Paco", "Fernandez", "Profesor adjunto"));
//    }

    @Autowired
    private ProfessorRepository professorRepository;

   public List<Professor> getProfessors() {
       List<Professor> professors = new ArrayList<Professor>();
       professorRepository.findAll().forEach(professors::add);
    return professors;
   }

    public Professor getProfessor(Long id) {
//        return professors.stream().filter(professor->professor.getId().equals(id)).findFirst().get();
        return professorRepository.findById(id).get();
    }

   public void addProfessor(Professor professor) {
//    professors.add(professor);
       professorRepository.save(professor);
   }

    public void deleteProfessor(Long id) {
//    professors.removeIf(professor-> professor.getId().equals(id));
   professorRepository.deleteById(id);
   }

}
