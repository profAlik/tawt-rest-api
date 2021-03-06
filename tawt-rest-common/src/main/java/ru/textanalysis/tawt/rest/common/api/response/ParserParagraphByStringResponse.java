package ru.textanalysis.tawt.rest.common.api.response;

import ru.textanalysis.common.rest.domain.response.BaseResponseAbstract;
import ru.textanalysis.tawt.rest.common.api.response.item.ParserParagraph;

public class ParserParagraphByStringResponse extends BaseResponseAbstract<ParserParagraph> {
    @Override
    public void createEmptyData() {
        data = new ParserParagraph();
    }
}
