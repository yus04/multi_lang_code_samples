**********  ( 定数を持つテーブル )  **********

 IDENTIFICATION             DIVISION.
 PROGRAM-ID.                TBL030.
 DATA                       DIVISION.
 WORKING-STORAGE            SECTION.
*駅コード取得領域 *****
 01  ACPT                   PIC X(04).

*添え字領域 *****
 01  I                      PIC 9(02).
*表示用編集領域 *****
 01  D1R.
     03  D1CD               PIC X(04)B(02).
     03  D1NM               PIC X(12).
***** ( 文字定数領域 ) *****
 01  TBL-CNST.
     03  PIC X(16)  VALUE "1001新  宿  駅  ".
     03  PIC X(16)  VALUE "1002大 久 保 駅 ".
     03  PIC X(16)  VALUE "1003東 中 野 駅 ".
     03  PIC X(16)  VALUE "1004中  野  駅  ".
     03  PIC X(16)  VALUE "1005高 円 寺 駅 ".
     03  PIC X(16)  VALUE "1006阿佐ヶ谷駅  ".
     03  PIC X(16)  VALUE "1007荻  窪  駅  ".
     03  PIC X(16)  VALUE "1008西 荻 窪 駅 ".
     03  PIC X(16)  VALUE "1009吉 祥 寺 駅 ".
     03  PIC X(16)  VALUE "1010三  鷹  駅  ".
     03  PIC X(16)  VALUE "1011武 蔵 境 駅 ".
     03  PIC X(16)  VALUE "1012東小金井駅  ".
     03  PIC X(16)  VALUE "1013武蔵小金井駅".
     03  PIC X(16)  VALUE "1014国 分 寺 駅 ".
     03  PIC X(16)  VALUE "1015西国分寺駅  ".
     03  PIC X(16)  VALUE "1016国  立  駅  ".
     03  PIC X(16)  VALUE "1017立  川  駅  ".
     03  PIC X(16)  VALUE "1018日  野  駅  ".
     03  PIC X(16)  VALUE "1019豊  田  駅  ".
     03  PIC X(16)  VALUE "1020八 王 子 駅 ".
     03  PIC X(16)  VALUE "1021西八王子駅  ".
     03  PIC X(16)  VALUE "1022高  尾  駅  ".
***** ( 文字定数領域をテーブルとして再定義する ) *****

 01  TBL  REDEFINES  TBL-CNST.
     03  TB  OCCURS  22.
*        *** 駅コード ***
         05  TBCD  PIC X(04).
*        ***   駅名   ***
         05  TBNM  PIC X(12).
 PROCEDURE                  DIVISION.
     PERFORM  UNTIL  ACPT  =  "9999"
         DISPLAY  "駅コード"  X(04)  TYPE-IN  END･･･9999"
*        *** (駅コード取得) ***
         ACCEPT  ACPT
         IF  ACPT  =  "9999"
             THEN  CONTINUE
*            *** (テーブル検索) ***
             ELSE  PERFORM VARYING I FROM 1 BY 1
                           UNTIL I > 22 OR ACPT = TBCD(I)
                       CONTINUE
                   END-PERFORM
*                  *** (検索結果の判定) ***
                   IF  I  >  22
                       THEN  DISPLAY  "<<< CODE - ERR >>>"
*                      *** (結果の表示) ***
                       ELSE  MOVE  TBCD(I)  TO  D1CD
                             MOVE  TBNM(I)  TO  D1NM
                             DISPLAY  D1R   DISPLAY " "
                   END-IF
         END-IF
     END-PERFORM
     STOP  RUN.