package order.domain;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import lombok.Getter;
import lombok.Setter;

@Access(AccessType.FIELD)
@Getter
@Setter
public class PaymentInformation {

  private String paymentToken;
}
