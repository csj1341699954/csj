package com.fh.shop.api.add.controller;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.fh.shop.api.add.biz.IMembersService;
import com.fh.shop.api.add.po.Members;
import com.fh.shop.api.common.ServerResponse;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@RestController
@RequestMapping("/member")
//@Api("帅")
public class MembersApi {

    @Resource(name = "membersService")
    private IMembersService membersService;

//
//    @ApiOperation("添加一条记录")
//    @RequestMapping(value = "/addMembers")
//    public ServerResponse  addMembers(Members members) throws UnsupportedEncodingException {
//        members.setRegTime(new Date());
//        return membersService.addMembers(members);
//    }

//        @ApiOperation("添加一条记录")
        @RequestMapping(value = "/addMembers",method = RequestMethod.POST)
        public ServerResponse  addMembers(Members members) throws UnsupportedEncodingException {
        members.setRegTime(new Date());
        return membersService.addMembers(members);
    }

    @GetMapping("/queryName")
    public Object findMemberByUserName(String  userName,String callback) throws UnsupportedEncodingException {
        ServerResponse reuslt= membersService.findMemberByUserName(userName);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(reuslt);
        mappingJacksonValue.setJsonpFunction(callback);
        return  mappingJacksonValue;
    }
}
