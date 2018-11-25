package com.fh.shop.api.add.mapper;

import com.fh.shop.api.add.po.Members;

public interface IMembersMapper {
    void addMembers(Members members);

    Members findMemberByUserName(String userName);
}
