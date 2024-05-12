package common;

import common.exception.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        log.info("Request error at URL: {}, with status {}", response.request().url(), response.status());
        return new FeignException("Request failed with status: " + response.status());
    }
}
