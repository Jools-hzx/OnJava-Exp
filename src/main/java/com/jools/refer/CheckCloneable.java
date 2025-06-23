package com.jools.refer;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/5/3 17:12
 * @description: TODO
 */
public class CheckCloneable {

    public static Ordinary tryToClone(Ordinary ord) {
        String id = ord.getClass().getName();
        System.out.println("Attempting " + id);
        Ordinary x = null;

        // 如果实现了 Cloneable 接口
        if (ord instanceof Cloneable) {
            try {
                x = (Ordinary) ((IsCloneable) ord).clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("Could not clone " + id +
                        ", exception occur:" + e.getClass().getSimpleName());
            }
        } else {
            System.out.println("Doesn't implement Cloneable");
        }
        return x;

        /*
         执行结果:
            Attempting com.jools.refer.IsCloneable
            Attempting com.jools.refer.NotMore
            从 NoMore 开始重写 clone() 并且抛出异常；后续子类都调用 super
            Could not clone com.jools.refer.NotMore, exception occur:CloneNotSupportedException
            Attempting com.jools.refer.TryMore
            Could not clone com.jools.refer.TryMore, exception occur:CloneNotSupportedException
            Attempting com.jools.refer.BackOn
            Attempting com.jools.refer.ReallyNoMore
            Could not clone com.jools.refer.ReallyNoMore, exception occur:CloneNotSupportedException
        */
    }

    public static void main(String[] args) {
        // 向上转型
        Ordinary[] ords = {
                new IsCloneable(),
                new NotMore(),
                new TryMore(),
                new BackOn(),
                new ReallyNoMore()
        };
        Ordinary x = new Ordinary();
//        x = ((Ordinary) x).clone(); 编译错误：因为 Object 中的 clone() 是 protected 的
        for (Ordinary o : ords) {
            tryToClone(o);
        }
    }
}

// 无法克隆 - 未重写 clone()
class Ordinary {
}

// 重写 clone(), 但是未实现 Cloneable 接口
class WrongClone extends Ordinary {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// 完美克隆
class IsCloneable extends Ordinary implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// 通过抛出异常来关闭克隆
class NotMore extends IsCloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

class TryMore extends NotMore {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 调用 NoMore.clone() 来抛出异常
        return super.clone();
    }
}

class BackOn extends NotMore {

    private BackOn duplicate(BackOn b) {
        // 以某种方式生成 b 的副本，并且返回该副本; 这个副本毫无作用，只是为了举例
        return new BackOn();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 未调用 NoMore.clone()
        return duplicate(this);
    }
}

// 你无法继承该类，因此无法像 BackOn 中一样重写 clone();
final class ReallyNoMore extends NotMore {
}




