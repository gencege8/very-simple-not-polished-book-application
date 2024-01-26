package bookStore;
import javax.swing.*;

public class ApplicationRun {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
	}
}
