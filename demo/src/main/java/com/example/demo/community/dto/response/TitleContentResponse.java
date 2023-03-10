package com.example.demo.community.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TitleContentResponse {



    private String title;

    private String content;

//    @Builder
//    public TitleContentResponse(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
}
