package com.jools.designpattern.composite;

/**
 * @author Jools He
 * @date 2025/7/27 16:07
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Making root entries....");
        Directory rootDir = new Directory("src/main/java/com/jools/designpattern/composite/root");
        Directory binDir = new Directory("src/main/java/com/jools/designpattern/composite/root/bin");
        Directory tmpDir = new Directory("src/main/java/com/jools/designpattern/composite/root/tmp");
        Directory usrDir = new Directory("src/main/java/com/jools/designpattern/composite/root/bin/usr");

        System.out.println("Adding first level sub - directory....");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("src/main/java/com/jools/designpattern/composite/root/bin/vi", 10000));
        binDir.add(new File("src/main/java/com/jools/designpattern/composite/root/bin/latex", 20000));
        rootDir.printList();

        System.out.println();
        System.out.println("Making user entries.... Adding sub directories");
        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");
        usrDir.add(yuki);
        usrDir.add(hanako);
        usrDir.add(tomura);

        System.out.println("Adding children to the usr - directory....");
        yuki.add(new File("src/main/java/com/jools/designpattern/composite/root/yuki/diary.html", 10000));
        yuki.add(new File("src/main/java/com/jools/designpattern/composite/root/yuki/Composite.java", 200));
        hanako.add(new File("src/main/java/com/jools/designpattern/composite/root/usr/hanako/memo.tex", 300));
        tomura.add(new File("src/main/java/com/jools/designpattern/composite/root/usr/hanako/game.doc", 400));
        tomura.add(new File("src/main/java/com/jools/designpattern/composite/root/usr/hanako/junk.mail", 500));
        rootDir.printList();
    }
}
