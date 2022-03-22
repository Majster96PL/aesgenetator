package pl.portfolio.aesgenerator.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "aes")
public class Aes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String key;
    private String encodeText;

    public Aes(String text, String key, String encodeText) {
        this.text = text;
        this.key = key;
        this.encodeText = encodeText;
    }
}
