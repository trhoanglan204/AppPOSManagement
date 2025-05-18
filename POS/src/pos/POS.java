package pos;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import ui.LoginUI;

/**
 *
 * @author crow
 */
public class POS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            UIManager.setLookAndFeel( new FlatLightLaf());
        } catch (Exception e) {
           
        }
       new LoginUI().setVisible(true);
      
    }

}
