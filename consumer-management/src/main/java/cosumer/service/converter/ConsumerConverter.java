package cosumer.service.converter;

import common.PersonName;
import cosumer.domain.Consumer;
import cosumer.domain.dto.ConsumerResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConsumerConverter {
  public static Consumer mapToEntity(PersonName name) {
    Consumer consumer = new Consumer();
    consumer.setName(name);
    return consumer;
  }

  public static ConsumerResponse mapToConsumerResponse(Consumer consumer) {
    return ConsumerResponse.builder().id(consumer.getId()).name(consumer.getName()).build();
  }
}
