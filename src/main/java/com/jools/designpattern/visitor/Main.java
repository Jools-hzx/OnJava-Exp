package com.jools.designpattern.visitor;

import org.junit.jupiter.api.Test;

/**
 * @author Jools He
 * @date 2025/7/28 2:12
 * @description: TODO
 */
public class Main {

    @Test
    public void testElementArrayList() {
        // 创建目录一
        Directory root1 = new Directory("root1");
        root1.add(new File("diary.html", 100));
        root1.add(new File("index.html", 200));

        // 创建目录二
        Directory root2 = new Directory("root2");

        // 将目录添加到集合中
        root2.add(new File("diary.html", 100));
        root2.add(new File("index.html", 200));
        ElementArrayList list = new ElementArrayList();
        list.add(root1);
        list.add(root2);

        list.accept(new ListVisitor());
    }


    @Test
    public void testSearchHtml() {

        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        // 目录下添加条目
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        // bin 目录下添加条目
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));

        System.out.println();
        System.out.println("Making user entries....");
        // 创建 usr 目录下的各个子目录
        Directory joolsDir = new Directory("jools");
        Directory billDir = new Directory("bill");
        Directory lisaDir = new Directory("lisa");
        usrDir.add(joolsDir);
        usrDir.add(billDir);
        usrDir.add(lisaDir);

        // 创建各个子目录下的条目
        joolsDir.add(new File("diary.html", 100));
        joolsDir.add(new File("Composite.html", 200));
        billDir.add(new File("memo.tex", 300));
        lisaDir.add(new File("game.doc", 400));
        lisaDir.add(new File("junk.html", 500));

        // 访问usr各个目录下的条目
        FileFindVisitor ffv = new FileFindVisitor(".html");
        SizeVisitor sizeVisitor = new SizeVisitor();
        rootDir.accept(ffv);
        System.out.println("\nHTML files are:");
        ffv.getFoundFiles().forEachRemaining(System.out::println);

        /*
         输出结果:
            Making root entries...

            Making user entries....
            /root (31500)
            /root/bin (30000)
            /root/tmp (0)
            /root/usr (1500)
            /root/usr/jools (300)
            /root/usr/bill (300)
            /root/usr/lisa (900)

            HTML files are:
            diary.html (100)
            Composite.html (200)
            junk.html (500)
        */
    }

    public static void main(String[] args) {

        System.out.println("Making root entries...");
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");

        // 目录下添加条目
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);

        // bin 目录下添加条目
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 20000));
        // 访问root各个目录下的条目
        rootDir.accept(new ListVisitor());

        System.out.println();
        System.out.println("Making user entries....");
        // 创建 usr 目录下的各个子目录
        Directory joolsDir = new Directory("jools");
        Directory billDir = new Directory("bill");
        Directory lisaDir = new Directory("lisa");
        usrDir.add(joolsDir);
        usrDir.add(billDir);
        usrDir.add(lisaDir);

        // 创建各个子目录下的条目
        joolsDir.add(new File("diary.html", 100));
        joolsDir.add(new File("Composite.java", 200));
        billDir.add(new File("memo.tex", 300));
        lisaDir.add(new File("game.doc", 400));
        lisaDir.add(new File("junk.mail", 500));

        // 访问usr各个目录下的条目
        rootDir.accept(new ListVisitor());

        /*
         输出结果:
            Making root entries...
            /root (30000)
            /root/bin (30000)
            /root/bin/vi (10000)
            /root/bin/latex (20000)
            /root/tmp (0)
            /root/usr (0)

            Making user entries....
            /root (31500)
            /root/bin (30000)
            /root/bin/vi (10000)
            /root/bin/latex (20000)
            /root/tmp (0)
            /root/usr (1500)
            /root/usr/jools (300)
            /root/usr/jools/diary.html (100)
            /root/usr/jools/Composite.java (200)
            /root/usr/bill (300)
            /root/usr/bill/memo.tex (300)
            /root/usr/lisa (900)
            /root/usr/lisa/game.doc (400)
            /root/usr/lisa/junk.mail (500)
        */
    }
}
