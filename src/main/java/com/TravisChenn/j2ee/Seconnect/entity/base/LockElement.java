package com.TravisChenn.j2ee.Seconnect.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LockElement {

    /**锁体起始标识*/
    private Integer rangeStartNumber;

    /**单锁体标识*/
    private String rangeStartNumberSingle;

    /**锁体数量*/
    private Integer lockNumber;

    /**开锁密码*/
    private String openPassword;

}
