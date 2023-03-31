package br.com.alura.language.controller;

import br.com.alura.language.model.Language;
import br.com.alura.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageRepository repository;

    @GetMapping("/languages")
    public ResponseEntity<List<Language>> getAllLanguages(){

        List<Language> languages = repository.findAll();

        return ResponseEntity.ok(languages);
    }

    @PostMapping("/languages")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language){

        Language saved = repository.save(language);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
