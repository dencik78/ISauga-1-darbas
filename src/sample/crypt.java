package sample;

public class crypt {

    String encrypt(String text, String key)
    {
//        text = text.toUpperCase();
//        key = key.toUpperCase();

        int x = text.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == text.length())
                break;
            key+=(key.charAt(i));
        }

        String encrypt_text="";

        for (int i = 0; i < text.length(); i++)
        {
            // converting in range 0-95
            if((((text.charAt(i) + key.charAt(i)) % 126) + 95) > 127) {
                //int j = (text.charAt(i) + key.charAt(i)) % 26;
                encrypt_text += (char)((((text.charAt(i) + key.charAt(i)) % 127) + 96) - 96);

            }else{
                encrypt_text += (char)(((text.charAt(i) + key.charAt(i)) % 127) + 95);
            }
        }
        return encrypt_text;
    }
//encrytp method
     String decrypt(String encrypt_text, String key)
    {

        int x = encrypt_text.length();

        for (int i = 0; ; i++)
        {
            if (x == i)
                i = 0;
            if (key.length() == encrypt_text.length())
                break;
            key+=(key.charAt(i));
        }

        String decrypt_text="";

        for (int i = 0 ; i < encrypt_text.length() && i < key.length(); i++)
        {
            if(((' ' + (encrypt_text.charAt(i) - key.charAt(i))) %126) < 32) {

                decrypt_text += (char)(((' ' + (encrypt_text.charAt(i) - key.charAt(i))) % 126) + 95);

            }
                else if(((32 + (encrypt_text.charAt(i) - key.charAt(i))) % 126) > 128) {

                    decrypt_text += (char)(((' ' + (encrypt_text.charAt(i) - key.charAt(i))) % 126) - 95);
            }
                else {
                    decrypt_text += (char)((' ' + (encrypt_text.charAt(i) - key.charAt(i))) % 126);
             }
        }
        return decrypt_text;
    }
}