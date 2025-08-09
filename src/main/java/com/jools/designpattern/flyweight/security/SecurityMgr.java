package com.jools.designpattern.flyweight.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jools He
 * @date 2025/7/29 21:38
 * @description: TODO
 */
public class SecurityMgr {

    private static SecurityMgr securityMgr = new SecurityMgr();

    private SecurityMgr() {
    }

    public static SecurityMgr getInstance() {
        return securityMgr;
    }

    /**
     * 运行期间用来存放登录人员对应的权限
     */
    private Map<String, Collection<Flyweight>> map = new HashMap<>();

    /**
     * 模拟登录的功能
     */
    public void login(String user) {
        Collection<Flyweight> col = queryByUser(user);
        map.put(user, col);
    }

    /**
     * 判断某用户对某个安全实体是否拥有某权限
     *
     * @param user           被检测权限的用户
     * @param securityEntity 安全实体
     * @param permit         权限
     * @return true表示拥有相应权限，false表示没有相应权限
     */
    public boolean hasPermit(String user, String securityEntity, String permit) {
        Collection<Flyweight> col = map.get(user);
        if (col == null || col.isEmpty()) {
            System.out.println(user + "没有登录或是没有被分配任何权限");
            return false;
        }
        for (Flyweight fm : col) {
            //输出当前实例，看看是否同一个实例对象
            System.out.println("fm==" + fm);
            if (fm.match(securityEntity, permit)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从数据库中获取某人所拥有的权限
     *
     * @param user 需要获取所拥有的权限的人员
     * @return 某人所拥有的权限
     */
    private Collection<Flyweight> queryByUser(String user) {
        Collection<Flyweight> col = new ArrayList<Flyweight>();
        for (String s : TestDB.colDB) {
            String ss[] = s.split(",");
            if (ss[0].equals(user)) {
                Flyweight fm = FlyweightFactory.getInstance().getFlyweight(ss[1] + "," + ss[2]);
                col.add(fm);
            }
        }
        return col;
    }
}
