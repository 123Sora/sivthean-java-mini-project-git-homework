package respository;

import model.SystemUser;

public class SystemUserRepository {
//    public static SystemUser[] getAllUsers(){
//        SystemUser[] systemUsers = new SystemUser[2];
//        systemUsers[0] = new SystemUser("admin", "password");
//        systemUsers[1] = new SystemUser("subadmin" ,"subpassword");
//        return systemUsers;
//    }
    public static SystemUser getAdminUsers(){
        return new SystemUser("admin", "password123");
    }
}
