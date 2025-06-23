package com.jools.annotation_;

import java.util.List;

/**
 * @author Jools He
 * @date 2025/6/17 16:09
 * @description: TODO
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePwd(String pwd) {
        return pwd.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPwd(String pwd) {
        return new StringBuilder(pwd).reverse()
                .toString();
    }

    @UseCase(id = 49, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPwd(List<String> prevPwd, String pwd) {
        return !prevPwd.contains(pwd);
    }
}
