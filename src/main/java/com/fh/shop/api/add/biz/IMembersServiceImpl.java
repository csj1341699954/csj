package com.fh.shop.api.add.biz;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.fh.shop.api.add.mapper.IMembersMapper;
import com.fh.shop.api.add.po.Members;
import com.fh.shop.api.common.ServerResponse;
import com.fh.shop.api.common.SystemEnum;
import com.fh.shop.api.util.RedisUtil;
import com.opensymphony.oscache.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Service("membersService")
public class IMembersServiceImpl implements IMembersService {

    @Resource
    private IMembersMapper membersMapper;

    @Override
    public ServerResponse addMembers(Members members) throws UnsupportedEncodingException {

        if(StringUtils.isNoneBlank(members.getAreasArr())){
            String getAreasArr=members.getAreasArr();
            getAreasArr=new String(getAreasArr.getBytes("ISO-8859-1"),"utf-8");
            members.setAreasArr(getAreasArr);
        }
        if(StringUtils.isNoneBlank(members.getUserName())){
            String getUserName=members.getUserName();
            ServerResponse serverResponse = findMemberByUserName(getUserName);
            if(serverResponse.getCode()!=200){
                return serverResponse;
            }
            getUserName=new String(getUserName.getBytes("ISO-8859-1"),"utf-8");
            members.setUserName(getUserName);
        }
        String phone = members.getPhone();
        if(StringUtils.isEmpty(phone)){
            return  ServerResponse.error(SystemEnum.SMS_MOBILE_NOT);
        }
        String phoneCode = RedisUtil.get(phone);
        if(StringUtils.isEmpty(phoneCode)){
            return ServerResponse.error(SystemEnum.SMS_CODE_TIMEOUT);
        }
        if(!phoneCode.equals(members.getCode())){
            return ServerResponse.error(SystemEnum.SMS_CODE_ERROE);
        }
        membersMapper.addMembers(members);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse findMemberByUserName(String userName) throws UnsupportedEncodingException {
        if(StringUtil.isEmpty(userName)){
            return ServerResponse.error(SystemEnum.USER_NOT);
        }
        userName=new String(userName.getBytes("ISO-8859-1"),"utf-8");
        Members member=  membersMapper.findMemberByUserName(userName);
        if(member!=null){
            return  ServerResponse.error(SystemEnum.USER_NOT_EXIST);
        }
        return ServerResponse.success(member);
    }
}
