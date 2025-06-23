package com.jools.designpattern.state;

/**
 * @author Jools He
 * @date 2025/6/22 16:29
 * @description: TODO
 */
public class FloorCleaner {

    private Attachment attachment = new Vaccum();

    public void change(Attachment attachment) {
        this.attachment = attachment;
    }

    public void clean() {
        attachment.action();
    }

    public static void main(String[] args) {
        FloorCleaner fc = new FloorCleaner();
        fc.clean();
        System.out.println("Change Attachment Impl (Change State)");
        fc.change(new Mop());
        fc.clean();
    }
}

interface Attachment {
    void action();
}

class Vaccum implements Attachment {

    @Override
    public void action() {
        System.out.println("Vacuuming");
    }
}

class Mop implements Attachment {

    @Override
    public void action() {
        System.out.println("Mopping");
    }
}