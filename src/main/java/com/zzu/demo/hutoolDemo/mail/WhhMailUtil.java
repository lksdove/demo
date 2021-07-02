package com.zzu.demo.hutoolDemo.mail;

import cn.hutool.extra.mail.MailUtil;

import java.util.List;

/**
 * @author lks
 * @date 2021/3/16 13:39
 */
public class WhhMailUtil {

    /**
     * 单人发送
     *
     * @param toUser
     * @param title
     * @param content
     * @param isHtml
     */
    public static void send(String toUser, String title, String content, boolean isHtml) {
        MailUtil.send(MailAccountUtil.getDefaultAccount(), toUser, title, content, isHtml);
    }

    /**
     * 多人发送
     *
     * @param toUserList
     * @param title
     * @param content
     * @param isHtml
     */
    public static void send(List<String> toUserList, String title, String content, boolean isHtml) {
        MailUtil.send(MailAccountUtil.getDefaultAccount(), toUserList, title, content, isHtml);
    }

}
