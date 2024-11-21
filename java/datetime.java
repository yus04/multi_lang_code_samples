import java.time.LocalDateTime;  
   
public class KumikomiSample1 {  
    public static void main(String[] args) {  
        // 現在時刻の取得  
        LocalDateTime now = LocalDateTime.now();  
  
        // 各フィールドの取得  
        String YY = String.format("%04d", now.getYear());  
        String MM = String.format("%02d", now.getMonthValue());  
        String DD = String.format("%02d", now.getDayOfMonth());  
        String HH = String.format("%02d", now.getHour());  
        String MI = String.format("%02d", now.getMinute());  
        // SS と ETC は使用されていないため省略  
  
        // 現在時刻の表示  
        String DSP_BUF = "現在時刻： " + YY + "年" + MM + "月" + DD + "日" + HH + "時" + MI + "分";  
        System.out.println(DSP_BUF);  
    }  
}