package demo.jardigenie.ihm;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class JardigenieHMHelpers {

    public static void sendCommonFlashMessage(RedirectAttributes redirectAttributes, int type, String message) {
        redirectAttributes.addFlashAttribute("flashMessage",
                new JardigenieFlashMessage(type, message));
    }

    public static void sendSuccessFlashMessage(RedirectAttributes redirectAttributes, String message) {
        sendCommonFlashMessage(redirectAttributes, JardigenieFlashMessage.TYPE_FLASH_SUCCES, message);

    }
}
