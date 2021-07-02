package com.zzu.demo.hutoolDemo.mail;

import cn.hutool.extra.mail.MailAccount;

/**
 * @author lks
 * @date 2021/3/16 13:41
 */
public class MailAccountUtil {

    /**
     * 获取默认的邮箱账户
     *
     * @return
     */
    public static MailAccount getDefaultAccount() {
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(25);
        account.setAuth(true);
        account.setFrom("李康帅<741153798@qq.com>");
        account.setUser("741153798@qq.com");
        account.setPass("fcwklifozbcdbcib");
        return account;
    }


}
