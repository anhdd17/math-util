/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anhdd.mathutil.main;

import com.anhdd.mathutil.core.MathUtil;

/**
 *
 * @author DUC ANH
 */
public class Main {
    public static void main(String[] args) {
        //thử nghiệm coi hàm tính giai thừa coi chạy đúng thiết kế hay không?
        //ta phải đưa ra các tình huống sử dụng hàm trong thực tế
        //ví dụ: -5 tính được không
        //        0
        //        20
        //        21
        //TEST CASE: một tình huống hàm/app/màn hình/tính năng được đưa vào sử dụng
        //giả lập hành vi xài của ai đó!!!
        //TEST CASE: là một tình huống sử dụng, xài app (hàm) mà nó bao hàm
        //INPUT: DATA đầu vào cụ thể nào đó
        //OUTPUT: ĐẦU RA ỨNG VƠÍ XỬ LÍ CỦA HÀM/CHỨC NĂNG CỦA APP, DĨ NHIÊN DÙNG ĐẦU VÀO ĐỂ XỬ LÍ
        //KÌ VỌNG: MONG HÀM SẼ TRẢ VỀ VALUE TRẢ VỀ TỪ HÀM NÀO ĐÓ ỨNG VỚI INPUT Ở TRÊN
        //SO SÁNH ĐỂ XEM KẾT QUẢ CÓ NHƯ KÌ VỌNG HAY KO
        
        long expected = 120;    //t kì vọng hàm trả về 120 nếu tính 5!
        int n = 5;
        long actual = MathUtil.getFactorial(5);
        System.out.println("5! = " + expected +" expected");
        System.out.println("5! = " + actual + " actual");
    }
 
}
