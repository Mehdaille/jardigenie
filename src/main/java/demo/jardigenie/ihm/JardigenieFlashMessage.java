package demo.jardigenie.ihm;

public class JardigenieFlashMessage {

    public static final int TYPE_FLASH_SUCCES = 0;
    public static final int TYPE_FLASH_ERROR = 1;
    public static final int TYPE_FLASH_WARNING = 2;

    public int type;
    public String message;

    public JardigenieFlashMessage(int type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getTypeCssClass(){
        if (type == TYPE_FLASH_SUCCES) {
            return "flex items-center bg-blue-500 text-white text-sm font-bold px-4 py-3";
        }
        if(type==TYPE_FLASH_ERROR){
            return "flex items-center bg-red-500 text-white text-sm font-bold px-4 py-3";
        }
        if(type == TYPE_FLASH_WARNING){
            return "flex items-center bg-grey-100 text-white text-sm font-bold px-4 py-3";
        }
        return "flex items-center bg-white text-white text-sm font-bold px-4 py-3";
    }

}
