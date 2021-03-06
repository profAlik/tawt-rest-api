package ru.textanalysis.tawt.rest.common.api.response.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import ru.textanalysis.common.rest.domain.response.item.ResponseItem;

import java.io.Serializable;
import java.util.List;

public class SelectOmoforms implements ResponseItem, Serializable {
    @ApiModelProperty(value = "Список омоформ для заданному слову")
    @JsonProperty
    private List<TransportOmoFormItem> omoForms;

    public List<TransportOmoFormItem> getOmoForms() {
        return omoForms;
    }

    public void setOmoForms(List<TransportOmoFormItem> omoForms) {
        this.omoForms = omoForms;
    }
}
