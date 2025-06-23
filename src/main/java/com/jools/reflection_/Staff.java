package com.jools.reflection_;

import javax.naming.RefAddr;
import java.util.ArrayList;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/13 20:41
 * @description: TODO
 */
public class Staff extends ArrayList<Position> {

    public static void main(String[] args) {
        // 构建所有职位
        Staff staffs = new Staff(
                "President", "CET", "CTO"
                , "Marketing Manager", "Product Manager",
                "Project Leader", "Software Engineer",
                "Software Engineer", "Test Engineer",
                "Technical Support"
        );

        // 雇佣人员
        staffs.fillPosition("President", new PersonOpt("Jools", "He", "China,Shenzhen,Nanshan District"));
        staffs.fillPosition("CTO", new PersonOpt("Jools", "He", "China,Shenzhen,Nanshan District"));
        staffs.fillPosition("Project Leader", new PersonOpt("Jools", "He", "China,Shenzhen,Nanshan District"));

        for (int i = 0; i < 3; i++) {
            String name = "Software Engineer";
            if (staffs.positionAvailable(name)) {
                staffs.fillPosition(name, new PersonOpt("Jools", "Wakoo", "????"));
            } else {
                System.out.println("Position:" + name + " not available!!!");
            }
        }
    }

    // 新增工作职位
    public void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    // 新增工作职位及其人员
    public void add(String newTitle, PersonOpt person) {
        add(new Position(newTitle, person));
    }

    // 构造器；传入支持的职位名称
    public Staff(String... titles) {
        add(titles);
    }

    // 查询职位是否空缺
    public boolean positionAvailable(String title) {
        for (Position p : this) {
            if (p.getTitle().equals(title) &&
                    p.getPerson().empty) {
                return true;
            }
        }
        return false;
    }

    // 聘用人员
    public void fillPosition(String title, PersonOpt newHire) {
        for (Position p : this) {
            // 职位存在且空缺
            if (p.getTitle().equals(title) &&
                    p.getPerson().empty) {
                p.setPerson(newHire);
                System.out.println("Set" + newHire + " to Position:" + title);
                return;
            }
        }
        throw new RuntimeException("Position:" + title + " not available!");
    }
}
