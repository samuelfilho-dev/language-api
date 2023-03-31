package br.com.alura.language.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mainLanguage")
public class Language {

    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

}
