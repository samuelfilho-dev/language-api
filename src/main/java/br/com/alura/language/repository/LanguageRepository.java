package br.com.alura.language.repository;

import br.com.alura.language.model.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends MongoRepository<Language, String> {

    Page<Language> findByOrderByRanking(Pageable pageable);
}
