package br.com.alura.language.controller;

import br.com.alura.language.model.Language;
import br.com.alura.language.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LanguageController {

    private final LanguageRepository repository;

    @GetMapping("/languages")
    public ResponseEntity<Page<Language>> getAllLanguages(Pageable pageable){

        log.info("Get All Languages");

        Page<Language> languages = repository.findByOrderByRanking(pageable);

        return ResponseEntity.ok(languages);
    }

    @GetMapping("/languages/{id}")
    public ResponseEntity<Language> getById(@PathVariable String id){

        log.info("Get Language By Id");

        Language language = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Language not found"));

        return ResponseEntity.ok(language);
    }

    @PostMapping("/languages")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language){

        log.info("Create new Language ");

        Language saved = repository.save(language);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/languages/{id}")
    public ResponseEntity<Language> upgradeLanguage(@PathVariable String id, @RequestBody Language language){

        log.info("Upgrade a Language By Id");

        Language lg = repository.findById(id).get();

        lg.setTitle(language.getTitle());
        lg.setImage(language.getImage());
        lg.setRanking(language.getRanking());

        Language save = repository.save(lg);

        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/languages/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable String id){

        log.info("Delete a Language By Id");

        Language lg = repository.findById(id).get();

        repository.delete(lg);

        return ResponseEntity.noContent().build();
    }

}
