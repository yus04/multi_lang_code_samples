import java.util.Scanner;  
  
public class TBL030 {  
    // 駅データを格納するクラス  
    static class Station {  
        String code; // 駅コード（ACPT, TBCD）  
        String name; // 駅名（TBNM）  
  
        Station(String code, String name) {  
            this.code = code;  
            this.name = name;  
        }  
    }  
  
    public static void main(String[] args) {  
        // 駅データの初期化（TBL-CNST に相当）  
        Station[] stations = new Station[22];  
        stations[0] = new Station("1001", "新  宿  駅  ");  
        stations[1] = new Station("1002", "大 久 保 駅 ");  
        stations[2] = new Station("1003", "東 中 野 駅 ");  
        stations[3] = new Station("1004", "中  野  駅  ");  
        stations[4] = new Station("1005", "高 円 寺 駅 ");  
        stations[5] = new Station("1006", "阿佐ヶ谷駅  ");  
        stations[6] = new Station("1007", "荻  窪  駅  ");  
        stations[7] = new Station("1008", "西 荻 窪 駅 ");  
        stations[8] = new Station("1009", "吉 祥 寺 駅 ");  
        stations[9] = new Station("1010", "三  鷹  駅  ");  
        stations[10] = new Station("1011", "武 蔵 境 駅 ");  
        stations[11] = new Station("1012", "東小金井駅  ");  
        stations[12] = new Station("1013", "武蔵小金井駅");  
        stations[13] = new Station("1014", "国 分 寺 駅 ");  
        stations[14] = new Station("1015", "西国分寺駅  ");  
        stations[15] = new Station("1016", "国  立  駅  ");  
        stations[16] = new Station("1017", "立  川  駅  ");  
        stations[17] = new Station("1018", "日  野  駅  ");  
        stations[18] = new Station("1019", "豊  田  駅  ");  
        stations[19] = new Station("1020", "八 王 子 駅 ");  
        stations[20] = new Station("1021", "西八王子駅  ");  
        stations[21] = new Station("1022", "高  尾  駅  ");  
  
        Scanner scanner = new Scanner(System.in);  
        String ACPT = ""; // 駅コード取得領域  
        int I; // 添え字領域  
  
        // メインループ  
        while (!ACPT.equals("9999")) {  
            // 駅コードの入力  
            System.out.print("駅コード X(04) TYPE-IN END･･･9999\n");  
            ACPT = scanner.nextLine();  
  
            if (ACPT.equals("9999")) {  
                // 何もしない（CONTINUE）  
                continue;  
            } else {  
                // テーブル検索  
                for (I = 0; I < stations.length; I++) {  
                    if (stations[I].code.equals(ACPT)) {  
                        break;  
                    }  
                }  
  
                // 検索結果の判定  
                if (I >= stations.length) {  
                    // 駅コードが見つからない場合  
                    System.out.println("<<< CODE - ERR >>>");  
                } else {  
                    // 結果の表示  
                    String D1CD = stations[I].code + "  "; // 駅コード＋空白2つ（X(04)B(02)）  
                    String D1NM = stations[I].name; // 駅名（X(12)）  
                    System.out.println(D1CD + D1NM);  
                    System.out.println(" "); // 改行  
                }  
            }  
        }  
  
        // リソースの解放  
        scanner.close();  
    }  
}  