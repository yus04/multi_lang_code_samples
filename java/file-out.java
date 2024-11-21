import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
  
public class LST001 {  
    public static void main(String[] args) {  
        // ファイル状態変数  
        String FST = "00";  
  
        BufferedReader br = null;  
  
        try {  
            // ファイルを開く  
            br = new BufferedReader(new FileReader("C:\\COBOL\\FILE-OUT.CBL"));  
  
            // FSTが"00"の間繰り返す  
            while (FST.equals("00")) {  
                String F1R = null;  
  
                // ファイルから1行読み込む  
                F1R = br.readLine();  
  
                if (F1R != null) {  
                    // ファイルの終わりでない場合、行を表示  
                    System.out.println(F1R);  
                } else {  
                    // ファイルの終わりに達した場合  
                    FST = "10"; // EOF（End Of File）を示すステータスに変更  
                    // CONTINUE（何もしない）  
                }  
            }  
  
        } catch (IOException e) {  
            // ファイルのオープンや読み込みでエラーが発生した場合  
            FST = "XX"; // エラー状態を示すステータスに設定  
            e.printStackTrace();  
        } finally {  
            // ファイルをクローズ  
            if (br != null) {  
                try {  
                    br.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
  
        // プログラム終了  
        System.exit(0);  
    }  
}  