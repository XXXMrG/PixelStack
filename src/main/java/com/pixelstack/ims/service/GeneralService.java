package com.pixelstack.ims.service;

import com.pixelstack.ims.domain.Tag;
import com.pixelstack.ims.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通用户功能
 */

@Service
public class GeneralService extends UserService {

    @Autowired
    TagMapper tagMapper;


    public boolean addTags(List<Tag> tags) {
        if (tagMapper.addTags(tags) == 0)
            return false;
        else
            return true;
    }

}
