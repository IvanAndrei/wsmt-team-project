package cosumer.service;

import cosumer.domain.PersonName;
import cosumer.domain.dto.ConsumerResponse;
import org.springframework.transaction.annotation.Transactional;

public interface ConsumerService {

  void validateOrderForConsumer(long consumerId, double orderTotal);

  @Transactional
  ConsumerResponse createConsumer(PersonName name);

  ConsumerResponse findById(long consumerId);
}
