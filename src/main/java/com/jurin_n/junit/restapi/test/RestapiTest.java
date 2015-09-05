package com.jurin_n.junit.restapi.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class RestapiTest {

	/*
	 * *** テストの流れ ***
	 * ＜setup＞
	 * リクエスト仕込む
	 *   ・URI
	 *   ・メソッド
	 *   ・ヘッダ
	 *   ・ボディ
	 *
	 * <execise>
	 * リクエスト実行
	 * レスポンス解析
	 *   ・ヘッダ
	 *   ・ボディ
	 *
	 * <verify>
	 * レスポンスヘッダと期待されるヘッダを比較
	 * レスポンスボディと期待されるボディを比較
	 * テスト後のDB状態と期待されるDB状態を比較
	 *
	 * *** 仕込むこと ***
	 * 1-1,テスト対象URI
	 * 1-2,メソッド
	 * 1-3,ヘッダ
	 * 1-4,ボディ
	 * 
	 * 2-1,期待されるステータスコード
	 * 2-2,ヘッダ
	 * 2-3,ボディ
	 * 
	 * 3-1,期待されるDB状態
     * 
	 * *** 仕込む場所 ***
	 * 1-1 -> Base URI(基底URI) propertiyファイル
	 *        相対 URI -> テストコードに仕込む 
	 *        
	 * 1-2と1-3 -> テストコードに仕込む
	 * 1-4 ->ファイル requestBody.txt に仕込む
	 * 
	 * 2-1と2-2 -> テストコードに仕込む
	 * 2-3 -> ファイル expectedReponseBody.txt に仕込む
	 * 
	 * 3-1 -> ????
	 * */
	@Test
	public void test() {
		
	}

}
