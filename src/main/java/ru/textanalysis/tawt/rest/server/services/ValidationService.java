package ru.textanalysis.tawt.rest.server.services;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.textanalysis.tawt.rest.server.api.request.ExistFormByStringRequest;
import ru.textanalysis.tawt.rest.server.api.request.SelectByStringRequest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class ValidationService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public Collection<? extends String> validationRequest(SelectByStringRequest request) {
        List<String> errors = new LinkedList<>();
        if (request == null) {
            String message = "Request is null";
            log.warn(message);
            errors.add(message);
        }
        //todo доделать
        return errors;
    }

    public Collection<? extends String> validationRequest(ExistFormByStringRequest request) {
        List<String> errors = new LinkedList<>();
        if (request == null) {
            String message = "Request is null";
            log.warn(message);
            errors.add(message);
        } else if (StringUtils.isBlank(request.getWord())) {
            String message = "Field 'word' is null or empty";
            log.warn(message);
            errors.add(message);
        }
        return errors;
    }
}
