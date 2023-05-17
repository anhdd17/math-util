/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.andd.mathutil.test.core;

import com.anhdd.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author DUC ANH
 */
public class MathUtilityTest {
    //đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm thử/kiểm tra code chính - hàm getFactorial() bên class core.MathUtil
    //viết code để test code chính bên kia!!!
    
    //có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
    //tình huống xài hàm theo kiểu thành công và thất bại!!!
    //ta sẽ xài hàm kiểu well - đưa 5! 6!, hok chơi đưa -5!, -6!
    //@Test JUnit sẽ phối hợp với  JVM để chạy hàm này
    //@Test phía hậu trường chính là publiv static void()
    //có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0;
        long expected = 1;
        long actual = MathUtil.getFactorial(n);
        //so sánh expected vs. actual dùng xanh xanh đỏ đỏ, framework
        Assert.assertEquals(expected, actual);
        //HÀM giúp so sánh 2 giá trị nào đó có giống nhau không?
        //nếu giống nhau -> màu xanh - code ngon, ít nhất case đang test
        // nếu ko giống nhau -> màu đỏ - hàm ý expected vs actual ko giống nhau
        
        //gộp thêm vài case thành công nưax ở đây/đưa đầu vào ngon!!! hàm tính phải ngon
        Assert.assertEquals(1, MathUtil.getFactorial(n)); //tui muốn 1! == 1
        Assert.assertEquals(2, MathUtil.getFactorial(2)); //tui muốn 2! == 2
        Assert.assertEquals(6, MathUtil.getFactorial(3)); //tui muốn 3! == 6
        Assert.assertEquals(24, MathUtil.getFactorial(4)); //tui muốn 4! == 24
        Assert.assertEquals(120, MathUtil.getFactorial(5)); //tui muốn 5! == 120
        Assert.assertEquals(720, MathUtil.getFactorial(6)); //tui muốn 6! == 720
        
    }
    
    //hàm getF() ta thiết kế có 2 tình huống xử lí
        //1. đưa data tử tế trong [0...20] -> tính đúng được n! - done
        //2. đưa data vào cà chớn, âm > 20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
        //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
        //Rất mong ngoại lệ xuất hiện với n cà chớn này
        
        //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ném ra ngoại lệ
        //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> MÀU XẠNH PHẢI XUẤT 
        
        //nếu hàm nhận vào n < 0 hoặc n > 20 và hàm ÉO ném ra ngoại lệ
        //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> MÀU ĐỎ PHẢI XUẤT 
        
        //Test case input: -5
        //expected: IllegalArgumentException xuất hiện
        //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
        //là những thứ ko thể ss theo kiểu value
        //mà chỉ có thể đo lường = cách chúng có xuất hiện hay không?
        //assertEquals() ko dùng để so sánh 2 ngoại lệ
        // equals() là bằng nhau trên value hay không
    
// MÀU ĐỎ ĐÓ EM, DO HÀM NÉM SAI NGOẠI LỆ KÌ VỌNG
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsExeption() {
//        MathUtil.getFactorial(-5); //hàm @Test chạy hay getF() chạy
//                                   //sẽ ném về ngoại lệ NumberFo
//    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsExeption() {
        MathUtil.getFactorial(-5); //hàm @Test chạy hay getF() chạy
                                   //sẽ ném về ngoại lệ NumberFo
    }
      
    //CÁCH khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    //xài LAMBDA
    //testcase: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    //tui cần thấy màu xanh khi chơi với 21!
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsExeption_LambdaVersion() {
        //Assert.assertThrows(tham số 1: loại ngoại lệ mún so sánh, tham số 2 đoạn code chạy văng ra ngoại runnable)
        Assert.assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5));
        //MathUtil.getFactorial(-5); //hàm @Test chạy hay getF() chạy
                                   //sẽ ném về ngoại lệ NumberFo
    }
    
    //bắt ngoại lệ, xem hàm có ném về ngoại lệ hay không khi n cà chớn
    //có ném, tức là chạy đúng thiết kế => xanh
    @Test
    public void testGetFactorialGivenWrongArgumentThrowsExeptionThrowException_Version_TryCatch() {
        //chủ động kiểm soát ngoại lệ!!!
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //băts try catch là JUnit sẽ ra xanh do đó đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần xuất hiện hay không?
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. N must be between 0...20", e.getMessage());
        }
    }
}
