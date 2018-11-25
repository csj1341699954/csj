package com.fh.shop.api.add.biz;

import com.fh.shop.api.add.po.Members;
import com.fh.shop.api.common.ServerResponse;


import java.io.UnsupportedEncodingException;

public interface IMembersService {
    ServerResponse addMembers(Members members) throws UnsupportedEncodingException;

  ServerResponse findMemberByUserName(String userName) throws UnsupportedEncodingException;

}
