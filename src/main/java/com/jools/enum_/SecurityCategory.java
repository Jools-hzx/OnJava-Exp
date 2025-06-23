package com.jools.enum_;

public enum SecurityCategory {

    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    private Security[] values;

    // 枚举类 SecurityCategory 构造器; 传入了 Security 接口的实现类，
    SecurityCategory(Class<? extends Security> kind) {
        // 通过向上转型接收 Security 接口实例中各个枚举类实例 (枚举类实例都实现了 Security)
        this.values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            // 随机获取 SecurityCategory 枚举类中的实例，
            SecurityCategory category = Enums.random(SecurityCategory.class);
            // 随机选择 SecurityCategory 枚举类实例中分组的 Security 枚举类实例
            System.out.println(category + ": "
                    + category.randomSelection());

            /*
             输出结果:
                BOND: MUNICIPAL
                BOND: MUNICIPAL
                STOCK: MARGIN
                STOCK: MARGIN
                BOND: JUNK
            */
        }
    }
}
