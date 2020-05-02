package COMP90082.team18.ePortfolioAPI.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LanguageDTO extends DTO {
    private Long id;
    private String language;
    private String proficiency;
}
