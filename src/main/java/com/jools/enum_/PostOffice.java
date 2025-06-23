package com.jools.enum_;

import com.google.common.primitives.SignedBytes;
import org.junit.platform.commons.function.Try;

import static com.jools.enum_.Mail.Readability.ILLEGIBLE;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/4/26 19:18
 * @description: TODO
 */
public class PostOffice {

    enum MailHandler {

        /**
         * 枚举 MailHandler 的枚举常量实现(继承 MailHandler);
         * 针对 GeneralDelivery.YES 处理
         */
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivery " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returing " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        for (MailHandler handler : MailHandler.values()) {
            // 成功处理则返回
            if (handler.handle(m)) return;
        }
        // 否则为死信
        System.out.println(m + " is dead letter");
    }

    public static void main(String[] args) {
        Iterable<Mail> mailIterator = Mail.gen(10);
        for (Mail mail : mailIterator) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("**********");
        }
    }
}
