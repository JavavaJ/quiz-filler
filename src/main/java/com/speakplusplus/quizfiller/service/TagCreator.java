package com.speakplusplus.quizfiller.service;

import com.speakplusplus.quizfiller.constants.Urls;
import com.speakplusplus.quizfiller.core.entity.Tag;
import com.speakplusplus.quizfiller.core.entity.TagPatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TagCreator {

//    @Autowired
//    RestTemplate template;
//
//    @Autowired
//    HttpHeaders headers;

    public Tag create(String name) {
        TagPatchDTO tagPatchDTO = new TagPatchDTO();
        tagPatchDTO.setName(name);

        HttpHeaders headers = WebUtils.buildHeaders();
        HttpEntity<TagPatchDTO> httpEntity = new HttpEntity<>(tagPatchDTO, headers);

        RestTemplate template = WebUtils.getTemplate();
        ResponseEntity<Tag> responseEntity = template.exchange(Urls.TAG_GET_OR_CREATE, HttpMethod.POST, httpEntity, Tag.class);
        System.out.println("Status Code: " + responseEntity.getStatusCode());
        Tag tagReturned = responseEntity.getBody();
        System.out.println("Tag: " + tagReturned);
        return tagReturned;
    }

//    public Object find() {
////        String findTagsUrl = Urls.TAG_FIND;
//
//
//    }


}

