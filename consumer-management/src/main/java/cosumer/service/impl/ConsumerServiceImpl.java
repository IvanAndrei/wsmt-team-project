package cosumer.service.impl;

import common.PersonName;
import cosumer.domain.Consumer;
import cosumer.domain.dto.ConsumerResponse;
import cosumer.repository.ConsumerRepository;
import cosumer.service.ConsumerService;
import cosumer.service.converter.ConsumerConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

  private final ConsumerRepository consumerRepository;

  @Override
  public void validateOrderForConsumer(long consumerId, double orderTotal) {}

  @Override
  public ConsumerResponse createConsumer(PersonName name) {
    Consumer consumer = ConsumerConverter.mapToEntity(name);
    consumerRepository.save(consumer);
    return ConsumerConverter.mapToConsumerResponse(consumer);
  }

  @Override
  public ConsumerResponse findById(long consumerId) {
    var consumer =
        consumerRepository
            .findById(consumerId)
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "Consumer does not exists for given id: " + consumerId));
    return ConsumerConverter.mapToConsumerResponse(consumer);
  }
}
