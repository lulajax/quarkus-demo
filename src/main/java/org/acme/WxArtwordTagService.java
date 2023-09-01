package org.acme;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.acme.dao.WxArtwordTagMapper;
import org.acme.data.WxArtwordTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxArtwordTagService {
    @Autowired
    private WxArtwordTagMapper artwordTagMapper;

    public List<WxArtwordTag> list() {
        return artwordTagMapper.selectList(new LambdaQueryWrapper<>());
    }
}
