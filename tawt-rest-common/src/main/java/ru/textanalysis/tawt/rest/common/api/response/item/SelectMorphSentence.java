package ru.textanalysis.tawt.rest.common.api.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import ru.textanalysis.common.rest.domain.response.item.ResponseItem;

import java.io.Serializable;
import java.util.List;

public class SelectMorphSentence implements ResponseItem, Serializable {
    @ApiModelProperty(value = "Список refBearingPhraseList по заданному предложению")
    @JsonProperty
    private List<MorphBearingPhrase> refBearingPhraseList;

    public List<MorphBearingPhrase> getRefBearingPhraseList() {
        return refBearingPhraseList;
    }

    public void setRefBearingPhraseList(List<MorphBearingPhrase> refBearingPhraseList) {
        this.refBearingPhraseList = refBearingPhraseList;
    }
}
