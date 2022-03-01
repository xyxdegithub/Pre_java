package com.xyx.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author :xyx
 * @date :2021/6/8 0:14
 * @description:这是显示读者所借图书信息的实体类
 * @
 */
@Data
@AllArgsConstructor
public class BorrowedBook {

    private Integer id;
    private String bookName;
    private String bookAuthor;
    private String publish;
    private String readerName;
    private Integer tel;
    private Integer cardId;
    private String borrowTime;
    private String returnTime;
    private Integer state;
}
