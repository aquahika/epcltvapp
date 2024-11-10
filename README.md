このプロジェクトは[daig0rian/epcltvapp](https://github.com/daig0rian/epcltvapp)をベースに開発されています。

# EPGStation の録画を見る
"EPGStationの録画を見る"  はAndroid TV 向けに設計されたEPGStation クライアントアプリです。

リモコンの↑↓←→キー操作が基本となる Android TV から EPGStationの録画を見るために開発されました

## 特徴
 - Android TV むけ標準UIのLeanbackテーマを使用
 - Android TVのリモコンだけで操作が完結
 - Android TVのリモコン内蔵マイクから録画済番組を声で検索
 - MX Player やVLCといった外部動画プレーヤーに対応することで高い再生性能を確保

## 必要な環境
 - EPGStation Version 1.x.x or 2.x.x　(Version 1.x.xについてはある時期からテストされていません)
 - Android 5.1 以上の Android TV

## テスト環境
 - Hisense U8H 65" (US)
  - EPGStation Version 2.6.20


## daig0rian/epcltvappからの変更点
 - 海外でアプリを使用しても、放映時間を日本時間で表示する。
 - 録画番組表示カードの詳細化。タイトルと番組情報をより多くの行数で表示し、開始日時と録画分数も表示する。
 - 番組サムネイルを番組選択画面で背景として表示することを廃止
<img width="1291" alt="Screenshot 2024-11-09 at 11 41 54 PM" src="https://github.com/user-attachments/assets/f544a21c-bdae-4411-8995-8db3859b5cf5">
Android Emulator (TV)でのスクリーンキャプチャ。スクリーンキャプチャ内に含まれている放送内容の著作権は著作者に帰属します。

## 今後やりたいこと

 - BASIC認証情報の設定項目の追加
   - BASIC認証自体はフォーク元プロジェクトで既に実装済。カスタムAPI BASE URLを有効にした上で、 ベースURLを`https://user:password@{EPG_STATION_URL}/api/`の形で設定すると利用できます。自己責任で利用してください。
 - 番組内容表示画面に削除ボタンを追加
    - 番組削除自体は実装済みで、番組カードを長押しすると削除画面が表示されます。
 - 番組カード長押しで複数番組を選択して削除する機能
 - 予約番組名の横にテレビ局のロゴを表示する
 - アプリ名・アイコンの変更
 
 - 番組表の表示と録画予約機能