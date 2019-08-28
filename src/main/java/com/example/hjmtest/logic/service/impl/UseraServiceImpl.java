package com.example.hjmtest.logic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hjmtest.logic.bean.Usera;
import com.example.hjmtest.logic.dao.UseraMapper;
import com.example.hjmtest.logic.service.UseraService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjm
 * @since 2019-08-19
 */
@Service
public class UseraServiceImpl extends ServiceImpl<UseraMapper, Usera> implements UseraService {
    @Resource
    UseraMapper useraMapper;
    public Usera test(){
        Usera usera=useraMapper.selectOne(new QueryWrapper<Usera>().eq("age",11));
        return usera;
    }
}
