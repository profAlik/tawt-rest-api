package ru.textanalysis.tawt.rest.server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.textanalysis.common.rest.classes.ServiceWorksResult;
import ru.textanalysis.tawt.jmorfsdk.JMorfSdk;
import ru.textanalysis.tawt.jmorfsdk.loader.JMorfSdkFactory;
import ru.textanalysis.tawt.ms.internal.form.Form;
import ru.textanalysis.tawt.ms.internal.ref.RefOmoFormList;
import ru.textanalysis.tawt.ms.storage.OmoFormList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Lazy
@Service
public class JMorfSdkService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final JMorfSdk jMorfSdk;

    public JMorfSdkService() {
        this.jMorfSdk = JMorfSdkFactory.loadFullLibrary();
    }

    public ServiceWorksResult<OmoFormList> selectOmoformsByString(String word) {
        List<String> errors = new LinkedList<>();
        OmoFormList result = new OmoFormList();
        try {
            result = jMorfSdk.getAllCharacteristicsOfForm(word);
        } catch (Throwable ex) {
            String message = "Cannot AllCharacteristicsOfForm for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<Boolean> isFormExistsInDictionary(String word) {
        List<String> errors = new LinkedList<>();
        Boolean result = null;
        try {
            result = jMorfSdk.isFormExistsInDictionary(word);
        } catch (Throwable ex) {
            String message = "Cannot AllCharacteristicsOfForm for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<List<Long>> selectLongByString(String word) {
        List<String> errors = new LinkedList<>();
        List<Long> result = new ArrayList<>();
        try {
            result = jMorfSdk.getMorphologyCharacteristics(word);
        } catch (Throwable ex) {
            String message = "Cannot AllCharacteristicsOfForm for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<RefOmoFormList> selectRefOmoFormListByString(String word) {
        List<String> errors = new LinkedList<>();
        List<Form> forms = new ArrayList<>();
        RefOmoFormList result = new RefOmoFormList(forms);
        try {
            result = jMorfSdk.getRefOmoFormList(word);
        } catch (Throwable ex) {
            String message = "Cannot RefOmoFormList for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<List<String>> selectStringInitialFormByString(String word) {
        List<String> errors = new LinkedList<>();
        List<String> result = new ArrayList<>();
        try {
            result = jMorfSdk.getStringInitialForm(word);
        } catch (Throwable ex) {
            String message = "Cannot StringInitialForm for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<List<Byte>> selectTypeOfSpeechesByString(String word) {
        List<String> errors = new LinkedList<>();
        List<Byte> result = new ArrayList<>();
        try {
            result = jMorfSdk.getTypeOfSpeeches(word);
        } catch (Throwable ex) {
            String message = "Cannot TypeOfSpeeches for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<Byte> isInitialForm(String word) {
        List<String> errors = new LinkedList<>();
        Byte result = null;
        try {
            result = jMorfSdk.isInitialForm(word);
        } catch (Throwable ex) {
            String message = "Cannot InitialForm for word: " + String.valueOf(word);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<List<String>> selectDerivativeFormByString(String word, Byte typeOfSpeeches, Long morphologyCharacteristics) {
        List<String> errors = new LinkedList<>();
        List<String> result = new ArrayList<>();
        try {
            result = jMorfSdk.getDerivativeForm(word, typeOfSpeeches, morphologyCharacteristics);
        } catch (Throwable ex) {
            String message = "Cannot DerivativeForm For word: " + String.valueOf(word)
                    + " with type of speeches: " + String.valueOf(typeOfSpeeches) +
                    " and morphology characteristics: " + String.valueOf(morphologyCharacteristics);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<List<String>> selectDerivativeFormByString(String word, Byte typeOfSpeeches) {
        List<String> errors = new LinkedList<>();
        List<String> result = new ArrayList<>();
        try {
            result = jMorfSdk.getDerivativeForm(word, typeOfSpeeches);
        } catch (Throwable ex) {
            String message = "Cannot DerivativeForm For word: " + String.valueOf(word)
                    + " with type of speeches: " + String.valueOf(typeOfSpeeches);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }

    public ServiceWorksResult<List<String>> selectDerivativeFormByString(String word, Long morphologyCharacteristics) {
        List<String> errors = new LinkedList<>();
        List<String> result = new ArrayList<>();
        try {
            result = jMorfSdk.getDerivativeForm(word, morphologyCharacteristics);
        } catch (Throwable ex) {
            String message = "Cannot DerivativeForm For word: " + String.valueOf(word)
                    + " with morphology characteristics: " + String.valueOf(morphologyCharacteristics);
            log.warn(message, ex);
            errors.add(message);
        }
        return new ServiceWorksResult<>(result, errors);
    }
}
