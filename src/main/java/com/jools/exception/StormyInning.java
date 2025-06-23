package main.java.com.jools.exception;

import cn.hutool.dfa.FoundWord;
import com.fasterxml.jackson.databind.ser.Serializers;

import javax.print.DocFlavor;

class BaseballException extends Exception {}

class Foul extends BaseballException {}

class Strike extends BaseballException {}

public class StormyInning extends Inning implements Storm {
    // 构造器可以添加新异常，到那时必须处理基类构造器的异常
    public StormyInning() throws RainedOut, BaseballException {}

    public StormyInning(String s) throws BaseballException {}

//    void walk() throws PopFoul {}; 不能缩小基类方法的访问权限


//    @Override
//    public void event() throws RainedOut{} 基类中存在的方法，接口中不能新增异常

    @Override
    public void rainHard() throws RainedOut {}  // 基类中不存在的方法，接口可以自行声明

    @Override
    public void event(){} // 基类中该方法抛出 RainOut，但是子类可以规定不抛出

    @Override
    public void atBat() throws PopFoul {}   // PopFoul 为 Foul 的子类；重写的方法可以抛出其基类版本所说明的异常子类

    public static void main(String[] args) {
        try {
            // 运行类型和编译类型一致: StormyInning si
            StormyInning si = new StormyInning();   // 构造器抛出: RainedOut, BaseballException
            si.atBat();
        } catch (PopFoul e) {   // atBat() 方法抛出 PopFoul
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        // 派生版本没有抛出 Strike
        try {
            // 向上转型，会发生什么情况？
            Inning i = new StormyInning();  // 子类构造器中抛出 RainedOut
            i.atBat();  // 父类 Inning 中抛出 Strike, Foul
            // 必须捕获来自该方法的基类版本的异常
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained Out");
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}

abstract class Inning {
    Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}   // 没有抛出检查型异常
}

class StormException extends Exception{}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

