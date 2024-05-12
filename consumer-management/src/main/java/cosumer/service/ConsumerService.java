package cosumer.service;

import common.PersonName;
import cosumer.domain.Consumer;
import cosumer.domain.dto.ConsumerResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ConsumerService {

  void validateOrderForConsumer(long consumerId, double orderTotal);

  @Transactional
  ConsumerResponse createConsumer(PersonName name);

  ConsumerResponse findById(long consumerId);
}
