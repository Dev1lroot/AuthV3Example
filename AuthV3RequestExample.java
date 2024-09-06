import java.net.HttpURLConnection;
import java.net.URL;
import fr.dev1lroot.libcrypto.GenerateSHA256;

public class AuthV3RequestExample
{
    public static void main(String[] args) throws Exception
    {
        // Создаем ссылку и HTTP-Клиент
        URL obj = new URL("https://api.mcskill.net/v2/economy/get?username=Dev1lroot");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Устанавливаем для него метод запроса и заголовок с нашим ключом
        con.setRequestMethod("GET");

        // Этой строкой вы генерируете SHA-256 хэш в виде HEX чисел 
        con.setRequestProperty("Tech-Auth", GenerateSHA256("v2://username:apikey@client_ip_address:server_id/section/action"));
        // username - ник игрока
        // apikey - ваш ключ от сервера
        // client_ip_address - IP адрес игрока которому вы выдаете ключ
        // server_id - ID вашего сервера
        // section / action - путь до эндпоинта (без учета GET параметров)
      
        // Получаем и обрабатываем ответ как хотим
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
    }
}
