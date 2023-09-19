package com.example.labschool.controllers;

import com.example.labschool.Dtos.AlunoDto;
import com.example.labschool.models.AlunoModel;
import com.example.labschool.repositories.AlunoRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AlunoController {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @PostMapping("aluno")
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody @Valid AlunoDto alunoDto){
        var alunoModel = new AlunoModel();
        
        BeanUtils.copyProperties(alunoDto, alunoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(alunoModel));
    } 
    
    @GetMapping("alunos")
    public ResponseEntity<List<AlunoModel>> getAllAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }
    
    @GetMapping("aluno/{id}")
    public ResponseEntity<Object> getOneAluno(@PathVariable(value="id") UUID id){
        Optional<AlunoModel> alunoO = alunoRepository.findById(id);
        if(alunoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not found");
        }
        
        Optional<AlunoDto> alunoDto = alunoO.map(AlunoDto::new);
        return ResponseEntity.status(HttpStatus.OK).body(alunoDto.get());
    }
    
    @PutMapping("aluno/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value="id") UUID id,
                                                    @RequestBody @Valid AlunoDto alunoDto){  
        Optional<AlunoModel> alunoO = alunoRepository.findById(id);
        if(alunoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not found.");
        }        
        var AlunoModel = alunoO.get();
        BeanUtils.copyProperties(alunoDto, AlunoModel);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(AlunoModel));        
    }
    
    @DeleteMapping("aluno/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value="id") UUID id){
        Optional<AlunoModel> alunoO = alunoRepository.findById(id);
        if(alunoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno not found");
        }
        
        alunoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deleted successfully.");
    
    }
}
