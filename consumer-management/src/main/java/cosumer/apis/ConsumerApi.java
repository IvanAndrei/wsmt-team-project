package cosumer.apis;

import cosumer.service.ConsumerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/wsmt/consumer")
public class ConsumerApi {

  private ConsumerService consumerService;

  public ConsumerApi(ConsumerService consumerService) {
    this.consumerService = consumerService;
  }
  //
  //  @RequestMapping(method= RequestMethod.POST)
  //  public CreateConsumerResponse create(@RequestBody CreateConsumerRequest request) {
  //    ResultWithEvents<Consumer> result = consumerService.create(request.getName());
  //    return new CreateConsumerResponse(result.result.getId());
  //  }
  //
  //  @RequestMapping(method= RequestMethod.GET,  path="/{consumerId}")
  //  public ResponseEntity<GetConsumerResponse> get(@PathVariable long consumerId) {
  //    return consumerService.findById(consumerId)
  //            .map(consumer -> new ResponseEntity<>(new GetConsumerResponse(consumer.getName()),
  // HttpStatus.OK))
  //            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  //  }
}
