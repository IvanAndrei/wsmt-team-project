package cosumer.domain.dto;


import common.PersonName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerResponse {
    private long id;
    private PersonName name;
}
